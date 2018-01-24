package fangcheng.springframework.lab.springboot.custom.annotation;

import fangcheng.springframework.lab.springboot.custom.annotation.annotation.PropertyBean;
import org.apache.ibatis.annotations.Property;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;




@PropertyBean ( name = "simplebean", location = "classpath:common.properties")

@SpringBootApplication
@MapperScan("fangcheng.springframework.lab.springboot.custom.annotation.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
