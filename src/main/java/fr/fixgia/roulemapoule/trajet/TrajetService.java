package fr.fixgia.roulemapoule.trajet;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public void saveTrajet(Trajet trajet) {
        trajetRepository.save(trajet);
    }



    @Override
    public List<Trajet> getAllTrajet() {
        return trajetRepository.findAll();
    }

    public List<Trajet> getTrajetByVilleDepart(String villeDepart) {
        return null;
   //     return trajetRepository.findTrajetsByVille_depart(villeDepart);
    }

    public List<Trajet> getTrajetByVilleArrivee(String villeArrivee) {
        return null;
     //   return trajetRepository.findTrajetsByVille_arrivee(villeArrivee);
    }

    public List<Trajet> getTrajetByVilleDepartAndArrivee(String villeDepart, String villeArrivee) {
        return null;
     //   return trajetRepository.findTrajetsByVille_departAndVille_arrivee(villeDepart,villeArrivee);
    }

    public Trajet getTrajetById(UUID id) {
        Optional<Trajet> trajet = trajetRepository.findById(id);
        if(trajet.isPresent()) {
            return trajet.get();
        }
        throw new RuntimeException("Le trajet n'existe pas");
    }

    @Override
    public void supprimerTrajet(UUID uuid) {
       Trajet trajetToDelete = trajetRepository.getReferenceById(uuid);
       trajetRepository.delete(trajetToDelete);
    }
}
