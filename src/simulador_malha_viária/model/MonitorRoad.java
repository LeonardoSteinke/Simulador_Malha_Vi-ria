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
                wait(1000);
            }
            setCar(car);
        } catch (Exception e) {
        }
    }

    @Override
    public synchronized void removeCar() {
        super.car = null;
    }
}
