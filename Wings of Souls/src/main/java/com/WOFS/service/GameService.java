package com.WOFS.service;

import com.WOFS.entity.Game;
import com.WOFS.repository.GameRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos
 */

@Service
public class GameService implements IGameService{

    @Autowired
    private GameRepository gameRepository;
    
    @Override
    public List<Game> listGames() {
        return (List<Game>) gameRepository.findAll();
    }

    @Override
    public Game getGameeById(long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    public void deleteGame(long id) {
        gameRepository.deleteById(id);
    }
        
}
