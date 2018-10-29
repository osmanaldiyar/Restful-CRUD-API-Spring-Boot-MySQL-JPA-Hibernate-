package com.oaapps.easy_notes_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyNotesCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyNotesCrudApplication.class, args);
    }
}
