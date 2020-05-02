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
@Table(name = "t_admin")
@org.hibernate.annotations.Table(appliesTo = "t_admin", comment = "管理员表")
public class TAdmin implements Serializable{
    private static final long serialVersionUID = 1587301173682985L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic
    @Column(name="id", length = 10 ,unique = true, columnDefinition = "int COMMENT 'id'")
    private Integer id;
    @Basic
    @Column(name="account", length = 32 ,nullable = true, columnDefinition = "varchar(32) COMMENT '账号'")
    private String account;
    @Basic
    @Column(name="canlogintime", length = 19 ,nullable = true, columnDefinition = "datetime COMMENT '可登录时间'")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date canlogintime;
    @Basic
    @Column(name="createtime", length = 19 ,nullable = true, columnDefinition = "datetime COMMENT '创建时间'")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @Basic
    @Column(name="del", length = 10 ,nullable = true, columnDefinition = "int COMMENT '是否删除{0:否,1:是}'")
    private Integer del;
    @Basic
    @Column(name="email" ,nullable = true, columnDefinition = "varchar(255) COMMENT '邮箱'")
    private String email;
    @Basic
    @Column(name="ip", length = 60 ,nullable = true, columnDefinition = "varchar(60) COMMENT '最后登录IP'")
    private String ip;
    @Basic
    @Column(name="lastlogintime", length = 19 ,nullable = true, columnDefinition = "datetime COMMENT '最后登录时间'")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastlogintime;
    @Basic
    @Column(name="nickname", length = 32 ,nullable = true, columnDefinition = "varchar(32) COMMENT '昵称'")
    private String nickname;
    @Basic
    @Column(name="note" ,nullable = true, columnDefinition = "varchar(255) COMMENT '备注'")
    private String note;
    @Basic
    @Column(name="password", length = 32 ,nullable = true, columnDefinition = "varchar(32) COMMENT '密码'")
    private String password;
    @Basic
    @Column(name="phone", length = 15 ,nullable = true, columnDefinition = "varchar(15) COMMENT '手机号'")
    private String phone;
    @Basic
    @Column(name="salt", length = 32 ,nullable = true, columnDefinition = "varchar(32) COMMENT '加密盐'")
    private String salt;
    @Basic
    @Column(name="status", length = 10 ,nullable = true, columnDefinition = "int COMMENT '状态{0:正常,1:暂时锁定,2:永久锁定}'")
    private Integer status;
    @Basic
    @Column(name="tid", length = 32, columnDefinition = "varchar(32) COMMENT 'tid'")
    private String tid;
    @Basic
    @Column(name="truename", length = 32 ,nullable = true, columnDefinition = "varchar(32) COMMENT '真实姓名'")
    private String truename;
}
