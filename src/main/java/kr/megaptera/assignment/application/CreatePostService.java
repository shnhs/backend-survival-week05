package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.PostCreateDto;
import kr.megaptera.assignment.dtos.PostDto;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePostService {

  private PostRepository postRepository;

  public CreatePostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public PostDto save(PostCreateDto postCreateDto) {
    Post newPost = new Post(
      postCreateDto.getTitle(),
      postCreateDto.getAuthor(),
      postCreateDto.getContent()
    );

    postRepository.save(newPost);

    return newPost.toDto();
  }
}
