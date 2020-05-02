package cn.cyyaw.service.admin.table.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_power")
@org.hibernate.annotations.Table(appliesTo = "t_power", comment = "权限表")
public class TPower implements Serializable {
    private static final long serialVersionUID = 1568782627393758L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "id", length = 10, columnDefinition = "int COMMENT 'id'")
    private Integer id;
    @Basic
    @Column(name = "tid", length = 32, columnDefinition = "varchar(32) not null COMMENT 'tid'")
    private String tid;
    @Basic
    @Column(name = "del", length = 10, columnDefinition = "int COMMENT '是否删除{0:否,1:是}'")
    private Integer del;
    @Basic
    @Column(name = "note", columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @Basic
    @Column(name = "createtime", length = 19, columnDefinition = "datetime COMMENT '创建时间'")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @Basic
    @Column(name = "pid", length = 10, columnDefinition = "int COMMENT '父级ID'")
    private Integer pid;
    @Basic
    @Column(name = "treecode", length = 10, columnDefinition = "varchar(32) not null default '' COMMENT '树码(一级三位)'")
    private String treecode;

    @Basic
    @Column(name = "code", columnDefinition = "varchar(255) COMMENT '受权码'")
    private String code;
    @Basic
    @Column(name = "icon", columnDefinition = "varchar(255) COMMENT '图标'")
    private String icon;
    @Basic
    @Column(name = "name", length = 32, columnDefinition = "varchar(32) COMMENT '名称'")
    private String name;
    @Basic
    @Column(name = "powertype", length = 10, columnDefinition = "int COMMENT '权限类型{1:菜单,2:按钮}'")
    private Integer powertype;
    @Basic
    @Column(name = "status", length = 10, columnDefinition = "int COMMENT '状态{1:显示,0:隐藏}'")
    private Integer status;
    @Basic
    @Column(name = "url", columnDefinition = "varchar(255) COMMENT 'url'")
    private String url;
    @Basic
    @Column(name = "sort", length = 10, columnDefinition = "int COMMENT '排序'")
    private Integer sort;
}
