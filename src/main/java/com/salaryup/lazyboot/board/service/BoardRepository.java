package com.salaryup.lazyboot.board.service;

import com.salaryup.lazyboot.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BoardRepository {

    List<BoardVO> selectTest(BoardVO boardVO);

    void boardInsert(BoardVO boardVO);
}