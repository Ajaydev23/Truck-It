package com.aj23.truckit_admin.security.services;



import com.icb.icodeQuestionAi.model.Role;
import com.icb.icodeQuestionAi.model.User;
import com.icb.icodeQuestionAi.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username).orElseThrow(
            ()->new UsernameNotFoundException("user not found with email id : " + username)
    );
    return UserDetailsImpl.build(user);
  }

  private Set<GrantedAuthority> getAuthorities(Set<Role> roles) {
    return roles.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
            .collect(Collectors.toSet());
  }
}
