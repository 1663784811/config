package cn.cyyaw.service.admin.table.entityconst;

/**
 * 表常量
 * 类命名：表名Const
 */
public class TAdminMessageConst {

    //允许查询列表
    public final static String selectColumnArr[] = {"id","adminid","createtime","del","messageid","status"};
    //允许查询条件
    public final static String selectWhereArr[] = {"id","adminid","createtime","del","messageid","status"};
    //允许更新字段
    public final static String updateColumnArr[] = {"id","adminid","createtime","del","messageid","status"};
    //允许删除条件
    public final static String deleteColumnArr[] = {"id","adminid","createtime","del","messageid","status"};
    //允许添加字段
    public final static String addColumnArr[] = {"id","adminid","createtime","del","messageid","status"};


    //过滤字段==  查询列表
    public final static String filterselectColumnArr[] = {};
    //过滤字段==  查询条件
    public final static String filterselectWhereArr[] = {};
    //过滤字段==  更新字段
    public final static String filterupdateColumnArr[] = {};
    //过滤字段==  删除条件
    public final static String filterdeleteColumnArr[] = {};
    //过滤字段==  添加字段
    public final static String filteraddColumnArr[] = {};


}
