package Main;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
		// Atributos
		protected double valorImovel;
		protected double taxaJurosAnual;
		protected int prazoFinanciamento;
		
		// Construtores
		
		public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual ){
			this.valorImovel = valorImovel;
			this.prazoFinanciamento = prazoFinanciamento;
			this.taxaJurosAnual = taxaJurosAnual;
		}
			
			public void outDadosFinais() {
		        System.out.println("O valor do imóvel é: R$ " + getValorImovel());
		        System.out.println("O prazo é de: " + getprazoFinanciamento() + " meses.");
		        System.out.println("A taxa de juros anual é: " + gettaxaJurosAnual() + "%.");
		        System.out.println("A parcela será de: R$ " + pagamentoMensal() + " por mês.");
		        System.out.println("O valor pago ao final do financiamento é: R$ " + pagamentoTotal() + ".");
		}

		
		// método para calcular o pagamento
		public abstract double pagamentoMensal();
	
			public double pagamentoTotal() {
				return pagamentoMensal() * prazoFinanciamento;
			}
			
			
			public double getValorImovel() {
			    return valorImovel;
			}
			
			public int getprazoFinanciamento() {
			    return prazoFinanciamento;
			}
			
			public double gettaxaJurosAnual() {
			    return taxaJurosAnual;
			}

			public double pagMensal() {
				
				return 0;
			}

}
