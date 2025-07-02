package com.pknu.backboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.service.BoardService;
import com.pknu.backboard.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private final ReplyService replyService;

    @Autowired
    private final BoardService boardService;

    @PostMapping("/create/{bno}")
    public String setReply(Model model, @PathVariable("bno") Long bno,
            @RequestParam(value = "content") String content) {

        Board board = this.boardService.getBoardOne(bno);
        this.replyService.setReply(board, content);

        return String.format("redirect:/board/detail/%s", bno);
    }

}
