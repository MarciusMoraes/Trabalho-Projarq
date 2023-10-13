package com.bcopstein.endpointsdemo1.Core;

public class Orcamento {
    private String enderecoOrigem;
    private String destino;
    private int peso;
    private double custoFinal;

    
    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    
    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    
    public String getDestino() {
        return destino;
    }

    
    public void setDestino(String destino) {
        this.destino = destino;
    }

    
    public int getPeso() {
        return peso;
    }

    
    public void setPeso(int peso) {
        this.peso = peso;
    }

    
    public double getCustoFinal() {
        return custoFinal;
    }

    
    public void setCustoFinal(double custoFinal) {
        this.custoFinal = custoFinal;
    }
}

