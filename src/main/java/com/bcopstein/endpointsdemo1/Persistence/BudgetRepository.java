package com.bcopstein.endpointsdemo1.Persistence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bcopstein.endpointsdemo1.Core.IRepOrcamento;
import com.bcopstein.endpointsdemo1.Core.Orcamento;

@Repository
public class BudgetRepository implements RepositorioDeOrcamentos {
    private List<Orcamento> orcamentos;

    public BudgetRepository(){
        orcamentos = new LinkedList<>();
    }

    @Override
    public List<Orcamento> todos(){
        return new ArrayList<Orcamento>(orcamentos);
    }

    @Override
    public List<Orcamento> deUmaData(int dia,int mes,int ano){
        return orcamentos.stream()
            .filter(o->o.getData().getYear() == ano)
            .filter(o->o.getData().getMonthValue() == mes)
            .filter(o->o.getData().getDayOfMonth() == dia)
            .toList();
    }

    @Override
    public Orcamento cadastra(Orcamento orcamento){
        orcamentos.add(orcamento);
        return orcamento;
    }
}