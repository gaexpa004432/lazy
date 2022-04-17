package com.salaryup.board.mapper;

import com.salaryup.board.domain.BoardVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {

    List<BoardVO> selectTest(BoardVO boardVO);

    void boardInsert(BoardVO boardVO);

    void insertTag(String name);

    void deleteBoardTag(String boardNo);

    void boardTagInsert(BoardVO boardVO);
}