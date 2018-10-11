/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author James Carrillo
 */
public class Utilities {

    public static void cambiarTamañoTabla(JTable tabla) {
        tabla.getColumnModel().getColumn(0).setPreferredWidth(95);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(180);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);//2=codigo
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//para que se desplace con la barra 
        tabla.doLayout();
    }
    
    public static void centrarCeldasTabla(JTable tabla, int[] columnas) {
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < columnas.length; i++) {
            tabla.getColumnModel().getColumn(columnas[i]).setCellRenderer(render);
        }
    }
}
