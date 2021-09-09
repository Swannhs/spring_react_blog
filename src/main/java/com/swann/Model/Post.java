package com.swann.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    @Lob
    private String content;

    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date createdAt;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
