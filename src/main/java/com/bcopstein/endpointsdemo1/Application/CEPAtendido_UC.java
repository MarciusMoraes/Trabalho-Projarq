package com.bcopstein.endpointsdemo1.Application;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.endpointsdemo1.Domain.ServicoCidades;
import org.springframework.stereotype.Component;

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