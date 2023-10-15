package com.example.demo.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.IRepCEPs;

@Repository
public class CEPRepository implements IRepCEPs {
    private List<String> listaCEP;

    @Override
    public List<String> listaCEPS() {
        return listaCEP;
    }

    @Override
    public Boolean validaCEP(String cep) {
        return true;
    }
}
