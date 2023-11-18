package com.tianbo.mall.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.dto.OmsOrderReturnApplyResult;
import com.tianbo.mall.dto.OmsReturnApplyQueryParam;
import com.tianbo.mall.dto.OmsUpdateStatusParam;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnApply;

import java.util.List;

/**
 * <p>
 * 订单退货申请 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
//    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
