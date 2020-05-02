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
@Table(name = "t_role_power")
@org.hibernate.annotations.Table(appliesTo = "t_role_power", comment = "角色权限表")
public class TRolePower implements Serializable {
    private static final long serialVersionUID = 1568782627458514L;
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
    @Column(name = "tpowerid", columnDefinition = "varchar(32) COMMENT '权限表ID'")
    private String tpowerid;

    @Basic
    @Column(name = "troleid", columnDefinition = "varchar(32) COMMENT '角色表ID'")
    private String troleid;

}
