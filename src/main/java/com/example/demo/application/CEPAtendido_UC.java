package com.example.demo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.ServicoCidades;

@Component
public class CEPAtendido_UC {
    private ServicoCidades servicosCidades;

    @Autowired
    public CEPAtendido_UC(ServicoCidades servicosCidades) {
        this.servicosCidades = servicosCidades;
    }

    public String verificaCEP(String CEP) {
        try {
            var consulta = servicosCidades.CepAtendido(CEP);
            if (!consulta) {
                return "A cidade não é atendida";
            } else {
                return "A cidade é atendida";
            }
        } catch (Exception e) {
            return "excecao";
        }
    }
}