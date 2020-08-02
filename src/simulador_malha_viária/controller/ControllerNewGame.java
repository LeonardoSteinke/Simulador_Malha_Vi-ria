/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.controller;

import java.util.ArrayList;
import java.util.List;
import simulador_malha_viária.controller.observer.ObserverNewGame;
import simulador_malha_viária.controller.observer.ObserverMap;

/**
 *
 * @author Leonardo Steinke
 */
public class ControllerNewGame {

    private static ControllerNewGame instance = null;

    public static ControllerNewGame getIntance() {
        if (instance == null) {
            instance = new ControllerNewGame();
        }
        return instance;
    }

    private ControllerNewGame() {

    }

    public void selectMap(int id) {
        ControllerMap control = ControllerMap.getIntance();
        control.setMap(id, true);
        notifyNewGameStart();
    }

    private List<ObserverNewGame> createNewGameObservers = new ArrayList<>();

    public void attachMap(ObserverNewGame obs) {
        this.createNewGameObservers.add(obs);
    }

    public void detach(ObserverMap obs) {
        this.createNewGameObservers.remove(obs);
    }

    private void notifyNewGameStart() {
        for (ObserverNewGame obs : createNewGameObservers) {
            obs.selectMap();
        }
    }

}
