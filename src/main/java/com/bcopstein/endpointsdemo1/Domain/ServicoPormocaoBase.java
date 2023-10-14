package com.bcopstein.endpointsdemo1.Domain;

public class ServicoPormocaoBase implements ServicoPromocoes {

    @Override
    public double calculaDesconto(String cidadeOrigem, String cidadeDestino, int peso) {
        return 0.0;
    }

    @Override
    public String nomePromocao() {
        return "nenhuma";
    }

}
