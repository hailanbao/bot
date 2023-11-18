package com.tianbo.mall.modules.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.modules.oms.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单操作历史记录 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderOperateHistoryMapper extends BaseMapper<OmsOrderOperateHistory> {

    int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistoryList);
}
