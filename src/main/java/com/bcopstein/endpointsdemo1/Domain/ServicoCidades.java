package com.bcopstein.endpointsdemo1.Domain;

import java.util.List;

import com.bcopstein.endpointsdemo1.Persistence.CEPRepository;
import com.bcopstein.endpointsdemo1.Persistence.CityRepository;

public class ServicoCidades {
    private CityRepository repositorioDeCidades;
    private CEPRepository repositorioDeCEP;

    public ServicoCidades(CityRepository repositorioDeCidades, CEPRepository repositorioDeCEP) {
        this.repositorioDeCidades = repositorioDeCidades;
        this.repositorioDeCEP = repositorioDeCEP;
    }

    public boolean CepAtendido(String cep) {
        return repositorioDeCEP.validaCEP(cep);
    }

    public List<Cidade> todas() {
        return repositorioDeCidades.todas();
    }
}
