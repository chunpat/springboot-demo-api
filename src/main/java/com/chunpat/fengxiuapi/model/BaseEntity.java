package com.chunpat.fengxiuapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
//@Accessors(chain = true)
@MappedSuperclass//实体继承映射
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'",updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createTime;

    @Column(columnDefinition="timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'")
    @org.hibernate.annotations.UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @Column(columnDefinition="timestamp DEFAULT NULL COMMENT '删除时间'")
    @JsonIgnore
    private Date deleteTime;
}
