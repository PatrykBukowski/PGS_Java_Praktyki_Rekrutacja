package com.pgs.apteka;

import com.pgs.apteka.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AptekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AptekaApplication.class, args);
    }

}
