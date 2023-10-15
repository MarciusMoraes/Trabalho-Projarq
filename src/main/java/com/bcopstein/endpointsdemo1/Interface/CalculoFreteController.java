package com.bcopstein.endpointsdemo1.Interface;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.endpointsdemo1.Application.CEPAtendido_UC;
import com.bcopstein.endpointsdemo1.Application.CidadeAtendidas_UC;
import com.bcopstein.endpointsdemo1.Application.CriaOrcamento_UC;
import com.bcopstein.endpointsdemo1.Application.ListaOrcamentos_UC;
import com.bcopstein.endpointsdemo1.Application.PromoVigente_UC;
import com.bcopstein.endpointsdemo1.Domain.Orcamento;

@RestController
@RequestMapping("/CalculoFrete")
public class CalculoFreteController {
    private CEPAtendido_UC cepAtendido_UC;
    private CidadeAtendidas_UC cidadeAtendidas_UC;
    private CriaOrcamento_UC criaOrcamento_UC;
    private ListaOrcamentos_UC listaOrcamentos_UC;
    private PromoVigente_UC promoVigente_UC;

    @Autowired
    public CalculoFreteController(CidadeAtendidas_UC cidadeAtendidasUC, CEPAtendido_UC cepAtendido_UC,
            PromoVigente_UC promoVigente_UC, CriaOrcamento_UC criaOrcamento_UC,
            ListaOrcamentos_UC listaOrcamentos_UC) {
        this.cidadeAtendidas_UC = cidadeAtendidasUC;
        this.cepAtendido_UC = cepAtendido_UC;
        this.promoVigente_UC = promoVigente_UC;
        this.criaOrcamento_UC = criaOrcamento_UC;
        this.listaOrcamentos_UC = listaOrcamentos_UC;
    }

    @GetMapping("/cidadesAtendidas")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> ListaCidadesAtendidas() {
        List<String> Cidades = cidadeAtendidas_UC.listaCidades();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Cidades);
    }

    @GetMapping("/promocoes")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> Promocoes() {
        List<String> promocoes = promoVigente_UC.retornaPromocao();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(promocoes);
    }

    @GetMapping("/consultaOrcamento/{dia}/{mes}/{ano}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Orcamento>> recuperaOrcamento(@PathVariable("dia") int umDia,
            @PathVariable("mes") int umMes, @PathVariable("ano") int umAno) {
        List<Orcamento> orcamentos = listaOrcamentos_UC.listaOrcamentosPeriodo(umDia, umMes, umAno);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orcamentos);
    }

    @GetMapping("/verificaCEP/{CEP}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> verificaCEP(@PathVariable("CEP") String CEP) {
        String resp = cepAtendido_UC.verificaCEP(CEP);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resp);
    }

    // @PostMapping("/criaOrcamento")
    // @CrossOrigin(origins = "*")
    // public ResponseEntity<Orcamento> calculaOrcamento(@RequestBody final
    // SolicitaCustoDTO solCusto) {
    // CustoTempoEntregaDTO custoEntrega = criaOrcamento_UC.run(solCusto);
    // return ResponseEntity
    // .status(HttpStatus.OK)
    // .body(custoEntrega);
    // }
}
