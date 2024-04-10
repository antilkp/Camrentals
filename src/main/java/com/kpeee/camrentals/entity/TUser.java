package com.kpeee.camrentals.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class TUser implements Serializable {

    @TableId(value = "user_id", type = IdType.AUTO)
    @Id
    private Integer user_id;

    @NotNull
    private String user_phone;

    @NotEmpty
    private String user_email;

    @NotEmpty
    private String uesr_name;

    private String user_password;

    private static final long serialVersionUID = 1L;
}