package com.tianbo.mall.modules.oms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tianbo.mall.dto.OmsOrderReturnApplyResult;
import com.tianbo.mall.dto.OmsReturnApplyQueryParam;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单退货申请 Mapper 接口
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderReturnApplyMapper {

    int updateByPrimaryKeySelective(OmsOrderReturnApply record);

    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
