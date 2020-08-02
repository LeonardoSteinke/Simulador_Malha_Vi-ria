/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.controller;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import simulador_malha_viária.model.Car;

/**
 *
 * @author Gustavo
 */
public class ControllerCar extends Thread {

    private Car car;

    ControllerMap controller = ControllerMap.getIntance();

    public ControllerCar(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (this.car.getCurrentRoad().getNextCell().size() != 0) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
            }
            int numRand = rand.nextInt(2);
            if (this.car.getCurrentRoad().isIsCruzamento()) {
                this.car.getCurrentRoad().getNextCell().get(numRand).receiveCar(car);

                this.car.setOldRoad(this.car.getCurrentRoad());
                this.car.getCurrentRoad().removeCar();
                this.car.setCurrentRoad(this.car.getCurrentRoad().getNextCell().get(numRand));
            } else {
                this.car.getCurrentRoad().getNextCell().get(0).receiveCar(car);

                this.car.setOldRoad(this.car.getCurrentRoad());
                this.car.getCurrentRoad().removeCar();
                this.car.setCurrentRoad(this.car.getCurrentRoad().getNextCell().get(0));
            }
            controller.setCarImage(car);
            controller.notifyRepaint();
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
