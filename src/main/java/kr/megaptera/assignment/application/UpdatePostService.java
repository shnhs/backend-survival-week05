package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.dtos.PostUpdateDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdatePostService {

  private PostRepository postRepository;

  public UpdatePostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public PostDto updatePost(String postId, PostUpdateDto postUpdateDto) {
    // 아이디로 post 찾고
    Post updateTargetPost = postRepository.getById(PostId.of(postId));

    // 업데이트
    updateTargetPost.update(
      postUpdateDto.getTitle(),
      postUpdateDto.getContent()
    );

    return updateTargetPost.toDto();
  }
}
