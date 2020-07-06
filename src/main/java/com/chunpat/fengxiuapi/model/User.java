package com.chunpat.fengxiuapi.model;

import lombok.*;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    private String openid;
    private String nickname;
    private Integer unifyUid;
    private String email;
    private String password;
    private String mobile;
    private String wxProfile;
}
