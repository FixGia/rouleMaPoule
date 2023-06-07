package fr.fixgia.roulemapoule.trajet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, UUID> {

    //List<Trajet> findTrajetsByVille_depart(String ville_depart);

   // List<Trajet> findTrajetsByVille_arrivee(String ville_arrivee);

   // List<Trajet> findTrajetsByVille_departAndVille_arrivee(String villeDepart, String villeArrivee);
}
