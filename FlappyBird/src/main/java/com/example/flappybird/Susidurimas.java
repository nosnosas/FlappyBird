package com.example.flappybird;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Susidurimas {
    public boolean susidurimoAtpazinimas(ArrayList<Rectangle> kliutys , Rectangle paukstis){
        for (Rectangle rectangle: kliutys) {
            if(rectangle.getBoundsInParent().intersects(paukstis.getBoundsInParent())){
                return true;
            }
        }
        return  false;
    }
}

