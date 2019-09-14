/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.lista;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Clube;
import model.Jogador;

/**
 * FXML Controller class
 *
 * @author guard
 */
public class ListaJogadoresController implements Initializable {
    private ObservableList<Jogador> dadosTabela;
    private Clube clube;
    @FXML
    private Label lblClube;
    @FXML
    private TableView<Jogador> tblJogadores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configuracaoTabela();
    }    
    
    private void configuracaoTabela() {
        TableColumn<Jogador, String> colPos = new TableColumn("Pos.");
        TableColumn<Jogador, Integer> colOverall = new TableColumn("Overall");
        TableColumn<Jogador, String> colNome = new TableColumn("Nome");
        
        colPos.setCellValueFactory(new PropertyValueFactory<>("posicao"));
        colOverall.setCellValueFactory(new PropertyValueFactory<>("overall"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPos.setStyle( "-fx-alignment: CENTER-LEFT;");
        colOverall.setStyle( "-fx-alignment: CENTER-RIGHT;");
        colNome.setStyle( "-fx-alignment: CENTER-LEFT;");
        
        tblJogadores.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        colPos.setMaxWidth(1f * Integer.MAX_VALUE * 20);
        colOverall.setMaxWidth(1f * Integer.MAX_VALUE * 25);
        colNome.setMaxWidth(1f * Integer.MAX_VALUE * 55);
        
        tblJogadores.getColumns().addAll(colPos, colOverall, colNome);
    }
    
    private void carregarDados() {
        dadosTabela = FXCollections.observableArrayList(clube.getJogadores().getJogadores());
        tblJogadores.setItems(dadosTabela);
    }
    
    public void carregarClube(Clube clube) {
        this.clube = clube;
        lblClube.setText(clube.toString());
        carregarDados();
    }
}
