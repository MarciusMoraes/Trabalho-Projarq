package com.bcopstein.endpointsdemo1.Domain;

import org.springframework.stereotype.Service;

//Strategy  

@Service
public interface ServicoPromocoes {

    double calculaDesconto(String cidadeOrigem, String cidadeDestino, int peso);

    String nomePromocao();
}
