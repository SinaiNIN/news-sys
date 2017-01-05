package com.news.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sinai on 1/4/17.
 */
@ControllerAdvice
public abstract class BasedController {
    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    @ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public Object exception(Exception e) {
        Map<String, String> msg = new HashMap<>();
        msg.put("msg", "ajax异常哦");
        msg.put("content", e.getMessage());
        return msg;
    }

    @ExceptionHandler()
    public ModelAndView toExceptionPage(Exception e) {
        ModelAndView view = new ModelAndView("error");
        view.addObject("error", e.getMessage());
        return view;
    }
}
