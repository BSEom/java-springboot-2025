package com.pknu.backboard.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

// Java에서 동일한 패키지에서 많이 추가되면 *로 생략 가능
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter // 롬복으로 Getter/Setter 자동화
@Entity // JPA 테이블 매핑 선언
@AllArgsConstructor
@NoArgsConstructor
@Builder // 객체 생성을 간단하게, 체인메서드 사용가능
public class Board {

    // @AllArgsConstructor 와 동일
    // public Board(Long bno, String title, String content, LocalDateTime
    // createDate, LocalDateTime modifyDate,
    // List<Reply> replyList) {
    // this.bno = bno;
    // this.title = title;
    // this.content = content;
    // this.createDate = createDate;
    // this.modifyDate = modifyDate;
    // this.replyList = replyList;
    // }

    // @NoArgsConstructor 와 동일
    // public Board() {
    // }

    @Id // PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bno; // Board 테이블의 PK, bno

    @Column(length = 250)
    private String title; // 게시판 제목

    @Column(length = 8000)
    private String content; // 게시글 내용

    // 작성자 추가
    @ManyToOne // 사용자가 여러개의 글을 작성가능
    private Member writer;

    // 좋아요 클릭 사용자 추가
    @ManyToMany
    private Set<Member> like;

    @CreatedDate
    @Column(updatable = false) // 한번 작성 후 수정하지 않음
    private LocalDateTime createDate; // 게시글 작성일

    @LastModifiedDate
    private LocalDateTime modifyDate; // 게시글 수정일

    // ERD 1:N을 만드는 법
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Reply> replyList;

    // 파일업로드 관련 필드
    private String fileOriginalName; // 업로드한 실제 파일명, 같은 이름의 파일이 중복될 수 있음
    private String fileStoredName; // 서버에 저장된 실제이름
    private String filePath; // 파일 저장위치
}
