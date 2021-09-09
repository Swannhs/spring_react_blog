package com.swann.Controller;

import com.swann.Model.User;
import com.swann.Service.UserService;
import com.swann.Service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ValidationErrorService errorService;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result){
        ResponseEntity<?> error = errorService.ErrorService(result);
        if (error != null){
            return error;
        }
        return userService.saveOrUpdate(user);
    }
}
