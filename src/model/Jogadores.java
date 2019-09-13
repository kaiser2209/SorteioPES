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
public class Jogadores {
    private List<Jogador> jogadores = new ArrayList<>();
    
    public Jogador getJogador(int id) {
        return jogadores.get(id);
    }
    
    public Jogador getJogador(String nome) {
        for(Jogador j : jogadores) {
            if (j.getNome().equals(nome)) {
                return j;
            }
        }
        
        return null;
    }
    
    public void add(Jogador jogador) {
        jogadores.add(jogador);
    }
    
    public void remove(Jogador jogador) {
        jogadores.remove(jogador);
    }
    
    public int size() {
        return jogadores.size();
    }
    
    public List<Jogador> getJogadores() {
        return jogadores;
    }
}
