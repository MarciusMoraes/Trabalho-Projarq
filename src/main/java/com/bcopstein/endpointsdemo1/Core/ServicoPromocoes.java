package com.bcopstein.endpointsdemo1.Core;


//Factory

public class ServicoPromocoes {
    private double taxaPromocional;

    public ServicoPromocoes(){
        this.taxaPromocional= 0.05;
    }

    public ServicoPromocoes(double taxaPromocional){
        this.taxaPromocional= taxaPromocional;
    }
    
    public String toString() {
        return "Promoção: " + taxaPromocional;
    }
}
