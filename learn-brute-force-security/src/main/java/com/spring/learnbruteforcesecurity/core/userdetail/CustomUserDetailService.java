package com.spring.learnbruteforcesecurity.core.userdetail;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.spring.learnbruteforcesecurity.core.user.jpa.data.Group;
import com.spring.learnbruteforcesecurity.core.user.jpa.data.UserEntity;
import com.spring.learnbruteforcesecurity.core.user.jpa.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailService implements UserDetailsService {
  @Resource
  UserRepository userRepository;

  @Override
  public CustomUser loadUserByUsername(String email) throws UsernameNotFoundException {
    final UserEntity customer = userRepository.findByEmail(email);
    if(customer == null) {
      throw new UsernameNotFoundException(email);
    }
    boolean enabled = !customer.isAccountVerified();
    CustomUser user = CustomUser.CustomUserBuilder.aCustomUser()
    .withUsername(customer.getEmail())
    .withPassword(customer.getPassword())
    .withEnabled(customer.isLoginDisabled())
    .withAuthorities(getAuthorities(customer))
    .withSecret(customer.getSecret())
    .withAccountNonLocked(false)
    .build();
    return user;
  }

  private Collection<GrantedAuthority> getAuthorities(UserEntity user){
    Set<Group> userGroups = user.getUserGroups();
    Collection<GrantedAuthority> authorities = new ArrayList<>(userGroups.size());
    for(Group userGroup : userGroups){
        authorities.add(new SimpleGrantedAuthority(userGroup.getCode().toUpperCase()));
    }

    return authorities;
}
}
