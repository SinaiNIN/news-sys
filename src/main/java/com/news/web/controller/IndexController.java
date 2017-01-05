package com.news.web.controller;

/**
 * Created by sinai on 1/4/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/index")
public class IndexController extends BasedController{

    @RequestMapping(value="/home")
    @ResponseBody
    public String home(){
        return "Welcome home";
    }
}
