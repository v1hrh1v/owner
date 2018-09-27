package com.hrh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	 /**
     * 创建日期:2018年4月6日<br/>
     * 代码创建:黄聪<br/>
     * 功能描述:错误的处理 <br/>
     * @return
     */
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                //404
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
                //500错误
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
                //400错误
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/json"));
            }
        };
    }

}
