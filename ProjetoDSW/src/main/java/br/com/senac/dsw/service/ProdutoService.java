/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dsw.service;

import java.util.Map;
import br.com.senac.dsw.model.Produto;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author vinicius
 */
public class ProdutoService {
    
    private static final Map<Long, Produto> MOCK_DATA = new ConcurrentHashMap<Long, Produto>();
            
    private static long proximoId = 13L;
    
    static {
        MOCK_DATA.put(proximoId, v);
    }
            
}
