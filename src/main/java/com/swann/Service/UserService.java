package com.swann.Service;

import com.swann.Model.User;
import com.swann.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> saveOrUpdate(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            HashMap<String, String> exist = new HashMap<>();
            exist.put("message", "Username is already exist");
            return new ResponseEntity<>(exist, HttpStatus.BAD_REQUEST);
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
            try {
                userRepository.save(user);
                HashMap<String, String> exist = new HashMap<>();
                exist.put("message", "Registration successful");
                return new ResponseEntity<>(exist, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                HashMap<String, String> exist = new HashMap<>();
                exist.put("message", "Failed to register");
                return new ResponseEntity<>(exist, HttpStatus.BAD_REQUEST);
            }
        }
    }

}
