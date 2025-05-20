package com.github.irang.checkpoint.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final User user; // User 엔티티를 감싸는 역할

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Grade enum에서 권한 이름을 가져와 GrantedAuthority 리스트로 변환
        return Collections.singletonList(new SimpleGrantedAuthority(user.getGrade().getRoleName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // 필요에 따라 사용자 엔티티에 필드 추가 후 처리 가능
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // 필요에 따라 사용자 엔티티에 필드 추가 후 처리 가능
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // 필요에 따라 사용자 엔티티에 필드 추가 후 처리 가능
    }

    @Override
    public boolean isEnabled() {
        return true;  // 필요에 따라 사용자 활성화 상태 처리 가능
    }

    // 필요하면 User 엔티티 직접 접근을 위한 getter 추가
    public User getUser() {
        return user;
    }
}

