package cn.cyyaw.admin.table.controller;


import cn.cyyaw.admin.table.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/admin/table")
@RestController
public class AdminController {


    @Autowired
    private AdminService adminService;


    /**
     * 表:t_admin ===> 所有:带条件
     */
    @ResponseBody
    @RequestMapping(value = "/findAllTAdmin", method = RequestMethod.GET)
    public String findAllTAdmin() {
       return adminService.findAllTAdmin();
    }


}
