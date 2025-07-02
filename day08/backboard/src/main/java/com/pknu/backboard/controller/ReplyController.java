package com.pknu.backboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.backboard.entity.Board;
import com.pknu.backboard.service.BoardService;
import com.pknu.backboard.service.ReplyService;
import com.pknu.backboard.validation.ReplyForm;

import jakarta.validation.Valid;
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
            @Valid ReplyForm replyForm, BindingResult bindingResult) {

        Board board = this.boardService.getBoardOne(bno);

        if (bindingResult.hasErrors()) {
            model.addAttribute("board", board);
            return "board_detail";
        }

        this.replyService.setReply(board, replyForm.getContent());

        return String.format("redirect:/board/detail/%s", bno);
    }

}
