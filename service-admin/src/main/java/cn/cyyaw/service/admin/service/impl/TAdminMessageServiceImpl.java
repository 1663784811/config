package cn.cyyaw.service.admin.service.impl;


import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.service.TAdminMessageService;
import cn.cyyaw.service.admin.table.dao.TAdminMessageDao;
import cn.cyyaw.service.admin.table.entity.TAdminMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TAdminMessageServiceImpl extends BaseService<TAdminMessage, Integer> implements TAdminMessageService {

    @Autowired
    private TAdminMessageDao tAdminMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return tAdminMessageDao;
    }

}

