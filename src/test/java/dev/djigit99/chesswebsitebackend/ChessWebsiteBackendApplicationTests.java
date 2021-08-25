package dev.djigit99.chesswebsitebackend;

import dev.djigit99.chesswebsitebackend.controllers.EventController;
import dev.djigit99.chesswebsitebackend.controllers.NewsController;
import dev.djigit99.chesswebsitebackend.repositories.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ChessWebsiteBackendApplicationTests {

    @Autowired
    private EventController eventController;

    @Autowired
    private EventRepository eventRepository;

    @Test
    void contextLoads() {
        assertThat(eventController).isNotNull();
        assertThat(eventRepository).isNotNull();
    }

}
