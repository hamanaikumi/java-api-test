package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Player;
import com.example.demo.Repository.PlayerMapper;

@Service
public class PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    @Transactional
    public List<Player> findAll() {
        return playerMapper.findAll();
    }

    @Transactional
    public Player findOne(Long id) {
        return playerMapper.findOne(id);
    }

    @Transactional
    public void save(Player player) {
        playerMapper.save(player);
    }

    @Transactional
    public void update(Player player) {
        playerMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
        playerMapper.delete(id);
    }
}