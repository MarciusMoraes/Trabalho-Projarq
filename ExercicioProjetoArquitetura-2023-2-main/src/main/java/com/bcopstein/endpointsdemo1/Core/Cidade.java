package com.bcopstein.endpointsdemo1.Core;

public class Cidade {
    private String nome;
    private  double custo;

    public Cidade(String nome, double custo){
        this.nome= nome;
        this.custo= custo;
    }

    public void SetNome(String nome){
        this.nome= nome;
    }

    public void SetCusto(double custo){
        this.custo= custo;
    }

    public String GetNome(){
        return nome;
    }

    public double GetCusto(){
        return custo;
    }

    
}
