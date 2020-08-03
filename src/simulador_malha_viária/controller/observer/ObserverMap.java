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
    
    public void setButton(boolean on);

    public void velocidadeInvalida();

}
