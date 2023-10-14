package com.bcopstein.endpointsdemo1.Application;

import com.bcopstein.endpointsdemo1.Domain.ServicoPromocoes;

public class PromoVigente_UC {
    private ServicoPromocoes promocao;

    public PromoVigente_UC(ServicoPromocoes promocao) {
        this.promocao = promocao;
    }

    public ServicoPromocoes retornaPromocao() {
        return promocao;
    }
}
