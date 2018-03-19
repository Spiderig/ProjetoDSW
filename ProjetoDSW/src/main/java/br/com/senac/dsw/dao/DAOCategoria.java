package br.com.senac.dsw.dao;

import br.com.senac.dsw.model.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class DAOCategoria {
    public static Categoria selecionar (Long id){
        String sql = "SELECT id, nome FROM categoria WHERE id=?";
        Categoria categoria = null;
        try (Connection connection = Conexao.getConnection();
                java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try (ResultSet resultados = statement.executeQuery()) {
                if (resultados.next()) {
                    categoria = new Categoria((int) resultados.getLong("id"), resultados.getString("nome"));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return categoria;
    }

    public static List<Categoria> search() {
        String sql = "SELECT id, nome FROM categoria ORDER BY id";
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        try (Connection connection = Conexao.getConnection();
                java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {            
            try (ResultSet resultados = statement.executeQuery()) {
                while (resultados.next()) {
                    Categoria categoria = new Categoria((int) resultados.getLong("id"), resultados.getString("nome"));
                    listaCategoria.add(categoria);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listaCategoria;
    }
    
    public static List<Categoria> searchByProdutoId(Long produtoId) {
        String sql = "SELECT id, nome "
                + "FROM categoria JOIN produto_categoria "
                + "ON categoria.id = produto_categoria.id_categoria "
                + "WHERE produto_categoria.id_produto=? "
                + "ORDER BY id";
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        try (Connection connection = Conexao.getConnection();
                java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, produtoId);
            
            try (ResultSet resultados = statement.executeQuery()) {
                while (resultados.next()) {
                    Categoria categoria = new Categoria((int) resultados.getLong("id"), resultados.getString("nome"));
                    listaCategoria.add(categoria);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listaCategoria;
    }
    
    public static int createRelationship(Long produtoId, List<Long> categoriaIds) {
        String sql = "INSERT INTO produto_categoria (id_produto, id_categoria) VALUES (?, ?)";
        int i = 0;
        for (Long catId: categoriaIds) {
            try (Connection connection = Conexao.getConnection();
                    java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, produtoId);
                statement.setLong(2, catId);
                
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            i++;
        }
        return i;
    }
    
    public static boolean deleteRelationship(Long produtoId) {
        if (produtoId > 0) {
            String sql = "DELETE FROM produto_categoria WHERE id_produto=?";
            try (Connection connection = Conexao.getConnection()) {
                try (java.sql.PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, produtoId);
                    statement.execute();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
    }
