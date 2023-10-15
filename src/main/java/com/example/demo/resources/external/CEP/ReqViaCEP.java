package com.example.demo.resources.external.CEP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ReqViaCEP {
    public static final String urlbase = "https://viacep.com.br/ws";

    private HttpRequest httpRequest;
    private HttpResponse<String> httpResponse;

    public ReqViaCEP() {
        httpRequest = null;
        httpResponse = null;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public HttpResponse<String> getHttpResponse() {
        return httpResponse;
    }

    public static String montaConsultaHTTP(String urlStr) throws UnsupportedEncodingException {
        StringBuffer consulta = new StringBuffer();
        consulta.append(urlbase);
        consulta.append(urlStr);
        consulta.append("/json");
        return consulta.toString();
    }

    public ResViaCEP submeteConsultaCEP(String urlStr) throws UnsupportedEncodingException {
        var url = ReqViaCEP.montaConsultaHTTP(urlStr);
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.of(1, MINUTES))
                    .build();

            httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();

            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            String json = httpResponse.body();
            ResViaCEP objResp = gson.fromJson(json, ResViaCEP.class);
            return objResp;

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ResViaCEP> submeteConsultaLogradouro(String urlStr) throws UnsupportedEncodingException {
        var url = ReqViaCEP.montaConsultaHTTP(urlStr);
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.of(1, MINUTES))
                    .build();

            httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();

            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            String json = httpResponse.body();
            TypeToken<List<ResViaCEP>> collectionType = new TypeToken<>() {
            };
            List<ResViaCEP> lstResp = gson.fromJson(json, collectionType.getType());
            return lstResp;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
