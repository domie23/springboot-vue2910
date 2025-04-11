package com.entity.model;

import com.entity.YanjingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 眼镜
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YanjingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商家
     */
    private Integer shangjiaId;


    /**
     * 眼镜名称
     */
    private String yanjingName;


    /**
     * 眼镜照片
     */
    private String yanjingPhoto;


    /**
     * 眼镜类型
     */
    private Integer yanjingTypes;


    /**
     * 镜框材质
     */
    private Integer caizhiTypes;


    /**
     * 镜片材质
     */
    private Integer jingpianTypes;


    /**
     * 镜片品牌
     */
    private Integer pinpaiTypes;


    /**
     * 镜片折射率
     */
    private Integer zhesheTypes;


    /**
     * 颜色
     */
    private Integer yanseTypes;


    /**
     * 眼镜配件
     */
    private Integer peijianTypes;


    /**
     * 购买获得积分
     */
    private Integer shangpinPrice;


    /**
     * 眼镜库存
     */
    private Integer yanjingKucunNumber;


    /**
     * 眼镜原价
     */
    private Double yanjingOldMoney;


    /**
     * 现价
     */
    private Double yanjingNewMoney;


    /**
     * 点击次数
     */
    private Integer yanjingClicknum;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer yanjingDelete;


    /**
     * 眼镜简介
     */
    private String yanjingContent;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：商家
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：眼镜名称
	 */
    public String getYanjingName() {
        return yanjingName;
    }


    /**
	 * 设置：眼镜名称
	 */
    public void setYanjingName(String yanjingName) {
        this.yanjingName = yanjingName;
    }
    /**
	 * 获取：眼镜照片
	 */
    public String getYanjingPhoto() {
        return yanjingPhoto;
    }


    /**
	 * 设置：眼镜照片
	 */
    public void setYanjingPhoto(String yanjingPhoto) {
        this.yanjingPhoto = yanjingPhoto;
    }
    /**
	 * 获取：眼镜类型
	 */
    public Integer getYanjingTypes() {
        return yanjingTypes;
    }


    /**
	 * 设置：眼镜类型
	 */
    public void setYanjingTypes(Integer yanjingTypes) {
        this.yanjingTypes = yanjingTypes;
    }
    /**
	 * 获取：镜框材质
	 */
    public Integer getCaizhiTypes() {
        return caizhiTypes;
    }


    /**
	 * 设置：镜框材质
	 */
    public void setCaizhiTypes(Integer caizhiTypes) {
        this.caizhiTypes = caizhiTypes;
    }
    /**
	 * 获取：镜片材质
	 */
    public Integer getJingpianTypes() {
        return jingpianTypes;
    }


    /**
	 * 设置：镜片材质
	 */
    public void setJingpianTypes(Integer jingpianTypes) {
        this.jingpianTypes = jingpianTypes;
    }
    /**
	 * 获取：镜片品牌
	 */
    public Integer getPinpaiTypes() {
        return pinpaiTypes;
    }


    /**
	 * 设置：镜片品牌
	 */
    public void setPinpaiTypes(Integer pinpaiTypes) {
        this.pinpaiTypes = pinpaiTypes;
    }
    /**
	 * 获取：镜片折射率
	 */
    public Integer getZhesheTypes() {
        return zhesheTypes;
    }


    /**
	 * 设置：镜片折射率
	 */
    public void setZhesheTypes(Integer zhesheTypes) {
        this.zhesheTypes = zhesheTypes;
    }
    /**
	 * 获取：颜色
	 */
    public Integer getYanseTypes() {
        return yanseTypes;
    }


    /**
	 * 设置：颜色
	 */
    public void setYanseTypes(Integer yanseTypes) {
        this.yanseTypes = yanseTypes;
    }
    /**
	 * 获取：眼镜配件
	 */
    public Integer getPeijianTypes() {
        return peijianTypes;
    }


    /**
	 * 设置：眼镜配件
	 */
    public void setPeijianTypes(Integer peijianTypes) {
        this.peijianTypes = peijianTypes;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getShangpinPrice() {
        return shangpinPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setShangpinPrice(Integer shangpinPrice) {
        this.shangpinPrice = shangpinPrice;
    }
    /**
	 * 获取：眼镜库存
	 */
    public Integer getYanjingKucunNumber() {
        return yanjingKucunNumber;
    }


    /**
	 * 设置：眼镜库存
	 */
    public void setYanjingKucunNumber(Integer yanjingKucunNumber) {
        this.yanjingKucunNumber = yanjingKucunNumber;
    }
    /**
	 * 获取：眼镜原价
	 */
    public Double getYanjingOldMoney() {
        return yanjingOldMoney;
    }


    /**
	 * 设置：眼镜原价
	 */
    public void setYanjingOldMoney(Double yanjingOldMoney) {
        this.yanjingOldMoney = yanjingOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getYanjingNewMoney() {
        return yanjingNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setYanjingNewMoney(Double yanjingNewMoney) {
        this.yanjingNewMoney = yanjingNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getYanjingClicknum() {
        return yanjingClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setYanjingClicknum(Integer yanjingClicknum) {
        this.yanjingClicknum = yanjingClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYanjingDelete() {
        return yanjingDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setYanjingDelete(Integer yanjingDelete) {
        this.yanjingDelete = yanjingDelete;
    }
    /**
	 * 获取：眼镜简介
	 */
    public String getYanjingContent() {
        return yanjingContent;
    }


    /**
	 * 设置：眼镜简介
	 */
    public void setYanjingContent(String yanjingContent) {
        this.yanjingContent = yanjingContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
