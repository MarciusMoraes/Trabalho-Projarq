package com.bcopstein.endpointsdemo1.Domain;

import java.util.List;

//import com.bcopstein.endpointsdemo1.Core.Cidade;

public interface IRepCidades {
    List<Cidade> todas();

    Cidade get(long id);

    Cidade get(String nome);
}