package cn.cyyaw.service.admin.service.impl;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.service.TRolePowerService;
import cn.cyyaw.service.admin.table.dao.TRolePowerDao;
import cn.cyyaw.service.admin.table.entity.TRolePower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class TRolePowerServiceImpl extends BaseService<TRolePower, Integer> implements TRolePowerService {

    @Autowired
    private TRolePowerDao tRolePowerDao;

    @Override
    public BaseDao getBaseDao() {
        return tRolePowerDao;
    }

}

