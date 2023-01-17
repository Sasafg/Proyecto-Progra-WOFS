package com.WOFS.repository;

import com.WOFS.entity.Petition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Carlos
 */

@Repository
public interface PetitionRepository extends CrudRepository<Petition, Long>{
    
}
