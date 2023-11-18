package com.tianbo.mall.modules.oms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianbo.mall.modules.oms.mapper.OmsOrderReturnReasonMapper;
import com.tianbo.mall.modules.oms.model.OmsOrderReturnReason;
import com.tianbo.mall.modules.oms.service.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 退货原因表 服务实现类
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
@Service
public class OmsOrderReturnReasonServiceImpl extends ServiceImpl<OmsOrderReturnReasonMapper, OmsOrderReturnReason> implements OmsOrderReturnReasonService {
    @Autowired
    private OmsOrderReturnReasonMapper returnReasonMapper;
    @Override
    public int create(OmsOrderReturnReason returnReason) {
        returnReason.setCreateTime(new Date());
        return returnReasonMapper.insert(returnReason);
    }

    @Override
    public int update(Long id, OmsOrderReturnReason returnReason) {
        returnReason.setId(id);
        return returnReasonMapper.updateByPrimaryKey(returnReason);
    }


    @Override
    public Page list(String keyword, Integer pageNum, Integer pageSize) {
        Page page=new Page(pageNum,pageSize);

        QueryWrapper<OmsOrderReturnReason> pmsBrandQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(keyword)){
            pmsBrandQueryWrapper.lambda().like(OmsOrderReturnReason::getName,keyword);
        }
        pmsBrandQueryWrapper.lambda().orderByAsc(OmsOrderReturnReason::getSort);

        return this.page(page,pmsBrandQueryWrapper);
    }

    @Override
    public boolean updateStatus(Integer status, List<Long> ids, SFunction<OmsOrderReturnReason, ?> getStatus) {
        UpdateWrapper<OmsOrderReturnReason> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(getStatus,status)
                .in(OmsOrderReturnReason::getId,ids);   // where in (ids)
        return this.update(updateWrapper);
    }

    @Override
    public OmsOrderReturnReason getItem(Long id) {
        return returnReasonMapper.selectByPrimaryKey(id);
    }
}
