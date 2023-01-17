package com.WOFS.service;

import com.WOFS.entity.Game;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface IGameService {
    public List<Game> listGames();
    public Game getGameeById(long id);
    public void saveGame(Game game);
    public void deleteGame(long id);
}
