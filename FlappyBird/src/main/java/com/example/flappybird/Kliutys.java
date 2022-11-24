package com.example.flappybird;


import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Kliutys {

    private AnchorPane kliutis;
    private double kliutiesAukstis;
    private double kliutiesPlotis;
    Random random = new Random();

    public Kliutys(AnchorPane kliutis, double kliutiesAukstis, double kliutiesPlotis) {
        this.kliutis = kliutis;
        this.kliutiesAukstis = kliutiesAukstis;
        this.kliutiesPlotis = kliutiesPlotis;
    }

    public ArrayList<Rectangle> sukurtiKliutis() {

        int plotis = 45;
        double xPozicija = kliutiesPlotis;
        double space = 200;
        double virsausAukstis = random.nextInt((int) (kliutiesAukstis - space - 100)) + 50;
        double apaciosAukstis = kliutiesAukstis - space - virsausAukstis;
        Rectangle staciakampioVirsus = new Rectangle(xPozicija, 0, plotis, virsausAukstis);
        Rectangle staciakampioApacia = new Rectangle(xPozicija, virsausAukstis + space, plotis, apaciosAukstis);

        kliutis.getChildren().addAll(staciakampioVirsus, staciakampioApacia);
        return new ArrayList<>(Arrays.asList(staciakampioVirsus, staciakampioApacia));
    }

    private void judintiStaciakampi(Rectangle rectangle) {
        rectangle.setX(rectangle.getX() - 0.75);
    }

    public void judintiKliutis(ArrayList<Rectangle> kliutys) {

        ArrayList<Rectangle> uzEkrano = new ArrayList<>();

        for (Rectangle rectangle : kliutys) {
            judintiStaciakampi(rectangle);

            if (rectangle.getX() <= -rectangle.getWidth()) {
                uzEkrano.add(rectangle);
            }
        }
        kliutys.removeAll(uzEkrano);
        kliutis.getChildren().removeAll(uzEkrano);
    }
}

