package com.tianbo.mall.dto;

import com.tianbo.mall.modules.ums.model.UmsResource;
import com.tianbo.mall.modules.ums.model.UmsRole;
import lombok.Data;

import java.util.List;


@Data
public class ResourceRoleDTO extends UmsResource {

    private List<UmsRole> roleList;
}
