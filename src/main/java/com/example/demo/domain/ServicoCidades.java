package com.example.demo.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.persistence.CEPRepository;
import com.example.demo.persistence.CityRepository;

@Service
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
