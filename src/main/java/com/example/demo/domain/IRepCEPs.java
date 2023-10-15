package com.example.demo.domain;

import java.util.List;

public interface IRepCEPs {
    List<String> listaCEPS();

    Boolean validaCEP(String cep);
}
