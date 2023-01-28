package com.example.sbb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SiteUserSecurityService implements UserDetailsService {
    private final SiteUserRepository siteUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _siteuser = this.siteUserRepository.findByusername(username);
        if (_siteuser.isEmpty()){
            throw new UsernameNotFoundException("Cannot find the user.");
        }
        SiteUser siteUser = _siteuser.get();
        List<GrantedAuthority> authorityList = new ArrayList<>();

        if ("admin".equals(username)){
            authorityList.add(new SimpleGrantedAuthority(SiteUserRole.ADMIN.getValue()));
        } else{
            authorityList.add(new SimpleGrantedAuthority(SiteUserRole.USER.getValue()));
        }
        return new User(siteUser.getUsername(), siteUser.getPassword(), authorityList);
    }
}
