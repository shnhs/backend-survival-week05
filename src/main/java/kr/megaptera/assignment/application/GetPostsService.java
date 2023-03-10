package kr.megaptera.assignment.application;

import java.util.List;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class GetPostsService {

  private final PostRepository postRepository;

  public GetPostsService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostDto> getPostList() {
    return postRepository.findAll().stream().map(post -> post.toDto()).toList();
  }
}
