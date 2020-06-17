package Modele;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Le renderer des cellules de la table affichée héritant de JLabel et implémentant TableCellRenderer
 */
public class CelluleRenderer extends JLabel implements TableCellRenderer {

    public CelluleRenderer() {
        super();
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object cellValue, boolean isSelected, boolean hasFocus, int row, int column) {
        if (cellValue != null) setIcon(((Evenement) cellValue).getImageEvt());
        else
            setIcon(null);
        return this;
    }
}