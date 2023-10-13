package com.bcopstein.endpointsdemo1.Core;

import java.util.List;

public interface IRepCEPS {
    List<String> listaCEPS();

    Boolean validaCEP();
}
