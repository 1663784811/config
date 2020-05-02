package cn.cyyaw.service.admin.table.dao;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.service.admin.table.entity.TStatistics;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TStatisticsDao extends BaseDao<TStatistics, Integer> {

    @Query("select model from TStatistics model where model.createtime = ?1")
    List<TStatistics> findByCreateTime(Date createtime);


    @Query("SELECT sum(m.visit) FROM TStatistics m")
    Integer visitAll();

}
