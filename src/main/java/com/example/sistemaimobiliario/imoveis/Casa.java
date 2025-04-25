package com.example.sistemaimobiliario.imoveis;
import com.example.sistemaimobiliario.usuario.Corretor;

public class Casa extends Imovel{
    private boolean temQuintal;
    private boolean temPiscina;
    private boolean temGaragem;
    private int andares;

    public Casa(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, boolean temQuintal, boolean temGaragem, boolean temPiscina, String tipoImovel, String tipoVenda) {
        super(endereco, preco, quartos, banheiros, area, descricao, proprietario, status, tipoImovel, tipoVenda);
        if(temQuintal) {setTags("Tem quintal");}
        if(temPiscina) {setTags("Tem piscina");}
        if(temGaragem) {setTags("Tem garagem");}
    }

    public Casa(String endereco, double preco, int quartos, int banheiros, double area, String descricao, String proprietario, String status, boolean temQuintal, boolean temGaragem, boolean temPiscina, int andar, String tipoImovel, String tipoVenda) {
        super(endereco, preco, quartos, banheiros, area, descricao, proprietario, status, tipoImovel, tipoVenda);
        if(temQuintal) {setTags("Tem quintal");}
        if(temPiscina) {setTags("Tem piscina");}
        if(temGaragem) {setTags("Tem garagem");}
        this.andares = andar;
    }

    public int getAndar() {return andares;}
    public void setAndar(int andar) {this.andares = andar;}

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tem Quintal: "+temQuintal);
        System.out.println("Tem Garagem: "+temGaragem);
        System.out.println("Tem Piscina: "+temPiscina);
        System.out.println("Andares: " + andares);
    }
}
