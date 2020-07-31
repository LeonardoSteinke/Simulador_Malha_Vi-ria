/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.model;

/**
 *
 * @author Gustavo
 */
public class MonitorRoad extends Cell {

    public MonitorRoad(int direction, int posX, int posY) {
        super(direction, posX, posY);
    }

    @Override
    public synchronized void receiveCar(Car car) {
        try {
            while (getCar() != null) {
                wait();
            }
            setCar(car);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCar() {
        try {
            while (super.car == null) {
                wait();
            }
            super.car = null;
            if (direction > 4) {
                setImage("images/blank.png");
            } else {
                setImage("images/road" + super.direction + ".png");
            }
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
