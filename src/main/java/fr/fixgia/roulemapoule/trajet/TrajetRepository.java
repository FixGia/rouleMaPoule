package fr.fixgia.roulemapoule.trajet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, UUID> {

}
