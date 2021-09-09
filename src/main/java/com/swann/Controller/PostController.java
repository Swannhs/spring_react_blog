package com.swann.Controller;

import com.swann.Model.Post;
import com.swann.Service.PostService;
import com.swann.Service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private ValidationErrorService errorService;

    @GetMapping("{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post, BindingResult result) {
        ResponseEntity<?> error = errorService.ErrorService(result);
        if (error != null) {
            return error;
        }

        Post created = postService.saveOrUpdate(post);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
