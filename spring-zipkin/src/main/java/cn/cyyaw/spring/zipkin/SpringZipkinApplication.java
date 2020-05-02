package cn.cyyaw.spring.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class SpringZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringZipkinApplication.class, args);
    }

}
