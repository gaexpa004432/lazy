package admin.cms.menu.service.impl;

import admin.cms.menu.mapper.MenuMapper;
import admin.cms.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public String selectTest() {

        return menuMapper.selectTest().getMenuId();
    }
}
