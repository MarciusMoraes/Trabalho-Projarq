package com.example.demo.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.PromoVigente_UC;

@RestController
@RequestMapping("/Promocoes")
public class PromoVigenteController {
    private final PromoVigente_UC promoVigente_UC;

    @Autowired
    public PromoVigenteController(PromoVigente_UC promoVigente_UC) {
        this.promoVigente_UC = promoVigente_UC;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<String>> Promocoes() {
        List<String> promocoes = (List<String>) promoVigente_UC.retornaPromocao();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(promocoes);
    }
}
