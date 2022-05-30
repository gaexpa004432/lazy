package admin.cms.menu.mapper;

import admin.cms.menu.domain.MenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MenuMapper {
    public MenuVO selectTest();

    List<MenuVO> selectMenu(MenuVO menuVO);
}
