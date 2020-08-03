package simulador_malha_viária.model;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo e Leonardo
 */
public class MutexRoad extends Cell {

    private final Semaphore semaforo;

    public MutexRoad(int direction, int posX, int posY) {
        super(direction, posX, posY);
        this.semaforo = new Semaphore(1);
    }

    @Override
    public void receiveCar(Car car) {
        try {
            while (getCar() != null) {
                sleep(300);
            }
            semaforo.acquire();
            setCar(car);
        } catch (InterruptedException ex) {
            Logger.getLogger(MutexRoad.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            semaforo.release();
        }
    }
    @Override
    public void removeCar() {
        try {
            semaforo.acquire();
            setCar(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
