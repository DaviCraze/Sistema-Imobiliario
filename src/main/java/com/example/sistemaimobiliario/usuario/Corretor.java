package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corretor extends Pessoa {
    static Scanner sc = new Scanner(System.in);
    private String nomeEmpresa;
    private String cnpj;
    private List<Interesse> interesses;
    private List<Imovel> imoveis;
    private static int contador = 0;
    private String senha;

    public Corretor(String nome, String cpf, String telefone, String email, String cnpj, String nomeEmpresa, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.interesses = new ArrayList<>();
        this.imoveis = new ArrayList<>();
        contador++;
    }
    public String getNomeEmpresa() {return nomeEmpresa;}
    public void setNomeEmpresa(String nomeEmpresa) {this.nomeEmpresa = nomeEmpresa;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public List<Interesse> getInteresses() {return interesses;}

    public List<Imovel> getImoveis() {return imoveis;}
    public void adicionarImovel(Imovel imovel) {
        if(!imoveis.contains(imovel)) {
            imoveis.add(imovel);
        } else {
            System.out.println("Imovel ja esta cadastrado na lista do Corretor!");
        }

    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Nome da Empresa: " + nomeEmpresa);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Entre em contato pelo telefone: " + getTelefone() + "caso esteja interessado(a) pelo imovel");
    }

    public void exibirResumo(){
        System.out.println("Nome da Empresa: "+ nomeEmpresa);
        System.out.println("CNPJ: " + cnpj);
    }

    public void exibirImoveisPaginados(List<Imovel> listaImoveis) {
        int totalImoveis = listaImoveis.size();
        int totalPaginas = (int) Math.ceil(totalImoveis / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while(true){
            System.out.println("Pagina atual: "+paginaAtual+"/"+totalPaginas);
            System.out.println("----------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalImoveis);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1)+" - ");
                listaImoveis.get(i).exibirResumo();
            }
            System.out.println("Digite o numero do imovel(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if(opcao.equalsIgnoreCase("S")) {
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if(escolha >= 1 && escolha <= 10 && inicio + escolha - 1 < totalImoveis) {
                        listaImoveis.get(inicio + escolha - 1).exibirDetalhes();
                    }
                }
            }
        }
    }
}
