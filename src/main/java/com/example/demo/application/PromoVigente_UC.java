package com.example.demo.application;

import com.example.demo.domain.ServicoPromocoes;

public class PromoVigente_UC {
    private ServicoPromocoes promocao;

    public PromoVigente_UC(ServicoPromocoes promocao) {
        this.promocao = promocao;
    }

    public ServicoPromocoes retornaPromocao() {
        return promocao;
    }
}
