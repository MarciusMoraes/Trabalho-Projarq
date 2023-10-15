package com.bcopstein.endpointsdemo1.Application;

import org.springframework.stereotype.Component;

import com.bcopstein.endpointsdemo1.Domain.Orcamento;
import com.bcopstein.endpointsdemo1.Domain.ServicoOrcamentos;

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
