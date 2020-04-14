package net.messi.earlyadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("net.messi.earlyadmin.mapper")
public class EarlyadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(EarlyadminApplication.class, args);
    }

}
