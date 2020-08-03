package simulador_malha_viária.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    private int qtdCars;
    private ControllerSpawner spawn;

    public ControllerSpawner getSpawn() {
        return spawn;
    }

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

    public void setMap(int id, boolean isMutex) {
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
        convertMatrixToCell(isMutex);
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

        setNextCell();
    }

    private void setNextCell() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                Cell road = matrixCell[i][j];
                if (road != null) {
                    try {
                        switch (road.getDirection()) {
                            case 1:
                                road.addNextCell(matrixCell[i - 1][j]); //cima

                                break;
                            case 2:
                                road.addNextCell(matrixCell[i][j + 1]); //direita
                                break;
                            case 3:
                                road.addNextCell(matrixCell[i + 1][j]); // baixo
                                break;
                            case 4:
                                road.addNextCell(matrixCell[i][j - 1]); // esquerda
                                break;
                            case 5:
                                road.addNextCell(matrixCell[i - 1][j]); //cima
                                break;
                            case 6:
                                road.addNextCell(matrixCell[i][j + 1]);//direita
                                break;
                            case 7:
                                road.addNextCell(matrixCell[i + 1][j]);//baixo
                                break;
                            case 8:
                                road.addNextCell(matrixCell[i][j - 1]);//esquerda
                                break;
                            case 9:
                                road.addNextCell(matrixCell[i - 1][j]);
                                road.addNextCell(matrixCell[i][j + 1]);
                                break;
                            case 10:
                                road.addNextCell(matrixCell[i - 1][j]);
                                road.addNextCell(matrixCell[i][j - 1]);
                                break;
                            case 11:
                                road.addNextCell(matrixCell[i + 1][j]);
                                road.addNextCell(matrixCell[i][j + 1]);
                                break;
                            case 12:
                                road.addNextCell(matrixCell[i + 1][j]);
                                road.addNextCell(matrixCell[i][j - 1]);
                                break;
                        }
                    } catch (Exception e) {
                        //array fica vazio
                    }
                }
            }
        }

    }

    private Car createCar(Cell road) {
        Car newCar = new Car(carID++, road);
        setCarImage(newCar);
        ControllerCar driver = new ControllerCar(newCar);
        driver.start();
        return newCar;
    }

    public Icon getImage(int col, int row) {
        return new ImageIcon();
    }

    public void mapLoad() {
        notifySetTable(matrix);
    }

    public void setCars(int value) {
        this.qtdCars = value;
        if (value < 0) {
            notifyQtdCarsError();
            return;
        }
        notifyQtdCars(value);

    }

    public synchronized void setCarImage(Car car) {

        int currentDir = car.getCurrentRoad().getDirection();
        int oldDir = 0;
        if (car.getOldRoad() != null) {
            oldDir = car.getOldRoad().getDirection();
        }

        if (currentDir > 4) {
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
                    if (car.getNextDirection() == 0) {
                        car.setImg(1);
                    } else {
                        car.setImg(2);
                    }
                    break;
                case 10:
                    if (oldDir <= 4) {
                        if (car.getNextDirection() == 0) {
                            car.setImg(4);
                        } else {
                            car.setImg(1);
                        }
                    } else {
                        if (car.getNextDirection() == 0) {
                            car.setImg(1);
                        } else {
                            car.setImg(4);
                        }
                    }
                    break;
                case 11:
                    if (oldDir <= 4) {
                        if (car.getNextDirection() == 0) {
                            car.setImg(2);
                        } else {
                            car.setImg(3);
                        }
                    } else {

                        car.setImg(3);

                    }
                    break;
                case 12:
                    if (oldDir <= 4) {
                        if (car.getNextDirection() == 0) {
                            car.setImg(3);
                        } else {
                            car.setImg(4);
                        }
                    } else {

                        car.setImg(4);

                    }
                    break;

            }

        } else {
            car.setImg(currentDir);
        }

    }

    public void spawnCar() {
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
        road.receiveCar(createCar(road));
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

    public int getQtdCars() {
        return qtdCars;
    }

    public void start() {
        notifyDisableButton(true);
        spawn = new ControllerSpawner();
        spawn.start();
    }

    public void stop() {
        notifyDisableButton(false);
        spawn.setOn(false);
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

    public void notifyRepaint() {
        for (ObserverMap obs : mapObserver) {
            obs.rePaint();
        }
    }

    private void notifyDisableButton(boolean on) {
        for (ObserverMap obs : mapObserver) {
            obs.setButton(on);
        }
    }

}
