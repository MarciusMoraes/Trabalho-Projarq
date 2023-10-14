package com.bcopstein.endpointsdemo1.Domain;

import java.util.List;

public interface IRepCEPs {
    List<String> listaCEPS();

    Boolean validaCEP(String cep);
}
