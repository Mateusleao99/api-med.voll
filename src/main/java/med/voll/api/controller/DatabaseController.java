package med.voll.api.controller;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DatabaseController {

    @Autowired
    private Flyway flyway;

    @GetMapping("/repair")
    public ResponseEntity<String> repairDatabase() {
        flyway.repair();
        return ResponseEntity.ok("Database repair attempted.");
    }
}
