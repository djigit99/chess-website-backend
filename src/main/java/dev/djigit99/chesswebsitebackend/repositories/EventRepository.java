package dev.djigit99.chesswebsitebackend.repositories;

import dev.djigit99.chesswebsitebackend.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findEventById(Integer id);
}
