package simulador_malha_viária.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import simulador_malha_viária.controller.observer.ObserverMap;

/**
 *
 * @author Leonardo Steinke
 */
public class ControllerMap {

    private int mapID;
    private int matrix[][];
    private int rows;
    private int collumns;

    private static ControllerMap instance = null;

    public static ControllerMap getIntance() {
        if (instance == null) {
            instance = new ControllerMap();
        }
        return instance;
    }

    private ControllerMap() {

    }

    public int getColumns() {
        return collumns;
    }

    public int getRows() {
        return rows;
    }

    public String getMatrixPosition(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMap(int id) {
        this.mapID = id;
        String arquivo = "./malhas/malha" + mapID + ".txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(arquivo));
            this.rows = Integer.parseInt(in.readLine());
            this.collumns = Integer.parseInt(in.readLine());

            matrix = new int[rows][collumns];
            for (int i = 0; i < rows; i++) {
                String row[] = in.readLine().split("\t");
                for (int j = 0; j < collumns; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public Icon getImage(int col, int row){
        return new ImageIcon();
    }

    public void mapLoad() {
        notifySetTable(matrix);
    }

    public void setCars(int value) {
        if (value < 0) {
            notifyQtdCarsError();
            return;
        }
        notifyQtdCars(value);

    }

    private List<ObserverMap> mapObserver = new ArrayList<>();

    public void attachMap(ObserverMap obs) {
        this.mapObserver.add(obs);
    }

    public void detach(ObserverMap obs) {
        this.mapObserver.remove(obs);
    }

    private void notifyQtdCars(int value) {
        for (ObserverMap obs : mapObserver) {
            obs.setQtdCars(value);
        }
    }

    private void notifyQtdCarsError() {
        for (ObserverMap obs : mapObserver) {
            obs.setQtdCarsError();
        }
    }

    private void notifySetTable(int[][] matrix) {
        for (ObserverMap obs : mapObserver) {
            obs.setTable(matrix, rows, collumns);
        }

    }

}
