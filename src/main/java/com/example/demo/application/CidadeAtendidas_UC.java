package com.example.demo.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.ServicoCidades;

@Component
public class CidadeAtendidas_UC {
    private ServicoCidades servicosCidades;

    @Autowired
    public CidadeAtendidas_UC(ServicoCidades servicosCidades) {
        this.servicosCidades = servicosCidades;
    }

    public List<String> listaCidades() {
        return servicosCidades.todas().stream().map(c -> c.getNome()).toList();
    }

}
