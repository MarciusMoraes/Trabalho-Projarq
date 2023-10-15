package com.example.demo.application;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Orcamento;
import com.example.demo.domain.ServicoOrcamentos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ListaOrcamentos_UC {
    private ServicoOrcamentos servicoOrcamentos;

    @Autowired
    public ListaOrcamentos_UC(ServicoOrcamentos servicoOrcamentos) {
        this.servicoOrcamentos = servicoOrcamentos;
    }

    public List<Orcamento> listaOrcamentosPeriodo(int dia, int mes, int ano) {
        return servicoOrcamentos.deUmaData(dia, mes, ano);
    }
}
