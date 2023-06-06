package fr.fixgia.roulemapoule.trajet;

import java.util.List;
import java.util.UUID;

public interface ITrajetService {

    void createTrajet(Trajet trajet);

    void reserverTrajet();

    void annulerTrajet();

    List<Trajet> getAllTrajet();

    void supprimerTrajet(UUID uuid);

}
