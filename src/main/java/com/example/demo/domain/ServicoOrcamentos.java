package com.example.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.BudgetRepository;
import com.example.demo.persistence.CityRepository;

import java.util.Random;

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
        Random random = new Random();
        LocalDateTime localDateTime = LocalDateTime.now();
        long id= random.nextLong();
        double valorFinal = 0;
        double custoBasico=0;
        double custoAdicional=0;
        Cidade origin = servicoCidade.todas().stream()
        .filter(c -> c.getNome().equals(origem))
        .findAny()
        .orElse(null);
        Cidade destiny= servicoCidade.todas().stream()
        .filter(c -> c.getNome().equals(destino))
        .findAny()
        .orElse(null);
        if (servicoCidade.CepAtendido(origem) && servicoCidade.CepAtendido(destino)) {
            if (origem.equals(destino)) {
                custoBasico= origin.getCustoBasico();
            } else {
                custoBasico= origin.getCustoBasico() + destiny.getCustoBasico();
            }
            for (int i = 0; i < peso; i++) {
                    if (i > 3 && i < 12) {
                        custoAdicional += 10;
                    }
                    if (i > 12) {
                        custoAdicional += 15;
                    }
            }
        }
        valorFinal= custoBasico + custoAdicional;
        double desconto= servicoPromocoes.calculaDesconto(origem, destino, peso);
        Orcamento orcamento = new Orcamento(id, localDateTime, origin, destiny, peso,
        custoBasico, custoAdicional, 0.05 , desconto, valorFinal);
        
        return orcamento;
    }

    public List<Orcamento> deUmaData(int dia, int mes, int ano) {
        return repositorioDeOrcamentos.deUmaData(dia, mes, ano);
    }
}
