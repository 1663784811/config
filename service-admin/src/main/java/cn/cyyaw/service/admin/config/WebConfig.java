package cn.cyyaw.service.admin.config;


import cn.cyyaw.service.admin.config.exception.CustomException;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class WebConfig {
    //===================     异常处理  START
    @Bean
    public HandlerExceptionResolver customException() {
        CustomException exception = new CustomException();
        return exception;
    }

    //===================      类型转换器
    @Bean
    public DateConverter dateConverter() {
        return new DateConverter();
    }



}
