package curso.bony.appgaseta.apoio;

public class UtilGasEta {

    public static double calcularGasto(double distancia, double kilometrosPorLitro, double precoPorLitro){


        double numeroDeLitros=  distancia / kilometrosPorLitro; //calcular numero de litros pra uma dada distancia


        return numeroDeLitros*precoPorLitro;
    }
}
