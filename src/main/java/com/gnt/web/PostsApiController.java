package com.gnt.web;

import com.gnt.web.dto.posts.PostsResponseDto;
import com.gnt.web.dto.posts.PostsSaveRequestDto;
import com.gnt.web.dto.posts.PostsUpdateRequestDto;
import com.gnt.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/posts/{id}")
    public PostsResponseDto findPostsById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
