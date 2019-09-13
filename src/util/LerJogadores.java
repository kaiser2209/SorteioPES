/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.Jogador;
import model.Jogadores;
import model.Posicao;
import model.Posicoes;

/**
 *
 * @author usuario.local
 */
public class LerJogadores {
    private Jogadores jogadores = new Jogadores();
    
    public LerJogadores(File arquivo, Posicoes posicoes) throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(arquivo);
        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();
        for (int i = 0; i < linhas; i++) {
            String valor = sheet.getCell(0, i).getContents();
            if (!(valor.equals("Jogador") || valor.equals(""))) {
                String nome = new String(sheet.getCell(0, i).getContents().getBytes("Utf-8"), "ISO-8859-1");
                String posicao = sheet.getCell(4, i).getContents();
                int overall = Integer.parseInt(sheet.getCell(5, i).getContents());
                Jogador j = new Jogador(nome, posicoes.getPosicao(posicao), overall);
                //System.out.println(nome + " " + posicao);
                jogadores.add(j);
            }
        }
        
        workbook.close();
    }
    
    public Jogadores get() {
        return this.jogadores;
    }
}
