package com.example.demo.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resources.external.CEP.ResViaCEP;

@RestController
@RequestMapping("/VerificaCEP")
public class CEPController {
    // Injete o serviço ou componente que realiza a verificação de CEP, se
    // necessário

    @GetMapping("/{CEP}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResViaCEP> verificaCEP(@PathVariable("CEP") String CEP) {
        // Chame o serviço que verifica o CEP e retorna um objeto ResViaCEP
        ResViaCEP resViaCEP = new ResViaCEP();
        // Preencha os campos de ResViaCEP com os dados do CEP

        // Exemplo: preencher os campos
        resViaCEP.setCep("12345-678");
        resViaCEP.setLogradouro("Rua Exemplo");
        resViaCEP.setBairro("Bairro Exemplo");
        resViaCEP.setLocalidade("Cidade Exemplo");
        resViaCEP.setUf("EX");

        // Agora, retorne o objeto ResViaCEP no ResponseEntity
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resViaCEP);
    }
}
