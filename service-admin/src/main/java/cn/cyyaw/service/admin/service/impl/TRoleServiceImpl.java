package cn.cyyaw.service.admin.service.impl;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.service.TRoleService;
import cn.cyyaw.service.admin.table.dao.TRoleDao;
import cn.cyyaw.service.admin.table.entity.TRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class TRoleServiceImpl extends BaseService<TRole, Integer> implements TRoleService {

    @Autowired
    private TRoleDao tRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return tRoleDao;
    }

}

