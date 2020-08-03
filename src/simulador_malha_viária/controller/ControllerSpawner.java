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
    private int velocidade = 500;

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
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
            try {
                if (totalCars < controller.getQtdCars()) {
                    controller.spawnCar();
                    totalCars++;
                    sleep(velocidade);
                }
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
