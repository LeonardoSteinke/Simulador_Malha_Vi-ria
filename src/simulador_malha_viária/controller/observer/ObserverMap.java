/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.controller.observer;

/**
 *
 * @author Leonardo Steinke
 */
public interface ObserverMap {

    void setQtdCars(int value);

    void setQtdCarsError();

    public void setTable(int[][] matrix, int rows, int collumns);

    public void rePaint();

}
