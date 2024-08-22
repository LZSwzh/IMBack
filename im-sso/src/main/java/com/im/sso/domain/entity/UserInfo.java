package com.im.sso.domain.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserInfo {
    @TableId(value = "user_id",type = IdType.ASSIGN_ID)
    private Long userId;

    private String userName;

    private Integer userAge;

    private String userDept;

    private String userPhone;

    private String userEmail;

    @TableField("user_nick_name")
    private String nickName;

    @TableField("user_password")
    private String password;

    @TableField("user_create_date")
    private LocalDateTime createTime;

    @TableField("user_update_date")
    private LocalDateTime updateTime;

}
