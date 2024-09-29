package com.example.inews.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class NewsImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "img_id", type = IdType.AUTO)
    private Integer imgId;

    private Integer nId;

    @TableField("Image_url")
    private String imageUrl;


}
