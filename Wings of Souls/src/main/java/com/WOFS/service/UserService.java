package com.WOFS.service;

import com.WOFS.entity.User;
import com.WOFS.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos
 */

@Service
public class UserService implements IUserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
        
    @Override
    public User findByIdentification(String identification) {
        return userRepository.findByIdentification(identification);
    }
}
