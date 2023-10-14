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
        
        return 
    }

    public Orcamento calculaOrcamento(SolicitaCustoDTO solCusto) {
        // Recupera cidades
        try {
            var consultaOrigem = servicoCEP.pesquisaCEP(solCusto.cepOrigem());
            var consultaDestino = servicoCEP.pesquisaCEP(solCusto.cepDestino());
            // Se um CEP é inválido, retorna null
            if (consultaOrigem == null || consultaDestino == null) {
                return null;
            }
            Cidade origem = repositorioDeCidades.get(consultaOrigem.getLocalidade());
            Cidade destino = repositorioDeCidades.get(consultaDestino.getLocalidade());
            // Se alguma cidade não é atendida, retorna null
            if (origem == null || destino == null) {
                return null;
            }
            // Calcula o orcamento
            long id = 1; // Arrumar na próxima versão
            LocalDateTime data = LocalDateTime.now();
            int peso = solCusto.peso();
            double custoBasico = origem.getCustoBasico() + destino.getCustoBasico();
            double custoAdicional = 0; // Ainda não calcula
            double imposto = custoBasico * 0.05; // Calculo básico
            double desconto = 0.0; // Ainda não calcula
            double custoFinal = custoBasico + custoAdicional + imposto - desconto;
            int diasUteisEntrega = 5; // Ainda não calcula
            Orcamento orcamento = new Orcamento(id, data, origem, destino, peso, custoBasico, custoAdicional, imposto,
                    desconto, custoFinal, diasUteisEntrega);
            repositorioDeOrcamentos.cadastra(orcamento);
            return orcamento;
        } catch (Exception e) {
            // Se der problema de comunicação, retorna null
            return null;
        }
    }

    public List<Orcamento> deUmaData(int dia, int mes, int ano) {
        return repositorioDeOrcamentos.deUmaData(dia, mes, ano);
    }
}
