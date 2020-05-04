package cn.cyyaw.service.admin.code.service.impl;

import cn.cyyaw.service.admin.code.dao.MenuDao;
import cn.cyyaw.service.admin.code.service.MenuService;
import cn.cyyaw.service.admin.toolscode.table.entity.TPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<TPower> getUserMenu(String tid) {
        return menuDao.getUserMenu(tid);
    }
}
