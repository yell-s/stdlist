package com.example.StdList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.StdList.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
