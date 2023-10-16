package com.example.demo.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.CidadeAtendidas_UC;

@RestController
@RequestMapping("/CidadesAtendidas")
public class CidadesAtendidasController {
    private final CidadeAtendidas_UC cidadeAtendidas_UC;

    @Autowired
    public CidadesAtendidasController(CidadeAtendidas_UC cidadeAtendidas_UC) {
        this.cidadeAtendidas_UC = cidadeAtendidas_UC;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> ListaCidadesAtendidas() {
        List<String> Cidades = cidadeAtendidas_UC.listaCidades();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Cidades);
    }
}
