package cn.cyyaw.spring.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SpringZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringZipkinApplication.class, args);
    }

}
