package com.sparta.hanghaestartproject.entity;

import com.sparta.hanghaestartproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
     private Long id;
     
     @Column (nullable = false)
     private String username;
     
     @Column (nullable = false)
     private String content;
     
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="article_id")
     private Article article;
     
     public Comment(CommentRequestDto requestDto, String username) {
          this.username = username;
          this.content = requestDto.getContent();
     }
     
     public void updateArticle(Article article){
          this.article = article;
     }
     
     public void update(CommentRequestDto requestDto) {
          this.content =  requestDto.getContent();
     }
}
