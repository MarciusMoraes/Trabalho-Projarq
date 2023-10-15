package com.bcopstein.endpointsdemo1.Domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcopstein.endpointsdemo1.Persistence.BudgetRepository;
import com.bcopstein.endpointsdemo1.Persistence.CityRepository;

@Service
public class ServicoOrcamentos {
    private ServicoCidades servicoCidade;
    private ServicoPromocoes servicoPromocoes;
    private BudgetRepository repositorioDeOrcamentos;

    @Autowired
    public ServicoOrcamentos(BudgetRepository repositorioDeOrcamentos, ServicoCidades servicoCidade,
            ServicoPromocoes servicoPromocoes) {
        this.servicoCidade = servicoCidade;
        this.servicoPromocoes = servicoPromocoes;
        this.repositorioDeOrcamentos = repositorioDeOrcamentos;
    }

    public Orcamento criaOrcamento(String origem, String destino, int peso) {
        double valorFinal;

        if (servicoCidade.CepAtendido(origem) && servicoCidade.CepAtendido(destino)){
            if (origem.equals(destino)){

            } else {
                for(int i=0;i<peso;i++){
                   if(i>3 && i<12){
                        valorFinal += 10;
                   }
                   if(i>12){
                        valorFinal += 15;
                   }
                }
            }
        }
        
        return null;
    }


    public List<Orcamento> deUmaData(int dia, int mes, int ano) {
        return repositorioDeOrcamentos.deUmaData(dia, mes, ano);
    }
}
