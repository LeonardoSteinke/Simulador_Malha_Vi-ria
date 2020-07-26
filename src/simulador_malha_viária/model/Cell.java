/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.model;

/**
 *
 * @author Gustavo
 */
public abstract class Cell {

    protected int direction;
    protected Car car;
    protected String image;
    protected int posX;
    protected int posY;

    public Cell(int direction, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    //Esté vai ser o método onde haverá o controle de limite de carros(threads) por caminho (no máximo 1 por vez)
    public abstract void receiveCar(Car car);

    public abstract void removeCar();

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getImage() {
        return image;
    }

    public void settingImage() {
        //verifica se é um caminho ou não
        if (direction != 0) {
            if (direction > 4) {
                //criar uma pasta para adicioanar as imagens do carro
                switch (direction) {
                    case 5:
                        setImageByDirection(1);
                        break;
                    case 6:
                        setImageByDirection(2);
                        break;
                    case 7:
                        setImageByDirection(3);
                        break;
                    case 8:
                        setImageByDirection(4);
                        break;
                    case 9:
                        if (car.getCurrentRoad().getDirection() <= 4) {
                            setImageByDirection(1);
                        } else {
                            setImageByDirection(2);
                        }
                        break;
                    case 10:
                        if (car.getCurrentRoad().getDirection() <= 4) {
                            setImageByDirection(4);
                        } else {
                            setImageByDirection(1);
                        }
                        break;
                    case 11:
                        if (car.getCurrentRoad().getDirection() <= 4) {
                            setImageByDirection(2);
                        } else {
                            setImageByDirection(3);
                        }
                        break;
                    case 12:
                        if (car.getCurrentRoad().getDirection() <= 4) {
                            setImageByDirection(3);
                        } else {
                            setImageByDirection(4);
                        }
                        break;    
                    default:
                        this.image = "/images/cruzamento.png";
                        break;
                }
            } else {
                setImageByDirection(this.direction);
            }
        }

    }

    public void setImage(String image) {
        this.image = image;
    }
    
    private void setImageByDirection(int direction){
        this.image = "/images/" + getCar().getImg() + direction + ".png";
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
