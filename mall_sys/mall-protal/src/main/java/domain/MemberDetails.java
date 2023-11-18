package domain;

import com.tianbo.mall.modules.ums.model.UmsMember;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/***
 * 用户信息、用户权限信息
 */
public class MemberDetails implements UserDetails {

    // 用户信息
    private UmsMember umsMember;

    public MemberDetails(UmsMember umsMember) {
        this.umsMember = umsMember;
    }


    /**
     * 前台除了白名单 没有其他的权限资源
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return umsMember.getPassword();
    }

    @Override
    public String getUsername() {
        return umsMember.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 用户是否启用状态
     * @return
     */
    @Override
    public boolean isEnabled() {
        return umsMember.getStatus()==1;
    }


    public UmsMember getUmsMember() {
        return umsMember;
    }
}
