package com.WOFS.service;

import com.WOFS.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos
 */
@Service
public class UsersSecurityService implements UserDetailsService     {

    @Autowired
    public IUserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findByIdentification(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
    
}
