package com.example.demo.domain;

import java.util.List;

public class ServicoPormocaoBase implements ServicoPromocoes {

    @Override
    public double calculaDesconto(String cidadeOrigem, String cidadeDestino, int peso) {
        return 0.0;
    }

    @Override
    public String nomePromocao() {
        return "nenhuma";
    }

    @Override
    public List<String> getListaDePromocoes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListaDePromocoes'");
    }

}
