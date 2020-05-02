package cn.cyyaw.service.admin.service.impl;

import cn.cyyaw.jpa.BaseDao;
import cn.cyyaw.jpa.BaseService;
import cn.cyyaw.service.admin.service.TMessageService;
import cn.cyyaw.service.admin.table.dao.TMessageDao;
import cn.cyyaw.service.admin.table.entity.TMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class TMessageServiceImpl extends BaseService<TMessage, Integer> implements TMessageService {

    @Autowired
    private TMessageDao tMessageDao;

    @Override
    public BaseDao getBaseDao() {
        return tMessageDao;
    }

}

