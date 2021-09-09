package com.swann.Service;

import com.swann.Model.Post;
import com.swann.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post saveOrUpdate(Post post) {
        return postRepository.save(post);
    }
}
