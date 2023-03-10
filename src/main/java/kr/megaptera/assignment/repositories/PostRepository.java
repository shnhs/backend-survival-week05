package kr.megaptera.assignment.repositories;

import java.util.HashMap;
import java.util.List;
import kr.megaptera.assignment.models.Post;
import kr.megaptera.assignment.models.PostId;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

  private static final HashMap<PostId, Post> postDb = new HashMap<>();

  public List<Post> findAll() {
    return postDb.values().stream().toList();
  }

  public void save(Post newPost) {
    postDb.put(newPost.id(), newPost);
  }

  public Post getById(PostId postId) {
    return postDb.get(postId);
  }

  public Post deletePost(PostId postId) {
    return postDb.remove(postId);
  }
}
