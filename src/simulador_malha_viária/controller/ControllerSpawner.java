package simulador_malha_viária.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ControllerSpawner extends Thread {

    ControllerMap controller = ControllerMap.getIntance();

    private boolean on = true;

    private int totalCars = 0;

    public void removeCar() {
        this.totalCars--;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public void run() {
        while (on) {

            while (totalCars < controller.getQtdCars()) {
                controller.spawnCar();
                totalCars++;
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
            }
//            for (int i = 0; i < controller.getQtdCars(); i++) {
//                controller.spawnCar();
//                totalCars++;
//                try {
//                    sleep(500);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }

        }
    }

}
