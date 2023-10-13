package com.bcopstein.endpointsdemo1.Persistence;

import java.util.List;

import com.bcopstein.endpointsdemo1.Core.Cidade;
import com.bcopstein.endpointsdemo1.Core.IRepCidades;

public class CityRepository implements IRepCidades {
    private List<Cidade> cidades;

    public List<Cidade> todas(){
        return new ArrayList<>(cidades);
    }

    public Cidade get(long id){
        return cidades.stream()
            .filter(c->(c.getId() == id))
            .findAny()
            .orElse(null);
    }

    public Cidade get(String nome){
        return cidades.stream()
            .filter(c->c.getNome().equals(nome))
            .findAny()
            .orElse(null);
    }
}



