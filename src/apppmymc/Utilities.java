/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
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

    public static void cambiarTamañoTablaMuestra(JTable tabla) {
        tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(40);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(215);
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

    public static int getTamHueco(String cadenabinaria) {
        int tamHueco = 0;
        String val_tempi;
        String val_tempj;
        for (int i = 0; i < cadenabinaria.length(); i++) {
            val_tempi = cadenabinaria.substring(i, i + 1);
            //SI ES 1 BUSCAMOS EL PROXIMO 1
            if (val_tempi.equals("1")) {
                for (int j = i + 1; j < cadenabinaria.length(); j++) {
                    val_tempj = cadenabinaria.substring(j, j + 1);
                    if (val_tempj.equals("1")) {
                        tamHueco++;
                        break;
                    }
                }
            }
        }
        return tamHueco;
    }

    public static List<Integer> getValoresHuecos(String secuenciabinaria) {
        List<Integer> list = new ArrayList<>();
        String val_tempi;
        String val_tempj;
        String porcionEvaluar0;
        for (int i = 0; i < secuenciabinaria.length(); i++) {
            val_tempi = secuenciabinaria.substring(i, i + 1);
            //SI ES 1 BUSCAMOS EL PROXIMO 1
            if (val_tempi.equals("1")) {
                for (int j = i + 1; j < secuenciabinaria.length(); j++) {
                    val_tempj = secuenciabinaria.substring(j, j + 1);
                    if (val_tempj.equals("1")) {
                        //SACAMOS LA PORCION DE LA CADENA, Y LUEGO SACAMOS CUANTOS 0 HAY
                        porcionEvaluar0 = secuenciabinaria.substring(i, j + 1);
                        list.add(getCantCerosIntervalo(porcionEvaluar0));
                        break;
                    }
                }
            }
        }
        return list;
    }

    public static String getCadenaValoresHuecos(String secuenciabinaria) {
        String res = "-----------------------------------------------------------------------\n";
        res += "> [HUECO] = [TAMAÑO DEL HUECO] \n";
        res += "-----------------------------------------------------------------------\n";
        String val_tempi;
        String val_tempj;
        String porcionEvaluar0;
        for (int i = 0; i < secuenciabinaria.length(); i++) {
            val_tempi = secuenciabinaria.substring(i, i + 1);
            //SI ES 1 BUSCAMOS EL PROXIMO 1
            if (val_tempi.equals("1")) {
                for (int j = i + 1; j < secuenciabinaria.length(); j++) {
                    val_tempj = secuenciabinaria.substring(j, j + 1);
                    if (val_tempj.equals("1")) {
                        //SACAMOS LA PORCION DE LA CADENA, Y LUEGO SACAMOS CUANTOS 0 HAY
                        porcionEvaluar0 = secuenciabinaria.substring(i, j + 1);
                        //System.out.println("> cadena Evaluar-> " + porcionEvaluar0);
                        res += "> " + porcionEvaluar0 + " = " + getCantCerosIntervalo(porcionEvaluar0) + "\n";
                        res += "-----------------------------------------------------------------------\n";
                        //System.out.println("**CEROS-> " + getCantCerosIntervalo(porcionEvaluar0));
                        break;
                    }
                }
            }
        }
        return res;
    }

    private static int getCantCerosIntervalo(String cadena) {
        String[] valores = cadena.split(",");
        int cant = 0;
        for (String valor : valores) {
            if (valor.equals("0")) {
                cant++;
            }
        }
        return cant;
    }

    public static String getCadenaEi(int h, double alfa, double beta, int exponente) {
        String cadena = "";
        cadena += "(" + h + ")(" + formatearDecimal((beta - alfa)) + ")(" + formatearDecimal((1 - (beta - alfa))) + ")^" + exponente;
        return cadena;
    }

    public static double EiCalculado(int h, double alfa, double beta, int exponente) {
        double Ei;
        Ei = h * (beta - alfa) * (Math.pow((1 - (beta - alfa)), exponente));
        return Ei;
    }

    public static String formatearDecimal(double num) {
        DecimalFormat df = new DecimalFormat("#0.00000");
        return df.format(num);
    }

    public static String formatearMoneda(double moneda) {
        //DecimalFormat formateador = new DecimalFormat("###,###,##0.00", new DecimalFormatSymbols(Locale.ENGLISH)); //NO NECESITA SIMBOLOS
        int cantCeros = 5;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        simbolos.setGroupingSeparator(',');
        String formato = "###,###,##0.";
        for (int i = 0; i < cantCeros; i++) {
            formato = formato + "0";
        }
        DecimalFormat formateador = new DecimalFormat(formato, simbolos);
        return formateador.format(moneda);
    }
}
