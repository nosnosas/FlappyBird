package com.example.flappybird;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Paukstis {

    private Rectangle paukstis;
    private int suolioAukstis;
    Susidurimas susidurimas = new Susidurimas();

    public Paukstis(Rectangle paukstis, int suolioAukstis) {
        this.paukstis = paukstis;
        this.suolioAukstis = suolioAukstis;
    }

    public void skridimas(){
        double judejimas = -suolioAukstis;
        if(paukstis.getLayoutY() + paukstis.getY() <= suolioAukstis){
            judejimas = -(paukstis.getLayoutY() + paukstis.getY());
        }

        judintiPaukstiY(judejimas);
    }
    public void judintiPaukstiY(double positionChange){
        paukstis.setY(paukstis.getY() + positionChange);
    }

    public boolean arPaukstisGyvas(ArrayList<Rectangle> kliutys, AnchorPane kliutis){
        double paukstisY = paukstis.getLayoutY() + paukstis.getY();

        if(susidurimas.susidurimoAtpazinimas(kliutys, paukstis)){
            return  true;
        }

        return paukstisY >= kliutis.getHeight();
    }
}
