/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc.utilities;

import apppmymc.ParDispersion;
import apppmymc.Utilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author JamesCarrillo
 */
public class DiagramaDispercion {

    private final Graphics g;
    private final Dimension dimension;
    private final int n;
    private final int n1;
    private final int espacio_izquierda;
    private final List<ParDispersion> listPares;
    private boolean verCoordenadas;

    public DiagramaDispercion(Graphics g, Dimension dimension, int espacio_izquierda, int n, int n1, List<ParDispersion> listPares, boolean verCoordenadas) {
        this.g = g;
        this.dimension = dimension;
        this.espacio_izquierda = espacio_izquierda;
        this.n = n;
        this.n1 = n1;
        this.listPares = listPares;
        this.verCoordenadas = verCoordenadas;
    }

    public void construir() {
        //DIBUJAMOS LAS LINEAS DEL PLANO CARTESIANO
        g.drawLine(espacio_izquierda, dimension.height, dimension.width + espacio_izquierda, dimension.height); //ANCHO
        g.drawLine(espacio_izquierda, 0, espacio_izquierda, dimension.height); //ALTO
        int iterador_rango_h = 0;
        int iterador_rango_v;
        int iterador_rango_v_alt = 0;
        int rango_h = dimension.height / n;
        //int rango_v = dimension.width / n;
        int rango_v = dimension.width / n1;
        iterador_rango_v = rango_v;
        double rango_enum = 1.0 / n;
        double rango_enum_2 = 1.0 / n1;
        double it_rango_enum_v = 0;
        /*
        for (int i = 0; i < n; i++) {
            g.drawLine(espacio_izquierda, iterador_rango_h, dimension.width + espacio_izquierda, iterador_rango_h);
            g.drawLine(espacio_izquierda + iterador_rango_v, 0, espacio_izquierda + iterador_rango_v, dimension.height);
            //ENUMERAMOS EL EJE DE LAS Y
            g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda - 35, dimension.height - iterador_rango_h);
            //ENUMERAMOS EL EJE DE LAS X
            g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda + iterador_rango_v_alt, dimension.height + 15);
            it_rango_enum_v += rango_enum;
            iterador_rango_h += rango_h;
            iterador_rango_v += rango_v;
            iterador_rango_v_alt += rango_v;
        }
         */
        for (int i = 0; i < n; i++) {
            g.drawLine(espacio_izquierda, iterador_rango_h, dimension.width + espacio_izquierda, iterador_rango_h);
            //g.drawLine(espacio_izquierda + iterador_rango_v, 0, espacio_izquierda + iterador_rango_v, dimension.height);
            /*ENUMERAMOS EL EJE DE LAS Y*/
            g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda - 35, dimension.height - iterador_rango_h);
            /*ENUMERAMOS EL EJE DE LAS X*/
            //g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda + iterador_rango_v_alt, dimension.height + 15);
            it_rango_enum_v += rango_enum;
            iterador_rango_h += rango_h;
            //iterador_rango_v += rango_v;
            //iterador_rango_v_alt += rango_v;
        }
        g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda - 35, dimension.height - iterador_rango_h + 10);
        it_rango_enum_v = 0;
        for (int i = 0; i < n1; i++) {
            g.drawLine(espacio_izquierda + iterador_rango_v, 0, espacio_izquierda + iterador_rango_v, dimension.height);
            g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda + iterador_rango_v_alt, dimension.height + 15);
            it_rango_enum_v += rango_enum_2;
            iterador_rango_v += rango_v;
            iterador_rango_v_alt += rango_v;
        }
        //ULTIMOS
        g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda + iterador_rango_v_alt, dimension.height + 15);
        int pos_x;
        int pos_y;
        /*AGREGAMOS LOS PUNTOS DEL DIAGRAMA DE DISPERSION*/
        for (int i = 0; i < listPares.size(); i++) {
            pos_x = UtilitiesDiagrama.getPosDiagrama(UtilitiesDiagrama.getTotalRango(listPares.get(i).getR1(), rango_v, n1), UtilitiesDiagrama.getPuntoCoordenada(listPares.get(i).getR1(), rango_v, n), listPares.get(i).getR1());
            pos_y = UtilitiesDiagrama.getPosDiagrama(UtilitiesDiagrama.getTotalRango(listPares.get(i).getR2(), rango_h, n), UtilitiesDiagrama.getPuntoCoordenada(listPares.get(i).getR2(), rango_h, n), listPares.get(i).getR2());
            g.drawOval(espacio_izquierda + pos_x, dimension.height - pos_y, 5, 5);
            if (verCoordenadas) {
                g.drawString("(" + listPares.get(i).getR1() + "," + listPares.get(i).getR2() + ")", espacio_izquierda + pos_x + 7, dimension.height - pos_y + 7);
            }
        }
        g.setColor(Color.WHITE);
    }

}
