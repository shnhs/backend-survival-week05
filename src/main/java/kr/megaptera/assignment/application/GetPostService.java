package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class GetPostService {

  private final PostRepository postRepository;

  public GetPostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public PostDto getById(String postId) {
    return postRepository.getById(PostId.of(postId)).toDto();
  }
}
