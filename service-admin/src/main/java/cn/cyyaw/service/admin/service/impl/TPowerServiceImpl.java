package cn.cyyaw.service.admin.service.impl;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.service.TPowerService;
import cn.cyyaw.service.admin.table.dao.TPowerDao;
import cn.cyyaw.service.admin.table.entity.TPower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class TPowerServiceImpl extends BaseService<TPower, Integer> implements TPowerService {

    @Autowired
    private TPowerDao tPowerDao;

    @Override
    public BaseDao getBaseDao() {
        return tPowerDao;
    }

}
