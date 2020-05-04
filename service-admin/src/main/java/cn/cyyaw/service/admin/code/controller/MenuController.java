package cn.cyyaw.service.admin.code.controller;


import cn.cyyaw.service.admin.code.service.MenuService;
import cn.cyyaw.service.admin.toolscode.table.entity.TAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/code/menu")
@RestController
public class MenuController {


    @Autowired
    private MenuService menuService;

    /**
     * 获取用户菜单
     */
    @PostMapping("/getUserMenu")
    public void getUserMenu(TAdmin tAdmin){
        menuService.getUserMenu(tAdmin.getTid());
    }



}
