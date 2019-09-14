/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.Button;

/**
 *
 * @author guard
 */
public class Clube {
    private String nome;
    private Jogadores jogadores = new Jogadores();
    private Button botao;
    
    public Clube(String nome, Button botao) {
        this.nome = nome;
        this.botao = botao;
    }
    
    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public void setButton(Button botao) {
        this.botao = botao;
    }
    
    public void updateButtonText() {
        botao.setText(nome + "(" + jogadores.size() + ")");
    }
    
    public Button getButton() {
        return botao;
    }
    
    public Jogadores getJogadores() {
        return jogadores;
    }
}
