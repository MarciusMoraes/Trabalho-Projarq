package com.bcopstein.endpointsdemo1.Domain;

//Strategy  

public interface ServicoPromocoes {

    double calculaDesconto(String cidadeOrigem, String cidadeDestino, int peso);

    String nomePromocao();
}
