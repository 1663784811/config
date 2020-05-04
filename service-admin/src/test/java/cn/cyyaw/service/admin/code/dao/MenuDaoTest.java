package cn.cyyaw.service.admin.code.dao;


import cn.cyyaw.service.admin.toolscode.table.entity.TPower;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class MenuDaoTest {

    @Autowired
    private MenuDao menuDao;


    @Test
    void test01() {
        log.info("==================新增用户=============");







    }


    @Test
    void test10() {
        log.info("==================获取用户权限=============");
        List<TPower> tPowerList = menuDao.getUserMenu("dssss");
        for (int i = 0; i < tPowerList.size(); i++) {
            TPower tPower = tPowerList.get(i);
            System.out.println(tPower.getId());
        }

    }


}
