package curso.bony.appgaseta.apoio;

import java.text.DecimalFormat;

public class UtilGasEta {
    static DecimalFormat df=new DecimalFormat("#.##");

    public static String calcularGasto(double distancia, double kilometrosPorLitro, double precoPorLitro){


        double numeroDeLitros=  distancia / kilometrosPorLitro; //calcular numero de litros pra uma dada distancia

            double gasto= numeroDeLitros*precoPorLitro;
        return df.format(gasto);
    }
}
