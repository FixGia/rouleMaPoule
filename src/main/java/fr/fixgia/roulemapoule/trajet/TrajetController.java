package fr.fixgia.roulemapoule.trajet;

import fr.fixgia.roulemapoule.user.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/trajet")
@Slf4j
public class TrajetController {

    private final ITrajetService trajetService;

    public TrajetController(ITrajetService trajetService) {
        this.trajetService = trajetService;
    }

    @PostMapping("/addTrajet")
    @ResponseStatus(HttpStatus.CREATED)
    public Trajet createUser(@RequestBody final Trajet trajet) {

        log.debug("Controller TrajetApplication: create Trajet - Called");
        trajetService.createTrajet(trajet);
        return trajet;
    }


    @PostMapping("/deleteTrajet/{uuid}")
    public void deletePatient(@PathVariable("id") UUID uuid){

        log.debug("Controller UserApplication: deleteUser - called");
        trajetService.supprimerTrajet(uuid);
    }

    @GetMapping("/all")
    public void getAllTrajet() {
        trajetService.getAllTrajet();
    }
}
