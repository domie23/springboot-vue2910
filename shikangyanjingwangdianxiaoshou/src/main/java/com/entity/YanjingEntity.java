package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 眼镜
 *
 * @author 
 * @email
 */
@TableName("yanjing")
public class YanjingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YanjingEntity() {

	}

	public YanjingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 商家
     */
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 眼镜名称
     */
    @TableField(value = "yanjing_name")

    private String yanjingName;


    /**
     * 眼镜照片
     */
    @TableField(value = "yanjing_photo")

    private String yanjingPhoto;


    /**
     * 眼镜类型
     */
    @TableField(value = "yanjing_types")

    private Integer yanjingTypes;


    /**
     * 镜框材质
     */
    @TableField(value = "caizhi_types")

    private Integer caizhiTypes;


    /**
     * 镜片材质
     */
    @TableField(value = "jingpian_types")

    private Integer jingpianTypes;


    /**
     * 镜片品牌
     */
    @TableField(value = "pinpai_types")

    private Integer pinpaiTypes;


    /**
     * 镜片折射率
     */
    @TableField(value = "zheshe_types")

    private Integer zhesheTypes;


    /**
     * 颜色
     */
    @TableField(value = "yanse_types")

    private Integer yanseTypes;


    /**
     * 眼镜配件
     */
    @TableField(value = "peijian_types")

    private Integer peijianTypes;


    /**
     * 购买获得积分
     */
    @TableField(value = "shangpin_price")

    private Integer shangpinPrice;


    /**
     * 眼镜库存
     */
    @TableField(value = "yanjing_kucun_number")

    private Integer yanjingKucunNumber;


    /**
     * 眼镜原价
     */
    @TableField(value = "yanjing_old_money")

    private Double yanjingOldMoney;


    /**
     * 现价
     */
    @TableField(value = "yanjing_new_money")

    private Double yanjingNewMoney;


    /**
     * 点击次数
     */
    @TableField(value = "yanjing_clicknum")

    private Integer yanjingClicknum;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "yanjing_delete")

    private Integer yanjingDelete;


    /**
     * 眼镜简介
     */
    @TableField(value = "yanjing_content")

    private String yanjingContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：眼镜名称
	 */
    public String getYanjingName() {
        return yanjingName;
    }


    /**
	 * 获取：眼镜名称
	 */

    public void setYanjingName(String yanjingName) {
        this.yanjingName = yanjingName;
    }
    /**
	 * 设置：眼镜照片
	 */
    public String getYanjingPhoto() {
        return yanjingPhoto;
    }


    /**
	 * 获取：眼镜照片
	 */

    public void setYanjingPhoto(String yanjingPhoto) {
        this.yanjingPhoto = yanjingPhoto;
    }
    /**
	 * 设置：眼镜类型
	 */
    public Integer getYanjingTypes() {
        return yanjingTypes;
    }


    /**
	 * 获取：眼镜类型
	 */

    public void setYanjingTypes(Integer yanjingTypes) {
        this.yanjingTypes = yanjingTypes;
    }
    /**
	 * 设置：镜框材质
	 */
    public Integer getCaizhiTypes() {
        return caizhiTypes;
    }


    /**
	 * 获取：镜框材质
	 */

    public void setCaizhiTypes(Integer caizhiTypes) {
        this.caizhiTypes = caizhiTypes;
    }
    /**
	 * 设置：镜片材质
	 */
    public Integer getJingpianTypes() {
        return jingpianTypes;
    }


    /**
	 * 获取：镜片材质
	 */

    public void setJingpianTypes(Integer jingpianTypes) {
        this.jingpianTypes = jingpianTypes;
    }
    /**
	 * 设置：镜片品牌
	 */
    public Integer getPinpaiTypes() {
        return pinpaiTypes;
    }


    /**
	 * 获取：镜片品牌
	 */

    public void setPinpaiTypes(Integer pinpaiTypes) {
        this.pinpaiTypes = pinpaiTypes;
    }
    /**
	 * 设置：镜片折射率
	 */
    public Integer getZhesheTypes() {
        return zhesheTypes;
    }


    /**
	 * 获取：镜片折射率
	 */

    public void setZhesheTypes(Integer zhesheTypes) {
        this.zhesheTypes = zhesheTypes;
    }
    /**
	 * 设置：颜色
	 */
    public Integer getYanseTypes() {
        return yanseTypes;
    }


    /**
	 * 获取：颜色
	 */

    public void setYanseTypes(Integer yanseTypes) {
        this.yanseTypes = yanseTypes;
    }
    /**
	 * 设置：眼镜配件
	 */
    public Integer getPeijianTypes() {
        return peijianTypes;
    }


    /**
	 * 获取：眼镜配件
	 */

    public void setPeijianTypes(Integer peijianTypes) {
        this.peijianTypes = peijianTypes;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getShangpinPrice() {
        return shangpinPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setShangpinPrice(Integer shangpinPrice) {
        this.shangpinPrice = shangpinPrice;
    }
    /**
	 * 设置：眼镜库存
	 */
    public Integer getYanjingKucunNumber() {
        return yanjingKucunNumber;
    }


    /**
	 * 获取：眼镜库存
	 */

    public void setYanjingKucunNumber(Integer yanjingKucunNumber) {
        this.yanjingKucunNumber = yanjingKucunNumber;
    }
    /**
	 * 设置：眼镜原价
	 */
    public Double getYanjingOldMoney() {
        return yanjingOldMoney;
    }


    /**
	 * 获取：眼镜原价
	 */

    public void setYanjingOldMoney(Double yanjingOldMoney) {
        this.yanjingOldMoney = yanjingOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getYanjingNewMoney() {
        return yanjingNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setYanjingNewMoney(Double yanjingNewMoney) {
        this.yanjingNewMoney = yanjingNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getYanjingClicknum() {
        return yanjingClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setYanjingClicknum(Integer yanjingClicknum) {
        this.yanjingClicknum = yanjingClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYanjingDelete() {
        return yanjingDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYanjingDelete(Integer yanjingDelete) {
        this.yanjingDelete = yanjingDelete;
    }
    /**
	 * 设置：眼镜简介
	 */
    public String getYanjingContent() {
        return yanjingContent;
    }


    /**
	 * 获取：眼镜简介
	 */

    public void setYanjingContent(String yanjingContent) {
        this.yanjingContent = yanjingContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Yanjing{" +
            "id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", yanjingName=" + yanjingName +
            ", yanjingPhoto=" + yanjingPhoto +
            ", yanjingTypes=" + yanjingTypes +
            ", caizhiTypes=" + caizhiTypes +
            ", jingpianTypes=" + jingpianTypes +
            ", pinpaiTypes=" + pinpaiTypes +
            ", zhesheTypes=" + zhesheTypes +
            ", yanseTypes=" + yanseTypes +
            ", peijianTypes=" + peijianTypes +
            ", shangpinPrice=" + shangpinPrice +
            ", yanjingKucunNumber=" + yanjingKucunNumber +
            ", yanjingOldMoney=" + yanjingOldMoney +
            ", yanjingNewMoney=" + yanjingNewMoney +
            ", yanjingClicknum=" + yanjingClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", yanjingDelete=" + yanjingDelete +
            ", yanjingContent=" + yanjingContent +
            ", createTime=" + createTime +
        "}";
    }
}
