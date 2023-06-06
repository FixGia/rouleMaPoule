package fr.fixgia.roulemapoule.trajet;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrajetService implements ITrajetService{

    private final TrajetRepository trajetRepository;

    public TrajetService(TrajetRepository trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public void createTrajet(Trajet trajet) {
        trajet.reserver = true;
        trajetRepository.save(trajet);
    }

    @Override
    public void reserverTrajet() {

    }

    @Override
    public void annulerTrajet() {

    }

    @Override
    public void supprimerTrajet(UUID uuid) {
       Trajet trajetToDelete = trajetRepository.getReferenceById(uuid);
       trajetRepository.delete(trajetToDelete);
    }
}
