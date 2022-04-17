package com.salaryup.lazyboot.board.mapper;

import com.salaryup.lazyboot.board.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {

    List<BoardVO> selectTest(BoardVO boardVO);

    void boardInsert(BoardVO boardVO);

    void insertTag(String name);

    void deleteBoardTag(String boardNo);

    void boardTagInsert(BoardVO boardVO);
}