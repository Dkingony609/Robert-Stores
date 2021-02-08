package com.misprojects.robertssupermarket.config;


import com.misprojects.robertssupermarket.model.User;
import com.misprojects.robertssupermarket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ibekason Alexander Onyebuchi
 */


@Configuration
@RequiredArgsConstructor
public class DatabaseInit implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("mis").isEmpty()){
            userRepository.save(new User().setUsername("mis").setPassword("1234"));
        }
    }
}
