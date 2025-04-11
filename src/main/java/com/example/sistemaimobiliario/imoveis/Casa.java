package com.example.sistemaimobiliario.imoveis;
import com.example.sistemaimobiliario.usuario.Corretor;

public class Casa extends Imovel{
    private boolean temQuintal;
    private boolean temPiscina;
    private boolean temGaragem;
    private int andar;

    public Casa(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, boolean temQuintal, boolean temGaragem, boolean temPiscina, Corretor corretor, String tipoImovel, String tipoVenda) {
        super(endereco, preco, quartos, banheiros, area, descricao, proprietario, status, corretor, tipoImovel, tipoVenda);
        this.temQuintal = temQuintal;
        this.temGaragem = temGaragem;
        this.temPiscina = temPiscina;
    }

    public Casa(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, boolean temQuintal, boolean temGaragem, boolean temPiscina, int andar, Corretor corretor, String tipoImovel, String tipoVenda) {
        super(endereco, preco, quartos, banheiros, area, descricao, proprietario, status, corretor, tipoImovel, tipoVenda);
        this.temQuintal = temQuintal;
        this.temGaragem = temGaragem;
        this.temPiscina = temPiscina;
        this.andar = andar;
    }

    public boolean isTemQuintal() {return temQuintal;}
    public void setTemQuintal(boolean temQuintal) {this.temQuintal = temQuintal;}

    public boolean isTemGaragem() {return temGaragem;}
    public void setTemGaragem(boolean temGaragem) {this.temGaragem = temGaragem;}

    public boolean isTemPiscina() {return temPiscina;}
    public void setTemPiscina(boolean temPiscina) {this.temPiscina = temPiscina;}

    public int getAndar() {return andar;}
    public void setAndar(int andar) {this.andar = andar;}

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tem Quintal: " + (temQuintal ? "Sim" : "Não"));
        System.out.println("Tem Garagem: " + (temGaragem ? "Sim" : "Não"));
        System.out.println("Tem Piscina: " + (temPiscina ? "Sim" : "Não"));
        System.out.println("Andares: " + andar);
    }
}
