package com.swann.Controller;

import com.swann.Model.Post;
import com.swann.Service.PostService;
import com.swann.Service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private ValidationErrorService errorService;

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post, BindingResult result) {
        ResponseEntity<?> error = errorService.ErrorService(result);
        if (error != null){
            return error;
        }

        Post created = postService.saveOrUpdate(post);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
