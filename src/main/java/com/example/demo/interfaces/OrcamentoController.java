package com.example.demo.interfaces;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.Orcamento;

import com.example.demo.application.ListaOrcamentos_UC;

@RestController
@RequestMapping("/ConsultaOrcamento")
public class OrcamentoController {
    private final ListaOrcamentos_UC listaOrcamentos_UC;

    @Autowired
    public OrcamentoController(ListaOrcamentos_UC listaOrcamentos_UC) {
        this.listaOrcamentos_UC = listaOrcamentos_UC;
    }

    @GetMapping("/{dia}/{mes}/{ano}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Orcamento>> recuperaOrcamento(
            @PathVariable("dia") int umDia, @PathVariable("mes") int umMes, @PathVariable("ano") int umAno) {
        List<Orcamento> orcamentos = listaOrcamentos_UC.listaOrcamentosPeriodo(umDia, umMes, umAno);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orcamentos);
    }
}
