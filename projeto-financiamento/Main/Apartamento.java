package Main;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
	
		//Atributos do apartamento:
	    private int vagaNaGaragem;
	    private int numeracaoDoAndar;

	    // Construtor
	    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagaNaGaragem, int numeracaoDoAndar) {
	        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
	        this.vagaNaGaragem = vagaNaGaragem;
	        this.numeracaoDoAndar = numeracaoDoAndar;
	    }
	    
	    public double pagamentoMensal() {
	        return (getValorImovel() * (gettaxaJurosAnual() / 100 / 12)) / (1 - Math.pow(1 + (gettaxaJurosAnual() / 100 / 12), -getprazoFinanciamento()));
	    }

	    // Getters para os novos atributos::
	    public int getvagaNaGaragem() {
	        return vagaNaGaragem;
	    }

	    public int getnumeracaoDoAndar() {
	        return numeracaoDoAndar;
	    }
}
