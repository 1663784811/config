package cn.cyyaw.jpa;

import cn.cyyaw.common.entity.SelectModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;


public abstract class BaseService<T, D> implements BaseTableService<T, D> {
    public abstract BaseDao getBaseDao();

    @Override
    public List<T> findAll(String jsonStr, SelectModel selectModel, String... selectWhereArr) {
        Sort sort = JpaUtils.getSort(selectModel);
        if (null != sort) {
            return getBaseDao().findAll(new WhySpecification<T>(jsonStr, selectWhereArr), sort);
        } else {
            return getBaseDao().findAll(new WhySpecification<T>(jsonStr, selectWhereArr));
        }
    }

    @Override
    public Page<T> findPage(String jsonStr, PageRequest pageRequest, String... strings) {
        return getBaseDao().findAll(new WhySpecification<T>(jsonStr, strings), pageRequest);
    }

    @Override
    public T findId(D d) {
        return (T) getBaseDao().findByid(d);
    }

    @Override
    public T save(T t) {
        return (T) getBaseDao().save(t);
    }

    @Override
    public void del(D[] ds) {
        getBaseDao().deleteInBatch(getBaseDao().findByidIsIn(ds));
    }

    @Override
    public void del(D d) {
        getBaseDao().deleteById(d);
    }

}
