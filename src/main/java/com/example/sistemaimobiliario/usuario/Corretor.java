package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;
import com.example.sistemaimobiliario.utilitario.ListaInteresse;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Corretor extends Pessoa {
    static Scanner sc = new Scanner(System.in);
    private String nomeEmpresa;
    private String cnpj;
    private List<Imovel> imoveis;
    private static int contador = 0;
    private String senha;
    private int quantidadeVendas;
    private int quantidadeAlugadas;
    private int quantidadeVendasMes;
    private int quantidadeAlugadasMes;
    private double avaliacao;
    private double somaAvaliacoes = 0;
    private int totalAvaliacoes = 0;
    private List<ListaInteresse<String, Cliente, Imovel>> listaInteresse;

    public Corretor(String nome, String cpf, String telefone, String email, String cnpj, String nomeEmpresa, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.cnpj = cnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.imoveis = new ArrayList<>();
        this.listaInteresse = new ArrayList<>();
        contador++;
        this.quantidadeAlugadas = 0;
        this.quantidadeVendas = 0;
    }
    public String getNomeEmpresa() {return nomeEmpresa;}
    public void setNomeEmpresa(String nomeEmpresa) {this.nomeEmpresa = nomeEmpresa;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public List<Imovel> getImoveis() {return imoveis;}

    public double getAvaliacao() {return avaliacao;}

    public int getQuantidadeVendas() {return quantidadeVendas;}
    public void setQuantidadeVendasMes(int quantidadeVendas) {this.quantidadeVendasMes = quantidadeVendas;}

    public int getQuantidadeAlugadas() {return quantidadeAlugadas;}
    public void setQuantidadeAlugadasMes(int quantidadeAlugadas) {this.quantidadeAlugadasMes = quantidadeAlugadas;}

    public List<ListaInteresse<String, Cliente, Imovel>> getListaInteresse() {return listaInteresse;}
    public void setListaInteresse(ListaInteresse<String, Cliente, Imovel> listaInteresse) {
        if(!this.listaInteresse.contains(listaInteresse)) {
            this.listaInteresse.add(listaInteresse);
        } else {
            System.out.println("Você já mostrou interesse neste imovel");
        }

    }

    public void atualizarAvaliacao(double avaliacao){
        if (avaliacao < 1 || avaliacao > 5) {
            System.out.println("Avaliacao invalida.");
            return;
        }
        somaAvaliacoes += avaliacao;
        totalAvaliacoes++;
        this.avaliacao = somaAvaliacoes / totalAvaliacoes;
    }

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
        System.out.println("Avaliação: " + avaliacao);
    }

    public void exibirResumo(){
        System.out.println("Nome da Empresa: "+ nomeEmpresa);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Avaliacao: "+avaliacao);
    }

    public void exibirResumoVendas(){
        System.out.println("Quantidade de Vendas totais: "+quantidadeVendas);
        System.out.println("Quantidade de Alugadas totais: "+quantidadeAlugadas);
        System.out.println("Quantidade de Vendas esse mes: "+quantidadeVendasMes);
        System.out.println("Quantidade de Alugadas esse mes: "+quantidadeAlugadasMes);
    }

    public void exibirImoveisPaginados() {
        if(imoveis.isEmpty()){
            System.out.println("Nenhum imovel cadastrado na sua conta");
            return;
        }
        int totalImoveis = imoveis.size();
        int totalPaginas = (int) Math.ceil(totalImoveis / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while(true){
            System.out.println("Pagina atual: "+paginaAtual+"/"+totalPaginas);
            System.out.println("-----------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalImoveis);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1)+" - ");
                imoveis.get(i).exibirResumo();
            }
            System.out.println("-----------------------------------------------------------------");
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
                        imoveis.get(inicio + escolha - 1).exibirDetalhes();
                        System.out.println("1 - Voltar");
                        int opcao2 = sc.nextInt();
                        if(opcao2 == 1) {
                            System.out.println("Voltando...");
                        }
                    } else {
                        System.out.println("Escolha invalida.");
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Escolha invalida.");
                }
            }
        }
    }

    public void gerenciarInteressados(){
        if(listaInteresse.isEmpty()){
            System.out.println("Nenhum cliente demonstrou interesse nos seus imoveis.");
            return;
        }

        System.out.println("Lista de Interessados:");
        for(int i = 0; i < listaInteresse.size(); i++){
            ListaInteresse<String, Cliente, Imovel> interesse = listaInteresse.get(i);
            System.out.print((i + 1) + " - ");
            System.out.println("Telefone e Email para contato: "+interesse.getPrimeiro()+", "+interesse.getSegundo().getEmail());
            System.out.println("Imovel no qual Cliente se Interessou: "+interesse.getTerceiro().getDescricao());
            System.out.println();
        }
        while(true) {
            System.out.println("Escolha um interessado para finalizar o processo de compra do imovel(1 - " + listaInteresse.size() + "): ");
            System.out.println("0 - Voltar");
            try {
                int opcao3 = sc.nextInt();
                sc.nextLine();

                if (opcao3 >= 1 && opcao3 <= listaInteresse.size()) {
                    ListaInteresse<String, Cliente, Imovel> interesseSelecionado = listaInteresse.get(opcao3 - 1);
                    interesseSelecionado.getTerceiro().setStatus("Indisponivel");
                    interesseSelecionado.getSegundo().addAvaliacaoCorretores(this);
                    listaInteresse.remove(opcao3 - 1);
                    System.out.println("Processo Finalizado!");
                    if(interesseSelecionado.getTerceiro().getTipoVenda().equals("Alugar")){
                        quantidadeAlugadas++;
                        quantidadeAlugadasMes++;
                    } else if(interesseSelecionado.getTerceiro().getTipoVenda().equals("Venda")){
                        quantidadeVendas++;
                        quantidadeVendasMes++;
                    }
                    break;
                } else if(opcao3 == 0) {
                    break;
                } else {
                    System.out.println("Digite um numero entre 1 e " + listaInteresse.size());
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um numero entre 1 e " + listaInteresse.size());
            }
        }
    }
}
