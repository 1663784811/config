package cn.cyyaw.service.admin.code.dao;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.service.admin.toolscode.table.entity.TPower;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuDao  extends BaseDao<TPower, Integer> {

    /**
     * 获取用户菜单
     * @param tid
     * @return
     */

    @Query("select tp from TAdmin ta LEFT JOIN TAdminPower tap ON ta.tid = tap.tadminid LEFT JOIN TPower tp ON tp.tid = tap.tpowerid where ta.tid = ?1 ")
    List<TPower> getUserMenu(String tid);
}
