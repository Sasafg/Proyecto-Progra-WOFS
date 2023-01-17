package com.WOFS.repository;

import com.WOFS.entity.Console;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos
 */

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long>{
    
}
