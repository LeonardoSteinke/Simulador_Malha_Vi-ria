package simulador_malha_viária.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
/**
 *
 * @author Gustavo
 */
public class ImageRenderer extends DefaultTableCellRenderer{
    


    public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus, int row,int column) {
        JComponent component = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setBorder(null);
        setIcon((ImageIcon) value);
        return this;
    }

}
