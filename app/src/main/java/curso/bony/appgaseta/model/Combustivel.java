package curso.bony.appgaseta.model;

public class Combustivel {

    private String nomeDoCombustivel;
    private String recomendacao;
    double precoDeCombustivel;

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public void setNomeDoCombustivel(String nomeDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;
    }

    public double getPrecoDeCombustivel() {
        return precoDeCombustivel;
    }

    public void setPrecoDeCombustivel(double precoDeCombustivel) {
        this.precoDeCombustivel = precoDeCombustivel;
    }
}
