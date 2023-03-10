package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePostService {

  private PostRepository postRepository;

  public DeletePostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public PostDto deletePost(String postId) {
    Post deletedPost = postRepository.deletePost(PostId.of(postId));

    return deletedPost.toDto();
  }
}
