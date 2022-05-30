package admin.cms.menu.service;

import admin.cms.menu.domain.MenuVO;

import java.util.List;

public interface MenuService {
    public String selectTest();

    List<MenuVO> selectMenu(MenuVO menuVO);
}
