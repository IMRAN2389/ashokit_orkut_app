package com.myblog1.controller;

import com.myblog1.payload.PostDto;
import com.myblog1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //http://localhost:8080/api/post
@PostMapping
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto){
    PostDto dto = postService.savePost(postDto);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);//201
}
    //http://localhost:8080/api/post/1
@DeleteMapping("/{id}")
public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is deleted",HttpStatus.OK);
}
    //http://localhost:8080/api/post/1
@PutMapping("/{id}")
public ResponseEntity<PostDto> updatePost(@PathVariable("id") long id,@RequestBody PostDto postDto){
        postService.updatePost(id,postDto);
        return null;
}
@GetMapping("/{id}")
public PostDto getPostById(@PathVariable("id")long id){
        postService.getPostById(id);
}
}
