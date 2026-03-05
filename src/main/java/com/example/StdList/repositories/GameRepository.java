package com.example.StdList.repositories;

import com.example.StdList.entities.Game;
import com.example.StdList.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
        SELECT tg.id, tg.title, tg.game_year AS gameYear, tg.img_url AS imgUrl,tg.short_description AS shortDescription, tb.position
        FROM tb_game tg
        INNER JOIN tb_belonging tb ON tg.id = tb.game_id
        WHERE tb.list_id = :listId
        ORDER BY tb.position
        """)
    List<GameMinProjection> searchByList(Long listId);
}
