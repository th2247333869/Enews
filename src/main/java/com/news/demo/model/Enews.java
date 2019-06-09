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
 * @since 2019-06-09
 */
@TableName("t_enews")
public class Enews extends Model<Enews> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "e_id", type = IdType.AUTO)
    private Integer eId;
    /**
     * 编码
     */
    @TableField("e_code")
    private Integer eCode;
    /**
     * 标题
     */
    @TableField("e_head")
    private Integer eHead;
    @TableField("creat_date")
    private Date creatDate;
    @TableField("e_picturequantity")
    private String ePicturequantity;
    @TableField("e_pictureUrls")
    private String ePictureurls;
    @TableField("e_data")
    private String eData;
    @TableField("e_author")
    private String eAuthor;
    @TableField("e_origin")
    private String eOrigin;


    @Override
    protected Serializable pkVal() {
        return this.eId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer geteCode() {
        return eCode;
    }

    public void seteCode(Integer eCode) {
        this.eCode = eCode;
    }

    public Integer geteHead() {
        return eHead;
    }

    public void seteHead(Integer eHead) {
        this.eHead = eHead;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getePicturequantity() {
        return ePicturequantity;
    }

    public void setePicturequantity(String ePicturequantity) {
        this.ePicturequantity = ePicturequantity;
    }

    public String getePictureurls() {
        return ePictureurls;
    }

    public void setePictureurls(String ePictureurls) {
        this.ePictureurls = ePictureurls;
    }

    public String geteData() {
        return eData;
    }

    public void seteData(String eData) {
        this.eData = eData;
    }

    public String geteAuthor() {
        return eAuthor;
    }

    public void seteAuthor(String eAuthor) {
        this.eAuthor = eAuthor;
    }

    public String geteOrigin() {
        return eOrigin;
    }

    public void seteOrigin(String eOrigin) {
        this.eOrigin = eOrigin;
    }
}
