package com.oguiller.multipleservlets.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oguiller.multipleservlets.Service;

@Controller
public class WebController {

    protected Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    Service service;

    @Autowired ApplicationContext applicationContext;

    @RequestMapping("/")
    public ModelAndView getMessage(){
        logger.info("Getting Message");
        final String message = service.getMessage();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", message);
        return mav;
    }



}
