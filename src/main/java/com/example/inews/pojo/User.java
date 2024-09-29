package com.example.inews.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "U_id", type = IdType.AUTO)
    private Integer uId;

    @TableField("Username")
    private String Username;

    @TableField("Password")
    private String Password;

    @TableField("Nick_name")
    private String nickName;

    @TableField("Avatar")
    private String Avatar;

    @TableField("Introduction")
    private String Introduction;

    @TableField("Sex")
    private String Sex;

    @TableField(value = "Create_time", fill = FieldFill.INSERT)
    private Date createTime;


}
