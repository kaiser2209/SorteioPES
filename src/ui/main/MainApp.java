package ui.main;

import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.AreaAtuacao;
import model.Jogadores;
import model.Posicao;
import model.Posicoes;
import util.LerJogadores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario.local
 */
public class MainApp extends Application {
    private MainController mainController;
    private Posicoes posicoes;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("pt", "BR"));
        
        posicoes = new Posicoes();
        posicoes.add(new Posicao("GK", AreaAtuacao.getGol()));
        posicoes.add(new Posicao("RB", AreaAtuacao.getDefesa()));
        posicoes.add(new Posicao("LB", AreaAtuacao.getDefesa()));
        posicoes.add(new Posicao("CB", AreaAtuacao.getDefesa()));
        posicoes.add(new Posicao("DMF", AreaAtuacao.getMeio()));
        posicoes.add(new Posicao("CMF", AreaAtuacao.getMeio()));
        posicoes.add(new Posicao("RMF", AreaAtuacao.getMeio()));
        posicoes.add(new Posicao("LMF", AreaAtuacao.getMeio()));
        posicoes.add(new Posicao("AMF", AreaAtuacao.getMeio()));
        posicoes.add(new Posicao("SS", AreaAtuacao.getAtaque()));
        posicoes.add(new Posicao("CF", AreaAtuacao.getAtaque()));
        posicoes.add(new Posicao("RWF", AreaAtuacao.getAtaque()));
        posicoes.add(new Posicao("LWF", AreaAtuacao.getAtaque()));
        
        abrirTelaPrincipal(primaryStage);
    }
    
    private void abrirTelaPrincipal(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        mainController = (MainController) loader.getController();
        mainController.setPosicoes(posicoes);
        stage.setTitle("Algoritmo Genético");
        stage.setMaximized(false);
        Scene cena = new Scene(root);
        stage.setScene(cena);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
