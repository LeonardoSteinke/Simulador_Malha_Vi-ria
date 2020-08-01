/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.model;

import java.util.Random;

/**
 *
 * @author Leonardo Steinke
 */
public class Car extends Thread {

    private int carId;
    private int typeCar;
    private String img;
    //Celula atual
    private Cell currentRoad;
    private Cell oldRoad;


    public Car(int carId, Cell currentRoad) {
        this.carId = carId;
        this.currentRoad = currentRoad;
        this.oldRoad = null;
        setType(5);
    }

    public int getTypeCar() {
        return typeCar;
    }

    public final void setType(int numTypes){
        Random num = new Random();
        this.typeCar = num.nextInt(numTypes) + 1;
    }

    public Cell getCurrentRoad() {
        return currentRoad;
    }

    public void setCurrentRoad(Cell currentRoad) {
        this.currentRoad = currentRoad;
    }
            
    public int getCarId() {
        return carId;
    }

    public void setId(int id) {
        this.carId = id;
    }

    public String getImg() {
        return img;
    }
    
    public Cell getOldRoad() {
        return oldRoad;
    }

    public void setOldRoad(Cell oldRoad) {
        this.oldRoad = oldRoad;
    }

    public void setImg(int direction) {
        this.img = "./assets/Car" + getTypeCar() + "Dir" + direction + ".jpg";
    }

    @Override
    public void run() {
        
    }

}
