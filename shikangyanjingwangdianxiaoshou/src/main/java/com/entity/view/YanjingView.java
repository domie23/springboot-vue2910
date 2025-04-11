package com.entity.view;

import com.entity.YanjingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 眼镜
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yanjing")
public class YanjingView extends YanjingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 眼镜类型的值
		*/
		private String yanjingValue;
		/**
		* 镜框材质的值
		*/
		private String caizhiValue;
		/**
		* 镜片材质的值
		*/
		private String jingpianValue;
		/**
		* 镜片品牌的值
		*/
		private String pinpaiValue;
		/**
		* 镜片折射率的值
		*/
		private String zhesheValue;
		/**
		* 颜色的值
		*/
		private String yanseValue;
		/**
		* 眼镜配件的值
		*/
		private String peijianValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public YanjingView() {

	}

	public YanjingView(YanjingEntity yanjingEntity) {
		try {
			BeanUtils.copyProperties(this, yanjingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
























}
