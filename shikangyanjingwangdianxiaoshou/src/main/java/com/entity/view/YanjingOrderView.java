package com.entity.view;

import com.entity.YanjingOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 眼镜订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yanjing_order")
public class YanjingOrderView extends YanjingOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单类型的值
		*/
		private String yanjingOrderValue;
		/**
		* 支付类型的值
		*/
		private String yanjingOrderPaymentValue;



		//级联表 address
			/**
			* 收货地址 的 创建用户
			*/
			private Integer addressYonghuId;
			/**
			* 收货人
			*/
			private String addressName;
			/**
			* 电话
			*/
			private String addressPhone;
			/**
			* 地址
			*/
			private String addressDizhi;
			/**
			* 是否默认地址
			*/
			private Integer isdefaultTypes;
				/**
				* 是否默认地址的值
				*/
				private String isdefaultValue;

		//级联表 yanjing
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
				* 眼镜类型的值
				*/
				private String yanjingValue;
			/**
			* 镜框材质
			*/
			private Integer caizhiTypes;
				/**
				* 镜框材质的值
				*/
				private String caizhiValue;
			/**
			* 镜片材质
			*/
			private Integer jingpianTypes;
				/**
				* 镜片材质的值
				*/
				private String jingpianValue;
			/**
			* 镜片品牌
			*/
			private Integer pinpaiTypes;
				/**
				* 镜片品牌的值
				*/
				private String pinpaiValue;
			/**
			* 镜片折射率
			*/
			private Integer zhesheTypes;
				/**
				* 镜片折射率的值
				*/
				private String zhesheValue;
			/**
			* 颜色
			*/
			private Integer yanseTypes;
				/**
				* 颜色的值
				*/
				private String yanseValue;
			/**
			* 眼镜配件
			*/
			private Integer peijianTypes;
				/**
				* 眼镜配件的值
				*/
				private String peijianValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer yanjingDelete;
			/**
			* 眼镜简介
			*/
			private String yanjingContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public YanjingOrderView() {

	}

	public YanjingOrderView(YanjingOrderEntity yanjingOrderEntity) {
		try {
			BeanUtils.copyProperties(this, yanjingOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单类型的值
			*/
			public String getYanjingOrderValue() {
				return yanjingOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setYanjingOrderValue(String yanjingOrderValue) {
				this.yanjingOrderValue = yanjingOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getYanjingOrderPaymentValue() {
				return yanjingOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setYanjingOrderPaymentValue(String yanjingOrderPaymentValue) {
				this.yanjingOrderPaymentValue = yanjingOrderPaymentValue;
			}




				//级联表的get和set address
					/**
					* 获取：收货地址 的 创建用户
					*/
					public Integer getAddressYonghuId() {
						return addressYonghuId;
					}
					/**
					* 设置：收货地址 的 创建用户
					*/
					public void setAddressYonghuId(Integer addressYonghuId) {
						this.addressYonghuId = addressYonghuId;
					}

					/**
					* 获取： 收货人
					*/
					public String getAddressName() {
						return addressName;
					}
					/**
					* 设置： 收货人
					*/
					public void setAddressName(String addressName) {
						this.addressName = addressName;
					}
					/**
					* 获取： 电话
					*/
					public String getAddressPhone() {
						return addressPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setAddressPhone(String addressPhone) {
						this.addressPhone = addressPhone;
					}
					/**
					* 获取： 地址
					*/
					public String getAddressDizhi() {
						return addressDizhi;
					}
					/**
					* 设置： 地址
					*/
					public void setAddressDizhi(String addressDizhi) {
						this.addressDizhi = addressDizhi;
					}
					/**
					* 获取： 是否默认地址
					*/
					public Integer getIsdefaultTypes() {
						return isdefaultTypes;
					}
					/**
					* 设置： 是否默认地址
					*/
					public void setIsdefaultTypes(Integer isdefaultTypes) {
						this.isdefaultTypes = isdefaultTypes;
					}


						/**
						* 获取： 是否默认地址的值
						*/
						public String getIsdefaultValue() {
							return isdefaultValue;
						}
						/**
						* 设置： 是否默认地址的值
						*/
						public void setIsdefaultValue(String isdefaultValue) {
							this.isdefaultValue = isdefaultValue;
						}

























				//级联表的get和set yanjing

					/**
					* 获取： 眼镜名称
					*/
					public String getYanjingName() {
						return yanjingName;
					}
					/**
					* 设置： 眼镜名称
					*/
					public void setYanjingName(String yanjingName) {
						this.yanjingName = yanjingName;
					}
					/**
					* 获取： 眼镜照片
					*/
					public String getYanjingPhoto() {
						return yanjingPhoto;
					}
					/**
					* 设置： 眼镜照片
					*/
					public void setYanjingPhoto(String yanjingPhoto) {
						this.yanjingPhoto = yanjingPhoto;
					}
					/**
					* 获取： 眼镜类型
					*/
					public Integer getYanjingTypes() {
						return yanjingTypes;
					}
					/**
					* 设置： 眼镜类型
					*/
					public void setYanjingTypes(Integer yanjingTypes) {
						this.yanjingTypes = yanjingTypes;
					}


						/**
						* 获取： 眼镜类型的值
						*/
						public String getYanjingValue() {
							return yanjingValue;
						}
						/**
						* 设置： 眼镜类型的值
						*/
						public void setYanjingValue(String yanjingValue) {
							this.yanjingValue = yanjingValue;
						}
					/**
					* 获取： 镜框材质
					*/
					public Integer getCaizhiTypes() {
						return caizhiTypes;
					}
					/**
					* 设置： 镜框材质
					*/
					public void setCaizhiTypes(Integer caizhiTypes) {
						this.caizhiTypes = caizhiTypes;
					}


						/**
						* 获取： 镜框材质的值
						*/
						public String getCaizhiValue() {
							return caizhiValue;
						}
						/**
						* 设置： 镜框材质的值
						*/
						public void setCaizhiValue(String caizhiValue) {
							this.caizhiValue = caizhiValue;
						}
					/**
					* 获取： 镜片材质
					*/
					public Integer getJingpianTypes() {
						return jingpianTypes;
					}
					/**
					* 设置： 镜片材质
					*/
					public void setJingpianTypes(Integer jingpianTypes) {
						this.jingpianTypes = jingpianTypes;
					}


						/**
						* 获取： 镜片材质的值
						*/
						public String getJingpianValue() {
							return jingpianValue;
						}
						/**
						* 设置： 镜片材质的值
						*/
						public void setJingpianValue(String jingpianValue) {
							this.jingpianValue = jingpianValue;
						}
					/**
					* 获取： 镜片品牌
					*/
					public Integer getPinpaiTypes() {
						return pinpaiTypes;
					}
					/**
					* 设置： 镜片品牌
					*/
					public void setPinpaiTypes(Integer pinpaiTypes) {
						this.pinpaiTypes = pinpaiTypes;
					}


						/**
						* 获取： 镜片品牌的值
						*/
						public String getPinpaiValue() {
							return pinpaiValue;
						}
						/**
						* 设置： 镜片品牌的值
						*/
						public void setPinpaiValue(String pinpaiValue) {
							this.pinpaiValue = pinpaiValue;
						}
					/**
					* 获取： 镜片折射率
					*/
					public Integer getZhesheTypes() {
						return zhesheTypes;
					}
					/**
					* 设置： 镜片折射率
					*/
					public void setZhesheTypes(Integer zhesheTypes) {
						this.zhesheTypes = zhesheTypes;
					}


						/**
						* 获取： 镜片折射率的值
						*/
						public String getZhesheValue() {
							return zhesheValue;
						}
						/**
						* 设置： 镜片折射率的值
						*/
						public void setZhesheValue(String zhesheValue) {
							this.zhesheValue = zhesheValue;
						}
					/**
					* 获取： 颜色
					*/
					public Integer getYanseTypes() {
						return yanseTypes;
					}
					/**
					* 设置： 颜色
					*/
					public void setYanseTypes(Integer yanseTypes) {
						this.yanseTypes = yanseTypes;
					}


						/**
						* 获取： 颜色的值
						*/
						public String getYanseValue() {
							return yanseValue;
						}
						/**
						* 设置： 颜色的值
						*/
						public void setYanseValue(String yanseValue) {
							this.yanseValue = yanseValue;
						}
					/**
					* 获取： 眼镜配件
					*/
					public Integer getPeijianTypes() {
						return peijianTypes;
					}
					/**
					* 设置： 眼镜配件
					*/
					public void setPeijianTypes(Integer peijianTypes) {
						this.peijianTypes = peijianTypes;
					}


						/**
						* 获取： 眼镜配件的值
						*/
						public String getPeijianValue() {
							return peijianValue;
						}
						/**
						* 设置： 眼镜配件的值
						*/
						public void setPeijianValue(String peijianValue) {
							this.peijianValue = peijianValue;
						}
					/**
					* 获取： 购买获得积分
					*/
					public Integer getShangpinPrice() {
						return shangpinPrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setShangpinPrice(Integer shangpinPrice) {
						this.shangpinPrice = shangpinPrice;
					}
					/**
					* 获取： 眼镜库存
					*/
					public Integer getYanjingKucunNumber() {
						return yanjingKucunNumber;
					}
					/**
					* 设置： 眼镜库存
					*/
					public void setYanjingKucunNumber(Integer yanjingKucunNumber) {
						this.yanjingKucunNumber = yanjingKucunNumber;
					}
					/**
					* 获取： 眼镜原价
					*/
					public Double getYanjingOldMoney() {
						return yanjingOldMoney;
					}
					/**
					* 设置： 眼镜原价
					*/
					public void setYanjingOldMoney(Double yanjingOldMoney) {
						this.yanjingOldMoney = yanjingOldMoney;
					}
					/**
					* 获取： 现价
					*/
					public Double getYanjingNewMoney() {
						return yanjingNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setYanjingNewMoney(Double yanjingNewMoney) {
						this.yanjingNewMoney = yanjingNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getYanjingClicknum() {
						return yanjingClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setYanjingClicknum(Integer yanjingClicknum) {
						this.yanjingClicknum = yanjingClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getYanjingDelete() {
						return yanjingDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setYanjingDelete(Integer yanjingDelete) {
						this.yanjingDelete = yanjingDelete;
					}
					/**
					* 获取： 眼镜简介
					*/
					public String getYanjingContent() {
						return yanjingContent;
					}
					/**
					* 设置： 眼镜简介
					*/
					public void setYanjingContent(String yanjingContent) {
						this.yanjingContent = yanjingContent;
					}













				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}
					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}
					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}




}
