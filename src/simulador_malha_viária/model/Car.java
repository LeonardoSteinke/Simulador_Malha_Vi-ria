package simulador_malha_viária.model;

import java.util.Random;

/**
 *
 * @author Leonardo Steinke
 */
public class Car {

    private int carId;
    private int typeCar;
    private String img;
    private int nextDirection;
    private Cell currentRoad;
    private Cell oldRoad;

    public Car(int carId, Cell currentRoad) {
        this.carId = carId;
        this.currentRoad = currentRoad;
        this.nextDirection = 0;
        setType(5);
    }

    public int getNextDirection() {
        return nextDirection;
    }

    public void setNextDirection(int nextDirection) {
        this.nextDirection = nextDirection;
    }

    public int getTypeCar() {
        return typeCar;
    }

    public final void setType(int numTypes){
        Random num = new Random();
        this.typeCar = num.nextInt(numTypes) + 1;
    }

    public Cell getOldRoad() {
        return oldRoad;
    }

    public void setOldRoad(Cell oldRoad) {
        this.oldRoad = oldRoad;
    }

    public Cell getCurrentRoad() {
        return currentRoad;
    }

    public void setCurrentRoad(Cell currentRoad) {
        this.currentRoad = currentRoad;
    }
            
    public int getCarId() {
        return carId;
    }

    public void setId(int id) {
        this.carId = id;
    }

    public String getImg() {
        return img;
    }
    
    public void setImg(int direction) {
        this.img = "./assets/Car" + getTypeCar() + "Dir" + direction + ".jpg";
    }

}
