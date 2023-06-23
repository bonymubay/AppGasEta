package curso.bony.appgaseta.apoio;

import java.text.DecimalFormat;

public class UtilGasEta {
    static DecimalFormat df=new DecimalFormat("#.##");

    public static String CalcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal= gasolina*0.70;
        String mensagemDeRetorna;

        if (etanol<= precoIdeal) {
            mensagemDeRetorna="Abastecer com Etanol";

        }else{
            mensagemDeRetorna="Abastecer com Gasolina";
        }
        return mensagemDeRetorna;
    }


}
