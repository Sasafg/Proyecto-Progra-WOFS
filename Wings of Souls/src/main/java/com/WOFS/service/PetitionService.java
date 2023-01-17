package com.WOFS.service;

import com.WOFS.entity.Petition;
import com.WOFS.repository.PetitionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos
 */

@Service
public class PetitionService implements IPetitionService{
    
    @Autowired
    private PetitionRepository petitionRepository;

    @Override
    public List<Petition> listPetitions() {
        return (List<Petition>) petitionRepository.findAll();
    }

    @Override
    public Petition getPetitionById(long id) {
        return petitionRepository.findById(id).orElse(null);
    }

    @Override
    public void savePetition(Petition petition) {
       petitionRepository.save(petition);
    }

    @Override
    public void deletePetition(long id) {
        petitionRepository.deleteById(id);
    }
    
}
