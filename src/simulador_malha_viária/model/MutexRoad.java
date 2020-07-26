/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.model;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Gustavo
 */
public class MutexRoad extends Cell {
    
    private Semaphore semaforo;
    

    public MutexRoad(int direction, int posX, int posY) {
        super(direction, posX, posY);
        this.semaforo = new Semaphore(1);
    }
    
    

    @Override
    public void receiveCar(Car car) {
         try {
            semaforo.acquire();
            super.car = car;
            settingImage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }

    @Override
    public void removeCar() {
         try {
            semaforo.acquire();
            super.car = null;
            if (direction > 4) {
                setImage("images/blank.png");
            } else {
                setImage("images/road" + super.direction + ".png");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
    
}
