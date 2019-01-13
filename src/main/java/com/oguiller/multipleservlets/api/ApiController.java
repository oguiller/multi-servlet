package com.oguiller.multipleservlets.api;

import java.util.Map;

import com.oguiller.multipleservlets.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    protected Logger logger = LoggerFactory.getLogger(ApiController.class);;

    @Autowired
    Service service;

    @Autowired ApplicationContext applicationContext;

    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/json")
    public String getMessage(){
        logger.info("Getting Message");
        final String message = service.getMessage();
        return message;
    }

    @RequestMapping(value = "/search/message", method = RequestMethod.POST, consumes = "application/json")
    public String setMessage(@RequestBody Map<String, String> message){

        final String message1 = message.get("message");
        logger.info("Getting Message: " + message1);
        return message1;
    }

}
