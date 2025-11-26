package com.example.StdList.services;

import java.util.List;

import com.example.StdList.dto.GameDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StdList.dto.GameMinDTO;
import com.example.StdList.entities.Game;
import com.example.StdList.repositories.GameRepository;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
    @Transactional
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
}
