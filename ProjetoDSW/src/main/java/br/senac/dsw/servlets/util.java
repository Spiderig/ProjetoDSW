package br.senac.dsw.servlets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class util {
 public static List<Long> parseToArrayLong(String[] categoriaIds) {
        if (categoriaIds.length > 0) {
            List<Long> parse = new ArrayList<>();
            for (String id : categoriaIds) {
                parse.add(Long.parseLong(id));
            }
            return parse;
        } else {
            return null;
        }
    }
    
}
