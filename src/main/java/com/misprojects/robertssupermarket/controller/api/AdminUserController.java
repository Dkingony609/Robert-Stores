package com.misprojects.robertssupermarket.controller.api;

import com.misprojects.robertssupermarket.controller.api.request.NewUserRequest;
import com.misprojects.robertssupermarket.model.User;
import com.misprojects.robertssupermarket.repository.UserRepository;
import com.misprojects.robertssupermarket.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Ibekason Alexander Onyebuchi
 *
 * Controlls Staff Users
 */

@RequestMapping("api/v1/users")
@RestController
@RequiredArgsConstructor
public class AdminUserController {
    private final AuthUtils authUtils;
    private final UserRepository userRepository;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("")
    public User createUser(@Valid @ModelAttribute NewUserRequest userRequest) {
        return userRepository.save(
                new User().setUsername(userRequest.getUsername()).setPassword(userRequest.getPassword())
        );
    }

    @PatchMapping("{username}")
    public User updateUser(@PathVariable String username, NewUserRequest userRequest) {
        return userRepository.save(
                userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new)
                        // Only update User password
                        .setPassword(userRequest.getPassword())
        );
    }


    @GetMapping("{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }


    @DeleteMapping("{username}")
    public void deleteUser(@PathVariable String username){
        userRepository.delete(userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new));
    }
}
