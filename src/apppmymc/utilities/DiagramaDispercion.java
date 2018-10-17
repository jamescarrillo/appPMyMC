/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc.utilities;

import apppmymc.ParDispersion;
import apppmymc.Utilities;
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
    private final int espacio_izquierda;
    private List<ParDispersion> listPares;

    public DiagramaDispercion(Graphics g, Dimension dimension, int espacio_izquierda, int n, List<ParDispersion> listPares) {
        this.g = g;
        this.dimension = dimension;
        this.espacio_izquierda = espacio_izquierda;
        this.n = n;
        this.listPares = listPares;
    }

    public void construir() {
        //DIBUJAMOS LAS LINEAS DEL PLANO CARTESIANO
        g.drawLine(espacio_izquierda, dimension.height, dimension.width + espacio_izquierda, dimension.height); //ANCHO
        g.drawLine(espacio_izquierda, 0, espacio_izquierda, dimension.height); //ALTO
        int iterador_rango_h = 0;
        int iterador_rango_v;
        int iterador_rango_v_alt = 0;
        int rango_h = dimension.height / n;
        int rango_v = dimension.width / n;
        iterador_rango_v = rango_v;
        double rango_enum = 1.0 / n;
        double it_rango_enum_v = 0;
        for (int i = 0; i < n; i++) {
            g.drawLine(espacio_izquierda, iterador_rango_h, dimension.width + espacio_izquierda, iterador_rango_h);
            g.drawLine(espacio_izquierda + iterador_rango_v, 0, espacio_izquierda + iterador_rango_v, dimension.height);
            /*ENUMERAMOS EL EJE DE LAS Y*/
            g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda - 35, dimension.height - iterador_rango_h);
            /*ENUMERAMOS EL EJE DE LAS X*/
            g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda + iterador_rango_v_alt, dimension.height + 15);

            it_rango_enum_v += rango_enum;
            iterador_rango_h += rango_h;
            iterador_rango_v += rango_v;
            iterador_rango_v_alt += rango_v;
        }
        //ULTIMOS
        g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda - 35, dimension.height - iterador_rango_h + 10);
        g.drawString("" + Utilities.formatearMonedaDiagrama(it_rango_enum_v), espacio_izquierda + iterador_rango_v_alt, dimension.height + 15);
        //Dimension dimensionY = new Dimension(espacio_izquierda, dimension.height - 0);
        //Dimension dimensionX = new Dimension(espacio_izquierda + 0, dimension.height);
        int pos_x;
        int pos_y;
        /*AGREGAMOS LOS PUNTOS DEL DIAGRAMA DE DISPERSION*/
        for (int i = 0; i < listPares.size(); i++) {
            pos_x = UtilitiesDiagrama.getPosDiagrama(UtilitiesDiagrama.getTotalRango(listPares.get(i).getR1(), rango_v, n), UtilitiesDiagrama.getPuntoCoordenada(listPares.get(i).getR1(), rango_v, n), listPares.get(i).getR1());
            pos_y = UtilitiesDiagrama.getPosDiagrama(UtilitiesDiagrama.getTotalRango(listPares.get(i).getR2(), rango_h, n), UtilitiesDiagrama.getPuntoCoordenada(listPares.get(i).getR2(), rango_h, n), listPares.get(i).getR2());
            //pos_y = UtilitiesDiagrama.getPosDiagrama(rango_v, rango_enum, listPares.get(i).getR2());
            System.out.println("" + pos_x + " - " + pos_y);
            g.drawOval(pos_x, pos_y, 5, 5);
            g.drawString("(" + listPares.get(i).getR1() + " " + listPares.get(i).getR2() + ")", pos_x + 10, pos_y + 10);
        }
    }

}
