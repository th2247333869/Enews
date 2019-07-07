package com.news.demo.model;

import java.util.Date;
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
 * @since 2019-07-07
 */
@TableName("b_commdity")
public class Commdity extends Model<Commdity> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String type;
    private String state;
    @TableField("image_url")
    private String imageUrl;
    private String title;
    @TableField("user_id")
    private Integer userId;
    private Integer compliments;
    private Date date;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
