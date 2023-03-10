package kr.megaptera.assignment.controllers;

import java.util.List;
import kr.megaptera.assignment.application.CreatePostService;
import kr.megaptera.assignment.application.DeletePostService;
import kr.megaptera.assignment.application.GetPostService;
import kr.megaptera.assignment.application.GetPostsService;
import kr.megaptera.assignment.application.UpdatePostService;
import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

  private final GetPostsService getPostsService;
  private final GetPostService getPostService;
  private final CreatePostService createPostService;
  private final UpdatePostService updatePostService;
  private final DeletePostService deletePostService;

  public PostController(
    GetPostsService getPostsService,
    GetPostService getPostService,
    CreatePostService createPostService,
    UpdatePostService updatePostService,
    DeletePostService deletePostService
  ) {
    this.getPostsService = getPostsService;
    this.getPostService = getPostService;
    this.createPostService = createPostService;
    this.updatePostService = updatePostService;
    this.deletePostService = deletePostService;
  }

  // 게시물 전체 조회 API
  @GetMapping
  public List<PostDto> getPostList() {
    return getPostsService.getPostList();
  }

  // 게시물 상세 조회 API
  @GetMapping("/{postId}")
  @ResponseStatus(HttpStatus.CREATED)
  public PostDto getPostDetail(@PathVariable String postId) {
    return getPostService.getById(postId);
  }

  // 게시물 생성 API
  @PostMapping
  public PostDto savePost(@RequestBody PostCreateDto postCreateDto) {
    return createPostService.save(postCreateDto);
  }

  // 게시물 수정 API
  @PatchMapping("/{postId}")
  public PostDto updatePost(
    @PathVariable String postId,
    @RequestBody PostUpdateDto postUpdateDto
  ) {
    return updatePostService.updatePost(postId, postUpdateDto);
  }

  // 게시물 삭제 API
  @DeleteMapping("{postId}")
  public PostDto deletePost(@PathVariable String postId) {
    return deletePostService.deletePost(postId);
  }
}
