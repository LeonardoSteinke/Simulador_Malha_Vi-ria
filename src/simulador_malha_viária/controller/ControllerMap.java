package simulador_malha_viária.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import simulador_malha_viária.controller.observer.ObserverMap;
import simulador_malha_viária.model.Car;
import simulador_malha_viária.model.Cell;
import simulador_malha_viária.model.MonitorRoad;
import simulador_malha_viária.model.MutexRoad;

/**
 *
 * @author Leonardo Steinke
 */
public class ControllerMap {

    private int mapID;
    private int carID;
    private int matrix[][];
    private Cell matrixCell[][];
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
        convertMatrixToCell(false);
    }

    private void convertMatrixToCell(boolean isMutex) {
        matrixCell = new Cell[this.rows][this.collumns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                if (matrix[i][j] != 0) {
                    MutexRoad newMutex;
                    MonitorRoad newMonitor;
                    if (isMutex) {
                        newMutex = new MutexRoad(matrix[i][j], i, j);
                        matrixCell[i][j] = newMutex;
                        roadSpawner(newMutex);
                    } else {
                        newMonitor = new MonitorRoad(matrix[i][j], i, j);
                        matrixCell[i][j] = newMonitor;
                        roadSpawner(newMonitor);
                    }

                } else {
                    matrixCell[i][j] = null;
                }
            }
        }
        
       // setNextCell();
    }
    
    private void setNextCell(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                Cell road = matrixCell[i][j];
                if ( road != null) {
                    switch(road.getDirection()){
                        case 1:
                            road.addNextCell(matrixCell[i][j - 1]);
                        break;
                    }
                }
            }
        }
    }

    private Car createCar(Cell road) {
        Car newCar = new Car(carID++, road);
        setCarImage(newCar);
        return newCar;
    }

    public Icon getImage(int col, int row) {
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

    private void notifyRepaint() {
        for (ObserverMap obs : mapObserver) {
            obs.rePaint();
        }
    }

    private void setCarImage(Car car) {

        int currentDir = car.getCurrentRoad().getDirection();
        int oldDir = 0;
        if (car.getOldRoad() != null) {
            car.getOldRoad().getDirection();
        }
        if (oldDir > 4) {
            switch (currentDir) {

                case 5:
                    car.setImg(1); //cima
                    break;
                case 6:
                    car.setImg(2);//direita
                    break;
                case 7:
                    car.setImg(3);//baixo
                    break;
                case 8:
                    car.setImg(4);//esquerda
                    break;
                case 9:
                    car.setImg(2);
                    break;
                case 10:
                    car.setImg(1);
                    break;
                case 11:
                    car.setImg(3);
                    break;
                case 12:
                    car.setImg(4);
                    break;

            }
        } else {
            car.setImg(currentDir);
        }

    }

    private void spawnCar() {
        List<Cell> roads = new ArrayList();
        for (Cell[] roadLine : matrixCell) {
            for (Cell road : roadLine) {
                if (road != null && road.isIsSpawner()) {
                    roads.add(road);
                }
            }
        }
        Random rand = new Random();
        printCar(roads.get(rand.nextInt(roads.size())));

    }

    private void printCar(Cell road) {
        road.receiveCar(createCar(road));// toda vez que esse método for chamado
        notifyRepaint();
    }

    private void roadSpawner(Cell road) {
        if (road != null) {
            if (road.getPosY() == 0) {
                if (road.getDirection() == 2) {
                    road.setIsSpawner(true);
                }
            } else if (road.getPosY() == (matrix[0].length - 1)) {
                if (road.getDirection() == 4) {
                    road.setIsSpawner(true);
                }
            }

            if (road.getPosX() == 0) {
                if (road.getDirection() == 3) {
                    road.setIsSpawner(true);
                }
            } else if (road.getPosX() == (matrix.length - 1)) {
                if (road.getDirection() == 1) {
                    road.setIsSpawner(true);
                }
            }

        }
    }

    public ImageIcon getRoad(int row, int collumn) {
        if (matrixCell[row][collumn].getCar() == null) {
            return new ImageIcon("./assets/asfalto.jpg");
        }
        return new ImageIcon(matrixCell[row][collumn].getCar().getImg());
    }

    //Se adicionar um parametro tempo, será o valor do Thread.sleep
    public void start(int qtdCars) {
        for (int i = 0; i < qtdCars; i++) {

            spawnCar();

           

        }

    }

}
