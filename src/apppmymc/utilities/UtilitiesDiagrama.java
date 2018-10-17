/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc.utilities;

/**
 *
 * @author JamesCarrillo
 */
public class UtilitiesDiagrama {

    public static int getPosDiagrama(int total_rango, double punto_coordenada, double punto_coordenada_hallar) {
        int pos_coordenada = (int) ((punto_coordenada_hallar * total_rango) / punto_coordenada);
        return pos_coordenada;
    }

    public static int getTotalRango(double cordenada, int tam_porcionlinea, int n) {
        int total_rango = 0;
        double rango = 1.0 / n;
        double it_rango = 0;
        for (int i = 0; i < n; i++) {
            total_rango += tam_porcionlinea;
            it_rango += rango;
            if (cordenada <= it_rango) {
                break;
            }
        }
        return total_rango;
    }

    public static double getPuntoCoordenada(double cordenada, int tam_porcionlinea, int n) {
        double rango = 1.0 / n;
        double it_rango = 0;
        for (int i = 0; i < n; i++) {
            it_rango += rango;
            if (cordenada <= it_rango) {
                break;
            }
        }
        return it_rango;
    }

}
