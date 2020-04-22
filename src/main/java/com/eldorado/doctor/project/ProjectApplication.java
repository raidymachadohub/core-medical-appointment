package com.eldorado.doctor.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class }) //Not Security
@RestController
public class ProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @GetMapping("/")
    public String Home(){
        return "<p style=\"text-align: center;\">&nbsp;</p>\n" +
                "<ul>\n" +
                "<li style=\"color: #5e9ca0;\">/api/doctor/</li>\n" +
                "<li style=\"color: #5e9ca0;\">/api/customer/</li>\n" +
                "</ul>\n" +
                "<p>&nbsp;</p>";
    }

}
