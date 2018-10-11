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

    public static String getSecuenciaBinaria(String cadenaR, double alfa, double beta) {
        String secuencia = "";
        String[] valores_r = cadenaR.split(",");
        for (int i = 0; i < valores_r.length; i++) {
            if (Double.parseDouble(valores_r[i]) >= alfa && Double.parseDouble(valores_r[i]) <= beta) {
                if (i == valores_r.length - 1) {
                    secuencia += "1";
                } else {
                    secuencia += "1,";
                }
            } else {
                if (i == valores_r.length - 1) {
                    secuencia += "0";
                } else {
                    secuencia += "0,";
                }
            }
        }
        return secuencia;
    }
    
    public static int getTamHueco(String cadenabinaria){
        int tamHueco = 0;
        
        return tamHueco;
    }
}
