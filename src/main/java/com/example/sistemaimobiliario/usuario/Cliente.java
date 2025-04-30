package com.example.sistemaimobiliario.usuario;

import com.example.sistemaimobiliario.imoveis.Imovel;
import com.example.sistemaimobiliario.utilitario.ListaCorretor;
import com.example.sistemaimobiliario.utilitario.ListaImoveis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Alocar classe BuscaImoveis na classe Cliente
public class Cliente extends Pessoa{
    Scanner sc = new Scanner(System.in);
    private List<Imovel> imoveisFavoritos;
    private List<String> preferencias;
    private List<Imovel> imoveisOrdenados;

    public Cliente(String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.imoveisFavoritos = new ArrayList<>();
        this.preferencias = new ArrayList<>();
        this.imoveisOrdenados = new ArrayList<>();
    }

    public List<Imovel> getImoveisFavoritos() {return imoveisFavoritos;}

    public List<String> getPreferencias() {return preferencias;}

    public List<Imovel> getImoveisOrdenados() {return imoveisOrdenados;}

    public void addImovelFavorito(Imovel imovel) {
        if(!imoveisFavoritos.contains(imovel)){
            imoveisFavoritos.add(imovel);
        }
    }

    public void removeImovelFavorito(Imovel imovel){
        for(Imovel imovelF : imoveisFavoritos){
            if(imovelF.getEndereco().equals(imovel.getEndereco())){
                imoveisFavoritos.remove(imovelF);
                break;
            }
        }
    }

    public void addPreferencia(int preferencia) {
        switch (preferencia) {
            case 1 :
                if(!preferencias.contains("Casa")) {
                    preferencias.add("Casa");
                } else {
                    System.out.println("Preferencia já adicionada(Casa)");
                }
                break;
            case 2 :
                if(!preferencias.contains("Apartamento")){
                    preferencias.add("Apartamento");
                } else {
                    System.out.println("Preferencia já adicionada(Apartamento)");
                }
                break;
            case 3 :
                if(!preferencias.contains("Venda")){
                    preferencias.add("Venda");
                } else {
                    System.out.println("Preferencia já adicionada(Venda)");
                }
                break;
            case 4 :
                if(!preferencias.contains("Alugar")){
                    preferencias.add("Alugar");
                } else {
                    System.out.println("Preferencia já adicionada(Aluguel)");
                }
                break;
            case 5 :
                if(!preferencias.contains("Tem piscina")){
                    preferencias.add("Tem piscina");
                } else {
                    System.out.println("Preferencia já adicionada(Tem piscina)");
                }
                break;
            case 6 :
                if(!preferencias.contains("Tem quintal")){
                    preferencias.add("Tem quintal");
                } else {
                    System.out.println("Preferencia já adiconada(Tem quintal");
                }
                break;
            case 7 :
                if(!preferencias.contains("Tem garagem")){
                    preferencias.add("Tem garagem");
                } else {
                    System.out.println("Preferencia já adicionada(Tem garagem)");
                }
                break;
            case 8 :
                if(!preferencias.contains("Tem elevador")){
                    preferencias.add("Tem elevador");
                } else {
                    System.out.println("Preferencia já adicionada(Tem elevador)");
                }
                break;
            case 9 :
                if(!preferencias.contains("Tem sacada")){
                    preferencias.add("Tem sacada");
                } else {
                    System.out.println("Preferencia já adicionada(Tem sacada)");
                }
                break;
            default :
                System.out.println("Preferência inválida.");
                break;
        }

    }

    public void removePreferencia(){
        int tamanhoPreferencias = preferencias.size();
        System.out.println("Preferencias atuais:");
        for(int i = 0; i < tamanhoPreferencias; i++){
            System.out.println((i + 1) + " - " + preferencias.get(i));
        }
        System.out.println("Escolha a preferencia que deseja remover("+1+" a "+tamanhoPreferencias+"): ");
        int opcao = sc.nextInt();

        if(opcao >= 1 && tamanhoPreferencias > opcao){
            preferencias.remove(opcao - 1);
        } else {
            System.out.println("Opção invalida.");
        }
    }

    public void ordenaImoveisCliente(){
        ListaImoveis listaImoveis = new ListaImoveis();

        for(Imovel imovel : listaImoveis.getListaImoveis()){
            int contd = 0;

            for(String preferencia : preferencias){
                if(imovel.getTags().contains(preferencia)) {
                    contd++;
                }
            }
            if(contd == preferencias.size()){
                imoveisOrdenados.add(imovel);
            }

        }
    }

    public void exibirCorretores(){
        int totalCorretores = ListaCorretor.getListaCorretores().size();
        int totalPaginas = (int) Math.ceil(totalCorretores / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while (true) {
            System.out.println("Pagina "+paginaAtual+"/"+totalPaginas);
            System.out.println("---------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalCorretores);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1) + " - ");
                ListaCorretor.getListaCorretores().get(i).exibirResumo();
            }
            System.out.println("---------------------------------------------------------------");
            System.out.println("Digite o numero do corretor(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if(opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if(opcao.equalsIgnoreCase("S")){
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if(escolha >= 1 && escolha <= fim ){
                        Corretor corretorSelecionado = ListaCorretor.getListaCorretoresPorID(inicio + escolha - 1);
                        corretorSelecionado.exibirDetalhes();
                    }
                }
            }
        }
    }

    public void exibirImoveisPaginados(List<Imovel> imoveisLista){
        int totalImoveis = imoveisLista.size();
        int totalPaginas = (int) Math.ceil(totalImoveis / 10);
        if(totalPaginas == 0) {
            totalPaginas = 1;
        }
        int paginaAtual = 1;

        while (true) {
            System.out.println("Pagina "+ paginaAtual +"/"+ totalPaginas);
            System.out.println("--------------------------------------------------------------");
            int inicio = (paginaAtual - 1) * 10;
            int fim = Math.min(inicio + 10, totalImoveis);

            for(int i = inicio; i < fim; i++){
                System.out.print((i + 1) + " - ");
                imoveisLista.get(i).exibirResumo();
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("Digite o numero do imovel(1 - "+fim+") ou:");
            System.out.println("[N] - Proxima pagina | [P] - Voltar a pagina anterior | [S] - Sair");
            String opcao = sc.nextLine();

            if(opcao.equalsIgnoreCase("N") && paginaAtual < totalPaginas) {
                paginaAtual++;
            } else if (opcao.equalsIgnoreCase("P") && paginaAtual > 1) {
                paginaAtual--;
            } else if (opcao.equalsIgnoreCase("S")) {
                break;
            } else {
                try {
                    int escolha = Integer.parseInt(opcao);
                    if(escolha >= 1 && escolha <= 10 && inicio + escolha - 1 < totalImoveis) {
                        Imovel imovelSelecionado = imoveisLista.get(inicio + escolha - 1);
                        imovelSelecionado.exibirDetalhes();
                        System.out.println("Deseja adicionar ao favoritos? (S/N)");
                        String opcao2 = sc.nextLine();
                        if(opcao2.equalsIgnoreCase("s")) {
                            addImovelFavorito(imovelSelecionado);
                            System.out.println("Imovel adicionado a sua lista de favoritos.");
                        } else if(opcao2.equalsIgnoreCase("n")) {
                            break;
                        }
                    } else {
                        System.out.println("Escolha invalida.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Escolha invalida.");
                }
            }
        }
    }
}
