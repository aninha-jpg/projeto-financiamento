package Main;

	import java.io.Serializable;

	public class Terreno extends Financiamento implements Serializable {
	   // Atributos
	    private String terreno1;

	   // Construtor
	    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String terreno1) {
	        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
	        this.terreno1 = terreno1;
	    }


	    public double pagamentoMensal() {
	        return (getValorImovel() * (gettaxaJurosAnual() / 100 / 12)) / (1 - Math.pow(1 + (gettaxaJurosAnual() / 100 / 12), -getprazoFinanciamento())) * 1.02; 
	    }

	    public String getTipoZona() {
	        return terreno1;
	    }
	}
