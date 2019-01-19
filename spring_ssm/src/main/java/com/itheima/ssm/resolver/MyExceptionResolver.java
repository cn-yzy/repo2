package com.itheima.ssm.resolver;

import com.itheima.ssm.exception.AccountNotFoundException;
import com.itheima.ssm.exception.MoneyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        String exMsg = null;
        MoneyException moneyException;
        AccountNotFoundException accountNotFoundException;
        if (ex instanceof MoneyException){
            moneyException = (MoneyException) ex;
            exMsg = moneyException.getMessage();
        }else if (ex instanceof AccountNotFoundException){
            accountNotFoundException =(AccountNotFoundException) ex;
            exMsg = accountNotFoundException.getMessage();
        }
        mv.addObject("exMsg",exMsg);
        mv.setViewName("error");
        return mv;
    }
}
