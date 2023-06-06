package fr.fixgia.roulemapoule.trajet;

import java.util.UUID;

public interface ITrajetService {

    void createTrajet(Trajet trajet);

    void reserverTrajet();

    void annulerTrajet();

    void getAllTrajet();

    void supprimerTrajet(UUID uuid);

}
