package com.salaryup.lazyboot.board.controller;

import com.salaryup.lazyboot.board.domain.BoardVO;
import com.salaryup.lazyboot.board.service.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/board")
    public String fileTest(Model model, BoardVO boardVO){
        List<BoardVO> list = boardRepository.selectTest(boardVO);
        model.addAttribute("data",list);
        return "board/board";
    };

    @RequestMapping("/boardInsert")
    public String boardInsert(Model model, BoardVO boardVO){



        return "board/board";
    };
}
