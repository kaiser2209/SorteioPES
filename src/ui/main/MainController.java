/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.Jogador;
import model.Jogadores;
import model.Posicoes;
import util.LerJogadores;

/**
 * FXML Controller class
 *
 * @author usuario.local
 */
public class MainController implements Initializable {
    private Posicoes posicoes;
    private Jogadores jogadores;
    private Jogadores jogadoresGOL = new Jogadores();
    private Jogadores jogadoresLD = new Jogadores();
    private Jogadores jogadoresLE = new Jogadores();
    private Jogadores jogadoresZC = new Jogadores();
    private Jogadores jogadoresVOL = new Jogadores();
    private Jogadores jogadoresMC = new Jogadores();
    private Jogadores jogadoresALD = new Jogadores();
    private Jogadores jogadoresALE = new Jogadores();
    private Jogadores jogadoresMAT = new Jogadores();
    private Jogadores jogadoresSA  = new Jogadores();
    private Jogadores jogadoresCA = new Jogadores();
    private Jogadores jogadoresPTD = new Jogadores();
    private Jogadores jogadoresPTE = new Jogadores();

    @FXML
    private Button btnCarregaArquivo;
    @FXML
    private BorderPane principal;
    @FXML
    private Label lblJogadores;
    @FXML
    private Label lblTotGOL;
    @FXML
    private Label lblTotLD;
    @FXML
    private Label lblTotLE;
    @FXML
    private Label lblTotZC;
    @FXML
    private Label lblTotVOL;
    @FXML
    private Label lblTotMC;
    @FXML
    private Label lblTotALD;
    @FXML
    private Label lblTotALE;
    @FXML
    private Label lblTotMAT;
    @FXML
    private Label lblTotSA;
    @FXML
    private Label lblTotCA;
    @FXML
    private Label lblTotPTD;
    @FXML
    private Label lblTotPTE;
    @FXML
    private ComboBox<?> cboProxClube;
    @FXML
    private ComboBox<?> cboProxPos;
    @FXML
    private Button btnSortear;
    @FXML
    private Button btnManUtd;
    @FXML
    private Button btnMonaco;
    @FXML
    private Button btnArsenal;
    @FXML
    private Button btnUdinese;
    @FXML
    private Button btnInter;
    @FXML
    private Button btnJuventus;
    @FXML
    private Button btnSaoPaulo;
    @FXML
    private Button btnCeltic;
    @FXML
    private Button btnBayern;
    @FXML
    private Button btnCruzeiro;
    @FXML
    private Button btnMilan;
    @FXML
    private Button btnPSG;
    @FXML
    private Button btnBarcelona;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void carregarArquivo(ActionEvent event) throws IOException, BiffException {
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Arquivos XLS (*.xls)", "*.xls");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showOpenDialog((Stage) principal.getScene().getWindow());
        
        if (file == null) {
            return;
        }
        
        //String arquivo = "C:\\Users\\usuario.local\\Documents\\Tutoriais\\jogadores.xls";
        LerJogadores leituraJogadores = new LerJogadores(file, posicoes);
        
        jogadores = leituraJogadores.get();
        System.out.println("" + jogadores.size());
        System.out.println(jogadores.getJogador(0).getOverall());
        carregaJogadores(jogadores.getJogadores());
    }
    
    public void setPosicoes(Posicoes posicoes) {
        this.posicoes = posicoes;
    }
    
    private void carregaJogadores(List<Jogador> jogadores) {
        for(Jogador j : jogadores) {     
            if (j.getPosicao().getPos().equals("GK")) {
                jogadoresGOL.add(j);
            } else if (j.getPosicao().getPos().equals("RB")) {
                jogadoresLD.add(j);
            } else if (j.getPosicao().getPos().equals("LB")) {
                jogadoresLE.add(j);
            } else if (j.getPosicao().getPos().equals("CB")) {
                jogadoresZC.add(j);
            } else if (j.getPosicao().getPos().equals("DMF")) {
                jogadoresVOL.add(j);
            } else if (j.getPosicao().getPos().equals("CMF")) {
                jogadoresMC.add(j);
            } else if (j.getPosicao().getPos().equals("RMF")) {
                jogadoresALD.add(j);
            } else if (j.getPosicao().getPos().equals("LMF")) {
                jogadoresALE.add(j);
            } else if (j.getPosicao().getPos().equals("AMF")) {
                jogadoresMAT.add(j);
            } else if (j.getPosicao().getPos().equals("SS")) {
                jogadoresSA.add(j);
            } else if (j.getPosicao().getPos().equals("CF")) {
                jogadoresCA.add(j);
            } else if (j.getPosicao().getPos().equals("RWF")) {
                jogadoresPTD.add(j);
            } else if (j.getPosicao().getPos().equals("LWF")) {
                jogadoresPTE.add(j);
            } 
        }
        
        lblJogadores.setText(jogadores.size() + " jogadores carregados!");
        lblTotGOL.setText(jogadoresGOL.size() + " goleiros");
        lblTotLD.setText(jogadoresLE.size() + " laterais esquerdos");
        lblTotLE.setText(jogadoresLD.size() + " laterais direitos");
        lblTotZC.setText(jogadoresZC.size() + " zagueiros");
        lblTotVOL.setText(jogadoresVOL.size() + " volantes");
        lblTotMC.setText(jogadoresMC.size() + " meias centrais");
        lblTotALD.setText(jogadoresALD.size() + " meias direitos");
        lblTotALE.setText(jogadoresALE.size() + " meias esquerdos");
        lblTotMAT.setText(jogadoresMAT.size() + " meias atacantes");
        lblTotSA.setText(jogadoresSA.size() + " segundos atacantes");
        lblTotCA.setText(jogadoresCA.size() + " centroavantes");
        lblTotPTD.setText(jogadoresPTD.size() + " pontas direitas");
        lblTotPTE.setText(jogadoresPTE.size() + " pontas esquerdas");
    }

    @FXML
    private void realizarSorteio(ActionEvent event) {
    }

    @FXML
    private void mostraJogadores(ActionEvent event) {
    }
}
 