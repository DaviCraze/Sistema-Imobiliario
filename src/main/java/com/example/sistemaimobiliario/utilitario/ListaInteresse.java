package com.example.sistemaimobiliario.utilitario;

public class ListaInteresse<A, B, C> {
    private A p1;
    private B p2;
    private C p3;

    public ListaInteresse(A p1, B p2, C p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public A getPrimeiro(){return p1;}
    public void setPrimeiro(A p1){this.p1 = p1;}

    public B getSegundo(){return p2;}
    public void setSegundo(B p2){this.p2 = p2;}

    public C getTerceiro(){return p3;}
    public void setTerceiro(C p3){this.p3 = p3;}

}
