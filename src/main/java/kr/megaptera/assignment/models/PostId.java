package kr.megaptera.assignment.models;

import com.github.f4b6a3.tsid.TsidCreator;

public class PostId {

  String postId;

  public PostId(String postId) {
    this.postId = postId;
  }

  public static PostId generate() {
    return new PostId(TsidCreator.getTsid().toString());
  }

  public static PostId of(String postId) {
    return new PostId(postId);
  }

  @Override
  public String toString() {
    return postId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((postId == null) ? 0 : postId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    PostId other = (PostId) obj;
    if (postId == null) {
      if (other.postId != null) return false;
    } else if (!postId.equals(other.postId)) return false;
    return true;
  }
}
