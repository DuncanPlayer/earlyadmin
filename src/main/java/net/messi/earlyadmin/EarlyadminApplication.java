package net.messi.earlyadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("net.messi.earlyadmin.mapper")
public class EarlyadminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EarlyadminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EarlyadminApplication.class);
    }
}
