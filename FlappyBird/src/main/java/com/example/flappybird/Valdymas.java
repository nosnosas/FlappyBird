package com.example.flappybird;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.text.Text;

public class Valdymas implements Initializable {

    AnimationTimer zaidimoCiklas;

    @FXML
    private AnchorPane kliutis;

    @FXML
    private Rectangle paukstis;

    @FXML
    private Text rezultatas;

    private double pagreicioLaikas = 0;
    private int zaidimoLaikas = 0;
    private int rezultatoSkaiciavimas = 0;

    private Paukstis paukstisComponent;
    private Kliutys kliutys;

    ArrayList<Rectangle> kliutyyys = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int suolioAukstis = 50;
        paukstisComponent = new Paukstis(paukstis, suolioAukstis);
        double kliutiesAukstis = 600;
        double kliutiesPlotis = 400;
        kliutys = new Kliutys(kliutis, kliutiesAukstis, kliutiesPlotis);

        zaidimoCiklas = new AnimationTimer() {
            @Override
            public void handle(long l) {
                atnaujinimas();
            }
        };

        krauti();

        zaidimoCiklas.start();
    }

    @FXML
    void mygtukas(KeyEvent event) {
        if(event.getCode() == KeyCode.SPACE){
            paukstisComponent.skridimas();
            pagreicioLaikas = 5;
        }
    }
///space veikimas
    private void atnaujinimas() {
        zaidimoLaikas++;
        pagreicioLaikas++;
        double yDelta = 0.05;
        paukstisComponent.judintiPaukstiY(yDelta * pagreicioLaikas);

        if(taskuSkaiciuoklis(kliutyyys, paukstis)){
            rezultatoSkaiciavimas++;
            rezultatas.setText(String.valueOf(rezultatoSkaiciavimas));
        }

        kliutys.judintiKliutis(kliutyyys);
        if(zaidimoLaikas % 500 == 0){
            kliutyyys.addAll(kliutys.sukurtiKliutis());
        }

        if(paukstisComponent.arPaukstisGyvas(kliutyyys, kliutis)){
            resetintZaidima();
        }
    }
    private void resetintZaidima(){
        paukstis.setY(0);
        kliutis.getChildren().removeAll(kliutyyys);
        kliutyyys.clear();
        zaidimoLaikas = 0;
        pagreicioLaikas = 0;
        rezultatoSkaiciavimas = 0;
        rezultatas.setText(String.valueOf(rezultatoSkaiciavimas));
    }
    private void krauti(){
        kliutyyys.addAll(kliutys.sukurtiKliutis());
    }
    private boolean taskuSkaiciuoklis(ArrayList<Rectangle> kliutys, Rectangle paukstis){
        for (Rectangle kliutyys: kliutys) {
            int paukscioPozicijaX = (int) (paukstis.getLayoutX() + paukstis.getX());
            if(((int)(kliutyys.getLayoutX() + kliutyys.getX()) == paukscioPozicijaX)){
                return true;
            }
        }
        return false;
    }
}
