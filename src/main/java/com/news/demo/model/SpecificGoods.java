package com.news.demo.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author GEBILAOHU
 * @since 2019-07-13
 */
@TableName("b_specific_goods")
public class SpecificGoods extends Model<SpecificGoods> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private Date createdate;
    @TableField("recommended_describe")
    private String recommendedDescribe;
    @TableField("user_id")
    private Integer userId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
