package com.pmli.lifeasia.translator.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ConsumeLifeAsiaConnector {

    @Autowired
    RestTemplate restTemplate;

    @Value("${lifeasia.service.url}")
    private String lifeAsiaConnectorService = "";

    public ResponseEntity<String> createAgent(String agentRequest) {
        String url = lifeAsiaConnectorService + "/pnbmetlife/v1/lifeasia/agent";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(agentRequest, headers);

        return new ResponseEntity<>(restTemplate.exchange(url,
                HttpMethod.POST, entity, String.class).getBody(), HttpStatus.OK);
    }

    public ResponseEntity<String> createClient(String agentRequest) {
        String url = lifeAsiaConnectorService + "/pnbmetlife/v1/lifeasia/client";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(agentRequest, headers);

        return new ResponseEntity<>(restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class).getBody(), HttpStatus.OK);
    }

    public ResponseEntity<String> modifyAgent(String agentRequest) {
        String url = lifeAsiaConnectorService + "/pnbmetlife/v1/lifeasia/agent";
        return makeHttpCall(agentRequest,url);
    }

    public ResponseEntity<String> modifyClient(String agentRequest) {
        String url = lifeAsiaConnectorService + "/pnbmetlife/v1/lifeasia/client";
        return makeHttpCall(agentRequest,url);
    }

    private ResponseEntity<String> makeHttpCall(String request,String url){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(request, headers);
        return new ResponseEntity<>(restTemplate.exchange(url,
                HttpMethod.POST, entity, String.class).getBody(), HttpStatus.OK);
    }

    public ResponseEntity<String> terminateAgent(String agentRequest) {
        String url = lifeAsiaConnectorService + "/pnbmetlife/v1/lifeasia/agent/terminate";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(agentRequest, headers);

        return new ResponseEntity<>(restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class).getBody(), HttpStatus.OK);
    }

    public ResponseEntity<String> reinstateAgent(String agentRequest) {
        String url = lifeAsiaConnectorService + "/pnbmetlife/v1/lifeasia/agent/reinstate";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(agentRequest, headers);

        return new ResponseEntity<>(restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class).getBody(), HttpStatus.OK);
    }
}
