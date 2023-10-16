package com.example.demo.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ServicoPromocaoBase implements ServicoPromocoes {
    private String nomePromocao;

    @Override
    public double calculaDesconto(String cidadeOrigem, String cidadeDestino, int peso) {
        return 0.0;
    }

    @Override
    public String getNomePromocao() {
        return nomePromocao;
    }

}
