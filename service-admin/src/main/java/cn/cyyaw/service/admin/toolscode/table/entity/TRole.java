package cn.cyyaw.service.admin.toolscode.table.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_role")
@org.hibernate.annotations.Table(appliesTo = "t_role", comment = "角色表")
public class TRole implements Serializable {
    private static final long serialVersionUID = 1568782627448808L;
    @Id
    @Basic
    @Column(name = "id", length = 10, columnDefinition = "int auto_increment COMMENT 'id'")
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
    @Column(name = "code", length = 32, columnDefinition = "varchar(32) COMMENT '授权码'")
    private String code;
    @Basic
    @Column(name = "name", length = 32, columnDefinition = "varchar(32) COMMENT '角色名称'")
    private String name;


    @Basic
    @Column(name = "pid", length = 10, columnDefinition = "int COMMENT '父级ID'")
    private Integer pid;
    @Basic
    @Column(name = "treecode", length = 10, columnDefinition = "varchar(32) not null default '' COMMENT '树码(一级三位)'")
    private String treecode;

}
