package net.messi.earlyadmin.utils;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        e.printStackTrace();
        return "全局异常捕获";
    }

    /**
     * 404处理
     * @return
     * /404.do 可以是一个接口
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
        return (factory -> {
            ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND,"/404.do");
            factory.addErrorPages(errorPage);
        });
    }
}
