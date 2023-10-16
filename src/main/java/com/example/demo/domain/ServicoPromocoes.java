package com.example.demo.domain;

import java.util.List;

import org.springframework.stereotype.Service;

//Strategy  

@Service
public interface ServicoPromocoes {

    double calculaDesconto(String cidadeOrigem, String cidadeDestino, int peso);

    String nomePromocao();

    List<String> getListaDePromocoes();
}
