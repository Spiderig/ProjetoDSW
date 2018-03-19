
package br.com.senac.dsw.dao;

import br.com.senac.dsw.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Igor
 */
public class DAOProduto {
     public static Long create(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco_compra, preco_venda, quantidade, dt_cadastro) VALUES (?, ?, ?, ?, ?, ?)";
        Long id = null;
        try (Connection connection = Conexao.getConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, produto.getNome());
                statement.setString(2, produto.getDescricao());
                statement.setDouble(3, produto.getPrecoCompra());
                statement.setDouble(4, produto.getPrecoVenda());
                statement.setInt(5, produto.getQuantidade());
                statement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                
                statement.executeUpdate();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        id = generatedKeys.getLong(1);
                        produto.setId(id);
                    }
                }
                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                System.err.println(ex.getMessage());
                return -1l;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return id;
    }

    public static Produto read(Long id) {
        String sql = "SELECT id, nome, descricao, preco_compra, preco_venda, quantidade, dt_cadastro FROM produto WHERE id=?";
        Produto produto = null;
        try (Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            try (ResultSet resultados = statement.executeQuery()) {
                if (resultados.next()) {
                    produto = new Produto();
                    produto.setId(resultados.getLong("id"));
                    produto.setNome(resultados.getString("nome"));
                    produto.setDescricao(resultados.getString("descricao"));
                    produto.setPrecoCompra(resultados.getDouble("preco_compra"));
                    produto.setPrecoVenda(resultados.getDouble("preco_venda"));
                    produto.setQuantidade(resultados.getInt("quantidade"));
                    produto.setDtCadastro(new Date((resultados.getTimestamp("dt_cadastro")).getTime()));
                    produto.setCategorias(DAOCategoria.searchByProdutoId(id));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return produto;
    }

    public static List<Produto> search() {
        String sql = "SELECT id, nome, descricao, preco_compra, preco_venda, quantidade, dt_cadastro FROM produto";
        List<Produto> listaProdutos = new ArrayList<Produto>();
        try (Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {            
            try (ResultSet resultados = statement.executeQuery()) {
                while (resultados.next()) {
                    Produto produto = new Produto();
                    produto.setId(resultados.getLong("id"));
                    produto.setNome(resultados.getString("nome"));
                    produto.setDescricao(resultados.getString("descricao"));
                    produto.setPrecoCompra(resultados.getDouble("preco_compra"));
                    produto.setPrecoVenda(resultados.getDouble("preco_venda"));
                    produto.setQuantidade(resultados.getInt("quantidade"));
                    produto.setDtCadastro(new Date((resultados.getTimestamp("dt_cadastro")).getTime()));
                    produto.setCategorias(DAOCategoria.searchByProdutoId(produto.getId()));
                    listaProdutos.add(produto);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listaProdutos;
    }

    public static boolean update(Produto produto) {
        if (produto != null && produto.getId() > 0) {
            String sql = "UPDATE produto SET  nome=?, descricao=?, preco_compra=?, preco_venda=?, quantidade=? WHERE id=?";
            try (Connection connection = Conexao.getConnection()) {
                connection.setAutoCommit(false);
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, produto.getNome());
                    statement.setString(2, produto.getDescricao());
                    statement.setDouble(3, produto.getPrecoCompra());
                    statement.setDouble(4, produto.getPrecoVenda());
                    statement.setInt(5, produto.getQuantidade());
                    statement.setLong(6, produto.getId());

                    statement.execute();
                    connection.commit();
                } catch (SQLException ex) {
                    connection.rollback();
                    System.err.println(ex.getMessage());
                    return false;
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

    public static boolean delete(Produto produto) {
        if (produto != null && produto.getId() > 0) {
            String sql = "DELETE FROM produto WHERE id=?";
            try (Connection connection = Conexao.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setLong(1, produto.getId());
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
