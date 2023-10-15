package com.bcopstein.endpointsdemo1.Application;

import org.springframework.stereotype.Component;

import com.bcopstein.endpointsdemo1.Domain.Orcamento;
import com.bcopstein.endpointsdemo1.Domain.ServicoOrcamentos;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CriaOrcamento_UC {
    private ServicoOrcamentos servicoOrcamentos;

    @Autowired
    public CriaOrcamento_UC(ServicoOrcamentos servicoOrcamentos) {
        this.servicoOrcamentos = servicoOrcamentos;
    }

    public Orcamento novoOrcamento(String origem, String destino, int peso) {
        return servicoOrcamentos.criaOrcamento(origem, destino, peso);
    }
}
