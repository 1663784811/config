package cn.cyyaw.service.admin.toolscode.service.impl;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.toolscode.service.TAdminRoleService;
import cn.cyyaw.service.admin.toolscode.table.dao.TAdminRoleDao;
import cn.cyyaw.service.admin.toolscode.table.entity.TAdminRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class TAdminRoleServiceImpl extends BaseService<TAdminRole, Integer> implements TAdminRoleService {

    @Autowired
    private TAdminRoleDao tAdminRoleDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminRoleDao;
    }
}

