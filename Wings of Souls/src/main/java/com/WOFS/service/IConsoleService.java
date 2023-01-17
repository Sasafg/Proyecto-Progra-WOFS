package com.WOFS.service;

import com.WOFS.entity.Console;
import java.util.List;

/**
 *
 * @author Juan Carlos
 */
public interface IConsoleService {
    public List<Console> listConsoles();
    public Console getConsoleById(long id);
    public void saveConsole(Console console);
    public void deleteConsole(long id);
}
