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
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.Clube;
import model.Jogador;
import model.Jogadores;
import model.Posicao;
import model.Posicoes;
import util.AlertDialog;
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
    private List<Clube> clubes = new ArrayList<>();

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
    private ComboBox<Clube> cboProxClube;
    @FXML
    private ComboBox<Posicao> cboProxPos;
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
    @FXML
    private TextField txtJogadoresSorteio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clubes.add(new Clube("Manchester United", btnManUtd));
        clubes.add(new Clube("Monaco", btnMonaco));
        clubes.add(new Clube("Arsenal", btnArsenal));
        clubes.add(new Clube("Udinese", btnUdinese));
        clubes.add(new Clube("Internazionale", btnInter));
        clubes.add(new Clube("Juventus", btnJuventus));
        clubes.add(new Clube("São Paulo", btnSaoPaulo));
        clubes.add(new Clube("Celtic", btnCeltic));
        clubes.add(new Clube("Bayern", btnBayern));
        clubes.add(new Clube("Cruzeiro", btnCruzeiro));
        clubes.add(new Clube("Milan", btnMilan));
        clubes.add(new Clube("PSG", btnPSG));
        clubes.add(new Clube("Barcelona", btnBarcelona));
        /*
        List<String> clubes = new ArrayList<>();
        clubes.add("Manchester United");
        clubes.add("Monaco");
        clubes.add("Arsenal");
        clubes.add("Udinese");
        clubes.add("Internazionale");
        clubes.add("Juventus");
        clubes.add("São Paulo");
        clubes.add("Celtic");
        clubes.add("Bayern");
        clubes.add("Cruzeiro");
        clubes.add("Milan");
        clubes.add("PSG");
        clubes.add("Barcelona");
*/
        cboProxClube.getItems().addAll(clubes);
        
        cboProxClube.getSelectionModel().select(0);
        
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
        cboProxPos.getItems().addAll(posicoes.getPosicoes());
        
        cboProxPos.getSelectionModel().select(0);
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
        
        atualizarTotalJogadores();
    }

    @FXML
    private void realizarSorteio(ActionEvent event) {
        Random rnd = new Random();
        int sorteado = rnd.nextInt(Integer.parseInt(txtJogadoresSorteio.getText()));
        
        Jogador j;
        int posSelecionada = cboProxPos.getSelectionModel().getSelectedIndex();
        
        switch (posSelecionada) {
            case 0:
                j = jogadoresGOL.getJogador(sorteado);
                break;
            case 1:
                j = jogadoresLD.getJogador(sorteado);
                break;
            case 2:
                j = jogadoresLE.getJogador(sorteado);
                break;
            case 3:
                j = jogadoresZC.getJogador(sorteado);
                break;
            case 4:
                j = jogadoresVOL.getJogador(sorteado);
                break;
            case 5:
                j = jogadoresMC.getJogador(sorteado);
                break;
            case 6:
                j = jogadoresALD.getJogador(sorteado);
                break;
            case 7:
                j = jogadoresALE.getJogador(sorteado);
                break;
            case 8:
                j = jogadoresMAT.getJogador(sorteado);
                break;
            case 9:
                j = jogadoresSA.getJogador(sorteado);
                break;
            case 10:
                j = jogadoresCA.getJogador(sorteado);
                break;
            case 11:
                j = jogadoresPTD.getJogador(sorteado);
                break;
            case 12:
                j = jogadoresPTE.getJogador(sorteado);
                break;
            default:
                j = null;
        }
        
        Optional<ButtonType> confirmacao = AlertDialog.showConfirmMessage("JOGADOR SORTEADO", "Deseja ficar com o jogador?", j.getNome(), Alert.AlertType.CONFIRMATION);

        if (confirmacao.get() == ButtonType.OK) {
            Clube clubeSelecionado = cboProxClube.getSelectionModel().getSelectedItem();
            clubeSelecionado.addJogador(j);
            
            clubeSelecionado.updateButtonText();
            
            atualizarTotalJogadores();
            
            switch (posSelecionada) {
                case 0:
                    jogadoresGOL.remove(j);
                    break;
                case 1:
                    jogadoresLD.remove(j);
                    break;
                case 2:
                    jogadoresLE.remove(j);
                    break;
                case 3:
                    jogadoresZC.remove(j);
                    break;
                case 4:
                    jogadoresVOL.remove(j);
                    break;
                case 5:
                    jogadoresMC.remove(j);
                    break;
                case 6:
                    jogadoresALD.remove(j);
                    break;
                case 7:
                    jogadoresALE.remove(j);
                    break;
                case 8:
                    jogadoresMAT.remove(j);
                    break;
                case 9:
                    jogadoresSA.remove(j);
                    break;
                case 10:
                    jogadoresCA.remove(j);
                    break;
                case 11:
                    jogadoresPTD.remove(j);
                    break;
                case 12:
                    jogadoresPTE.remove(j);
                    break;
                default:
                    j = null;
            }
            
            int selecao = cboProxClube.getSelectionModel().getSelectedIndex();
            if (selecao < 13) {
                selecao ++;
            } else {
                selecao = 0;
            }
            
            cboProxClube.getSelectionModel().select(selecao);
        }
        
        System.out.println(j.getNome());
        
    }

    @FXML
    private void mostraJogadores(ActionEvent event) {
    }
    
    private void atualizarTotalJogadores() {
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
}
 