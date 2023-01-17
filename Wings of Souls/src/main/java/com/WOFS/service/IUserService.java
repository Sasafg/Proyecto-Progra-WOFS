package com.WOFS.service;

import com.WOFS.entity.User;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface IUserService {
    public List<User> listUsers();
    public User getUserById(long id);
    public void saveUser(User user);
    public void deleteUser(long id);
    public User findByIdentification (String identification);
}
