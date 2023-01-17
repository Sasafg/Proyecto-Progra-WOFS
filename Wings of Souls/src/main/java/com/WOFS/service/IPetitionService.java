package com.WOFS.service;

import com.WOFS.entity.Petition;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface IPetitionService {
    public List<Petition> listPetitions();
    public Petition getPetitionById(long id);
    public void savePetition(Petition petition);
    public void deletePetition(long id);
}
