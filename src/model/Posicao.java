/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario.local
 */
public class Posicao {
    private String pos;
    private AreaAtuacao areaAtuacao;
    
    public Posicao(String pos, AreaAtuacao areaAtuacao) {
        this.pos = pos;
        this.areaAtuacao = areaAtuacao;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public AreaAtuacao getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    @Override
    public String toString() {
        return pos;
    }
    
    
    
}
