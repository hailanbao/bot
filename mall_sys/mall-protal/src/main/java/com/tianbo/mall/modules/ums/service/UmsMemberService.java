package com.tianbo.mall.modules.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.modules.ums.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 会员表 服务类
 * </p>
 */
public interface UmsMemberService extends IService<UmsMember> {

    UmsMember register(UmsMember umsMemberParam);

    UmsMember login(String username, String password);

    UmsMember getAdminByUsername(String username);

    /**
     * 获取当前登录用户
     * @return
     */
    UmsMember getCurrentMember();

    UserDetails loadUserByUsername(String username);
}
