package com.tianbo.mall.modules.oms.service;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnReason;
import com.tianbo.mall.modules.product.model.PmsProduct;

import java.util.List;

/**
 * <p>
 * 退货原因表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
public interface OmsOrderReturnReasonService extends IService<OmsOrderReturnReason> {
    /**
     * 添加订单原因
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * 修改退货原因
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     */
//    int delete(List<Long> ids);

    /**
     * 分页获取退货原因
     */
//    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * 批量修改退货原因状态
     */

    boolean updateStatus(Integer status, List<Long> ids, SFunction<OmsOrderReturnReason, ?> getStatus);

    /**
     * 获取单个退货原因详情信息
     */
    OmsOrderReturnReason getItem(Long id);

    Page list(String keyword, Integer pageNum, Integer pageSize);

}
