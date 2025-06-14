package fh.aalen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Startklasse der Anwendung.
 */
@SpringBootApplication
public class Anwendung {

    /**
     * Einstiegspunkt der Anwendung.
     * 
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        SpringApplication.run(Anwendung.class, args);
    }
}
