package Main;

//Nome: Ana Luiza de Lima da Rocha.
//Curso: Análise e Desenvolvimento de Sistemas.
//Data: 17/11/24.

import Main.Casa;
import Main.Apartamento;
import Main.Terreno;
import Main.Financiamento;
import Main.Interface;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Interface interfaceUsuario = new Interface();

        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("Informe os dados para o Financiamento de Casa");
        financiamentos.add(new Casa(
                interfaceUsuario.inValor(),
                interfaceUsuario.inPrazo(),
                interfaceUsuario.inTaxa(),
                interfaceUsuario.inTamanhoAreaConst(),
                interfaceUsuario.inTamanhoTerreno()
        ));

        financiamentos.add(new Casa(300000, 250, 8.2, 167, 300));
        financiamentos.add(new Apartamento(250000, 170, 8.8, 3, 4));
        financiamentos.add(new Terreno(120000, 120, 10.0, "Residencial"));

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Detalhes do Financiamento " + (i + 1) + ":");
            financiamentos.get(i).outDadosFinais();
            System.out.println();


            totalImoveis += financiamentos.get(i).getValorImovel();
            totalFinanciamentos += financiamentos.get(i).pagamentoTotal();
        }

        // Saida de dados 
        System.out.println("Total de todos os imóveis: R$ " + totalImoveis);
        System.out.println("Total de todos os financiamentos: R$ " + totalFinanciamentos);

        salvarDadosSerializados(financiamentos, "dados_serializados.txt");

        ArrayList<Financiamento> financiamentosLidos = lerDadosSerializados("dados_serializados.txt");

        System.out.println("\nFinanciamentos lidos do arquivo:");
        for (Financiamento financiamento : financiamentosLidos) {
            financiamento.outDadosFinais();
            System.out.println();
    }
    }

    private static void salvarDadosSerializados(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
            System.out.println("Dados serializados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados serializados: " + e.getMessage());
        }
    }

    private static ArrayList<Financiamento> lerDadosSerializados(String nomeArquivo) {
        ArrayList<Financiamento> financiamentosLidos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            financiamentosLidos = (ArrayList<Financiamento>) ois.readObject();
            System.out.println("Dados serializados lidos com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler dados serializados: " + e.getMessage());
        }
        return financiamentosLidos;
    }
}