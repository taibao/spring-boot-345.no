package com.vitas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan //在Spring Boot启动时会扫描@WebServlet，@WebFilter，@WebListener注解，并将该类实例化
public class SpringBootFreeMarkApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootFreeMarkApplication.class,args);
    }


}
