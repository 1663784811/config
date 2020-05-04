package cn.cyyaw.service.admin.toolscode.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.toolscode.service.TAdminPowerService;
import cn.cyyaw.service.admin.toolscode.table.dao.TAdminPowerDao;
import cn.cyyaw.service.admin.toolscode.table.entity.TAdminPower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@Slf4j
public class TAdminPowerServiceImpl extends BaseService<TAdminPower, Integer> implements TAdminPowerService {

    @Autowired
    private TAdminPowerDao tAdminPowerDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminPowerDao;
    }
}

