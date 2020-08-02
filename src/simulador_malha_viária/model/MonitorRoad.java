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
        setCar(car);
    }

    @Override
    public void removeCar() {
        super.car = null;
    }
}
