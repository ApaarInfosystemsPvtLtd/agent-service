package com.pmli.lifeasia.translator.connector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@FeignClient(name="lifeasiaconnectorservice" )
public interface ILifeasiaClient {

    @RequestMapping(method = RequestMethod.PUT ,path = "/pnbmetlife/v1/lifeasia/agent")
    ResponseEntity<String> createAgent(String agentRequest);

    @RequestMapping(method = RequestMethod.POST , path = "/pnbmetlife/v1/lifeasia/agent")
    ResponseEntity<String> modifyAgent(String agentRequest);

    @RequestMapping(method = RequestMethod.PUT ,path = "/pnbmetlife/v1/lifeasia/client")
    ResponseEntity<String> createClient(String clientRequest);

    @RequestMapping(method = RequestMethod.POST, path = "/pnbmetlife/v1/lifeasia/client")
    ResponseEntity<String> modifyClient(String clientRequest);

}
