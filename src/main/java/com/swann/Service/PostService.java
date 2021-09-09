package com.swann.Service;

import com.swann.Model.Post;
import com.swann.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post saveOrUpdate(Post post) {
        return postRepository.save(post);
    }

    public Map<String, List<Post>> getPosts(){
        Map<String, List<Post>> data = new HashMap<>();
        data.put("data", postRepository.findAll());
        return data;
    }

    public Map<String, List<Post>> getPostById(Long id){
        Map<String, List<Post>> data = new HashMap<>();
        data.put("data", postRepository.findByPostId(id));
        return data;
    }
}
