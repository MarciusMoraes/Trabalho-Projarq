package com.example.demo.application;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Orcamento;
import com.example.demo.domain.ServicoOrcamentos;

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
