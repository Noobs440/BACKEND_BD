package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @GetMapping
    public List<User> getAllUsers() {
        return customUserDetailsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return customUserDetailsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = customUserDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return customUserDetailsService.findById(id)
                .map(existingUser -> {
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    existingUser.setUsername(user.getUsername());

                    User updatedUser = customUserDetailsService.save(existingUser);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (customUserDetailsService.findById(id).isPresent()) {
            customUserDetailsService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retourne 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retourne 404 Not Found si l'utilisateur n'existe pas
        }
    }
}