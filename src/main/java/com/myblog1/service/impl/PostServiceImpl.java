package com.myblog1.service.impl;

import com.myblog1.entity.Post;
import com.myblog1.exception.ResourceNotFound;
import com.myblog1.payload.PostDto;
import com.myblog1.repository.PostRepository;
import com.myblog1.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto savePost(PostDto postDto) {
    Post post =new Post();
    post.setTitle(postDto.getTitle());
    post.setDescription(postDto.getDescription());
    post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);

        PostDto dto =new PostDto();
        dto.setId(savedPost.getId());
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePost(long id, PostDto postDto) {
         postRepository.findById(id).orElseThrow(
                 ()->  new ResourceNotFound("Post not found with id:"+id)
         );
    }

    @Override
    public void getPostById(long id) {
        postRepository
    }
}
