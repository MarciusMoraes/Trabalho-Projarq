package main.java.com.bcopstein.endpointsdemo1.Core;

import java.util.List;

import com.bcopstein.endpointsdemo1.Core.Cidade;

public interface IRepCidades{
    List<Cidade> todas();
    Cidade get(long id);
    Cidade get(String nome);
}