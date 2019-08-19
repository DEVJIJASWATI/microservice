package org.apirest;

import org.apirest.Entity.RoleEntity;
import org.apirest.Service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class ApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }

    /*@Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.save(new RoleEntity(null , "USER"));
            accountService.save(new RoleEntity(null, "ADMIN"));
            Stream.of("user1", "user2" , "user3" , "admin").forEach(u ->{
               accountService.saveUser(u , "1234", "1234");
            });
        };
    }*/

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}