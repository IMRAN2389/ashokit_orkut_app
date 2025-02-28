package com.myblog1.service;

import com.myblog1.payload.PostDto;

public interface PostService {
    PostDto savePost(PostDto postDto);

    void deletePost(long id);

    void updatePost(long id, PostDto postDto);

    void getPostById(long id);
}
