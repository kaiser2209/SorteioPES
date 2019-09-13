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
public class AreaAtuacao {
    private String area;
    
    public AreaAtuacao(String area) {
        this.area = area;
    }
    
    public static AreaAtuacao getGol() {
        return new AreaAtuacao("GOL");
    }
    
    public static AreaAtuacao getDefesa() {
        return new AreaAtuacao("DEFESA");
    }
    
    public static AreaAtuacao getMeio() {
        return new AreaAtuacao("MEIO-CAMPO");
    }
    
    public static AreaAtuacao getAtaque() {
        return new AreaAtuacao("ATAQUE");
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
