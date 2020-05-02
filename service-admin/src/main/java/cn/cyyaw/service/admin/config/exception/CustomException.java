package cn.cyyaw.service.admin.config.exception;

import cn.cyyaw.common.util.WhyException;
import org.apache.shiro.authc.AuthenticationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //判断是否是异步请求
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        if (ex instanceof ConstraintViolationException) {
            mav.addObject("code", WebErrCodeEnum.DATA_ERR_RELATION.getCode());
            mav.addObject("message", WebErrCodeEnum.DATA_ERR_RELATION.getMsg());
        } else if ("The current Subject is not authenticated.  Access denied.".equals(ex.getMessage())) {
            mav.addObject("code", WebErrCodeEnum.WEB_LOGINERR.getCode());
            mav.addObject("message", WebErrCodeEnum.WEB_LOGINERR.getMsg());
            mav.addObject("success", false);
        } else if (ex instanceof AuthenticationException) {
            mav.addObject("code", WebErrCodeEnum.WEB_LOGINERR.getCode());
            mav.addObject("message", WebErrCodeEnum.WEB_LOGINERR.getMsg());
        } else if (ex instanceof WhyException) {
            WhyException whyException = (WhyException) ex;
            mav.addObject("code", whyException.getCode());
            mav.addObject("message", whyException.getMessage());
        } else {
            mav.addObject("code", 500);
            mav.addObject("message", "系统异常");
        }
        return mav;
    }
}
