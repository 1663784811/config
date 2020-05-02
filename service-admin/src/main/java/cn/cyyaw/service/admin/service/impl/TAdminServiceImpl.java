package cn.cyyaw.service.admin.service.impl;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.service.TAdminService;
import cn.cyyaw.service.admin.table.dao.TAdminDao;
import cn.cyyaw.service.admin.table.entity.TAdmin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class TAdminServiceImpl extends BaseService<TAdmin, Integer> implements TAdminService {

    @Autowired
    private TAdminDao tAdminDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminDao;
    }

}

