package com.WOFS.repository;

import com.WOFS.entity.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos
 */

@Repository
public interface GameRepository extends CrudRepository<Game, Long>{
    
}
