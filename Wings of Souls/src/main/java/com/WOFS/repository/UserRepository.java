package com.WOFS.repository;

import com.WOFS.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByIdentification (String identification);
}
