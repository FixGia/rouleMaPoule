package fr.fixgia.roulemapoule.trajet;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TrajetService implements ITrajetService{
    private final TrajetRepository trajetRepository;

    public TrajetService(TrajetRepository trajetRepository) {
        this.trajetRepository = trajetRepository;
    }

    @Override
    public void createTrajet(Trajet trajet) {
        trajet.setPlaces(trajet.getPlaces()- 1);
        trajetRepository.save(trajet);

    }

    @Override
    public void reserverTrajet() {

    }

    @Override
    public void annulerTrajet() {
    }

    @Override
    public List<Trajet> getAllTrajet() {
        return trajetRepository.findAll();
    }

    @Override
    public void supprimerTrajet(UUID uuid) {
       Trajet trajetToDelete = trajetRepository.getReferenceById(uuid);
       trajetRepository.delete(trajetToDelete);
    }
}
