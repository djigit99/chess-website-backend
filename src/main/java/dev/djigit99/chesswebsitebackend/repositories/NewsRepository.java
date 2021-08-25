package dev.djigit99.chesswebsitebackend.repositories;

import dev.djigit99.chesswebsitebackend.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    News findNewsById(Integer id);
}
