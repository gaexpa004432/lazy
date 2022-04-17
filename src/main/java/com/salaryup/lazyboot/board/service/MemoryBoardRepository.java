package com.salaryup.lazyboot.board.service;
import com.salaryup.lazyboot.board.domain.BoardVO;
import com.salaryup.lazyboot.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryBoardRepository implements BoardRepository {

    @Autowired
    public BoardMapper mapper;

    @Override
    public List<BoardVO>  selectTest(BoardVO boardVO) {
        return mapper.selectTest(boardVO);
    }

    @Override
    public void boardInsert(BoardVO boardVO) {
        if(boardVO.getBoardNo() == null || "".equals(boardVO.getBoardNo())) {
            mapper.boardInsert(boardVO);
        }else{
            //업데이트 필요
        }
        mapper.deleteBoardTag(boardVO.getBoardNo());
        for(String name:boardVO.getTags()){
            mapper.insertTag(name);
            boardVO.setTag(name);
            mapper.boardTagInsert(boardVO);
        }
    }
}