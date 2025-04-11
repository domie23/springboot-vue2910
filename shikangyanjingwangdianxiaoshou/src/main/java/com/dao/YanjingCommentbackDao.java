package com.dao;

import com.entity.YanjingCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YanjingCommentbackView;

/**
 * 眼镜评价 Dao 接口
 *
 * @author 
 */
public interface YanjingCommentbackDao extends BaseMapper<YanjingCommentbackEntity> {

   List<YanjingCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
