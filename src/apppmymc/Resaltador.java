/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author James Carrillo
 */
public class Resaltador implements TableCellRenderer {

    private Integer fila;
    private Integer fila_2;
    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    /**
     * Creamos el resaltador indicando que fila se coloreara por defecto
     *
     * @param row
     */
    public Resaltador(Integer row) {
        fila = row;
    }

    public Resaltador(Integer fila, Integer fila_2) {
        this.fila = fila;
        this.fila_2 = fila_2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtenemos la celda que se esta renderizando
        Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Si la celda esta en la fila indicada y no esta seleccionada se coloreara de este modo        
        if (fila.compareTo(row) == 0 | fila_2.compareTo(row) == 0 && isSelected == false) {
            //c.setBackground(Color.decode("#FF88FF"));
            c.setBackground(Color.GREEN);
            c.setForeground(Color.BLACK);
            // Si la celda esta en la fila indicada y esta seleccionada se coloreara de este modo
        } else if (fila.compareTo(row) == 0 | fila_2.compareTo(row) == 0 && isSelected == true) {
            c.setBackground(Color.RED);
            c.setForeground(Color.WHITE);
            // Si la celda no esta en la fila indicada y esta seleccionada se coloreara de este modo
        } else if (fila.compareTo(row) != 0 | fila_2.compareTo(row) != 0 && isSelected == true) {
            c.setBackground(Color.BLUE);
            c.setForeground(Color.WHITE);
            // En los demas casos se coloreara de este modo
        } else {
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }
        /*DEFINIMOS TAMAÑO A LAS TABLAS*/
        table.getColumnModel().getColumn(0).setPreferredWidth(95);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);//2=codigo
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.doLayout();
        // Regresamos la celda para que se agrege a la tabla
        return c;
    }

    /**
     * @return the fila
     */
    public Integer getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(Integer fila) {
        this.fila = fila;
    }

    public Integer getFila_2() {
        return fila_2;
    }

    public void setFila_2(Integer fila_2) {
        this.fila_2 = fila_2;
    }

}
