/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ControllerSpawner extends Thread{
    
    ControllerMap controller = ControllerMap.getIntance();
    
    @Override
    public void run(){
        for (int i = 0; i < controller.getQtdCars(); i++) {
            controller.spawnCar();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControllerSpawner.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
