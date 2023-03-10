package kr.megaptera.assignment.models;

import kr.megaptera.assignment.dtos.PostDto;

public class Post {

  PostId id;
  String title;
  String author;
  String content;

  public Post(PostId id, String title, String author, String content) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public Post(String title, String author, String content) {
    this.id = PostId.generate();
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public PostId id() {
    return id;
  }

  public String title() {
    return title;
  }

  public String author() {
    return author;
  }

  public String content() {
    return content;
  }

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public PostDto toDto() {
    return new PostDto(
      this.id.toString(),
      this.title,
      this.author,
      this.content
    );
  }
}
