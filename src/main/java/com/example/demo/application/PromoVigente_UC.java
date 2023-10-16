package com.example.demo.application;

import java.util.List;

import com.example.demo.domain.ServicoPromocoes;

public class PromoVigente_UC {
    private ServicoPromocoes promocao;

    public PromoVigente_UC(ServicoPromocoes promocao) {
        this.promocao = promocao;
    }

    public List<String> retornaPromocao() {
        return promocao.getListaDePromocoes();
    }
}
