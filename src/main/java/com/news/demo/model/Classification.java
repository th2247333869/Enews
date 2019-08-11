package com.news.demo.model;

import com.baomidou.mybatisplus.enums.IdType;
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
 * @since 2019-08-11
 */
@TableName("b_classification")
public class Classification extends Model<Classification> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 背景
     */
    @TableField("image_url")
    private String imageUrl;
    /**
     * 跳转页面
     */
    @TableField("to_page")
    private String toPage;
    /**
     * 关注程度
     */
    private String level;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
