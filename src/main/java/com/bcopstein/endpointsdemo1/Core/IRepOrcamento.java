package com.bcopstein.endpointsdemo1.Core;

import java.util.List;


public interface IRepOrcamento {
    List<Orcamento> todos();
    List<Orcamento> deUmaData(int dia, int mes, int ano);
    Orcamento cadastra(Orcamento orcamento);
}