package cn.cyyaw.service.admin.code.service;

import cn.cyyaw.service.admin.toolscode.table.entity.TPower;

import java.util.List;

public interface MenuService {
    List<TPower> getUserMenu(String tid);
}
