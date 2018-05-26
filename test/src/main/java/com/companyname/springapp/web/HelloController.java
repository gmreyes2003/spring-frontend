package com.companyname.springapp.web;

import com.companyname.springapp.web.model.Login;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/test")
public class HelloController {
    protected final Log logger = LogFactory.getLog(HelloController.class);

    public HelloController() {
        logger.info("--> Start HelloController!");
    }

    @RequestMapping(value = "/nano")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Returning hello view");
        ModelAndView model = new ModelAndView("hello");
        model.addObject("tittle", "Spring MVC - Hello Test");
        model.addObject("msg", "Login!");
        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/form", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFormData(HttpServletRequest request, HttpServletResponse response, @RequestBody final Login login) throws ServletException, IOException {
        logger.info("Into getFormData Sprng method");
        logger.info(login.toString());
        login.setMail("gmreyes2003@hotmail.com");
        Gson gson = new Gson();
        String result = gson.toJson(login);
        return result;
    }
}
