package com.pknu.backboard.controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.service.BoardService;
import com.pknu.backboard.validation.BoardForm;
import com.pknu.backboard.validation.ReplyForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 공통이 되는 URL
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    // @GetMapping("/list")
    // public String getList(Model model) {
    // List<Board> boardList = this.boardService.getBoardList();

    // model.addAttribute("boardList", boardList);
    // return "board_list";
    // }

    @GetMapping("/list")
    public String getList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Board> boardPaging = this.boardService.getBoardList(page);

        model.addAttribute("boardPaging", boardPaging);
        return "board_list";
    }

    @GetMapping("/detail/{bno}")
    public String getDetail(Model model, @PathVariable("bno") Long bno, ReplyForm replyForm) {

        Board board = this.boardService.getBoardOne(bno);

        model.addAttribute("board", board);
        return "board_detail"; // board_detail.html 필요
    }

    @GetMapping("/create") // 작성을 요청할때
    public String getCreate(BoardForm boardForm) {
        return "board_create"; // board_create.html 파일 생성
    }

    // @PostMapping("/create") // 저장버튼 클릭 후
    // public String setCreate(@RequestParam(value = "title") String title,
    // @RequestParam(value = "content") String content) {

    // this.boardService.setBoardOne(title, content);
    // return "redirect:/board/list";
    // }

    @PostMapping("/create") // 저장버튼 클릭 후
    public String setCreate(@Valid BoardForm boardForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "board_create";

        this.boardService.setBoardOne(boardForm.getTitle(), boardForm.getContent());

        return "redirect:/board/list";
    }
}
