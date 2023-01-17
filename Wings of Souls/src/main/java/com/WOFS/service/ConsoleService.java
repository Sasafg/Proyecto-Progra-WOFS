package com.WOFS.service;

import com.WOFS.entity.Console;
import com.WOFS.repository.ConsoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Carlos
 */
@Service
public class ConsoleService implements IConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

    @Override
    public List<Console> listConsoles() {
        return (List<Console>) consoleRepository.findAll();
    }

    @Override
    public Console getConsoleById(long id) {
        return consoleRepository.findById(id).orElse(null);
    }

    @Override
    public void saveConsole(Console console) {
        consoleRepository.save(console);
    }

    @Override
    public void deleteConsole(long id) {
        consoleRepository.deleteById(id);
    }
    
}
