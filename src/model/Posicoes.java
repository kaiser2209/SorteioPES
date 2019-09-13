/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author usuario.local
 */
public class Posicoes {
    private List<Posicao> posicoes = new ArrayList<>();
    
    public Posicao getPosicao(String pos) {
        for (Posicao p : posicoes) {
            if (p.getPos().equals(pos)) {
                return p;
            }
        }
        
        return null;
    }
    
    public void add(Posicao p) {
        posicoes.add(p);
    }
    
    public void remove(Posicao p) {
        posicoes.remove(p);
    }
    
    public List<Posicao> getPosicoes() {
        return posicoes;
    }
}
