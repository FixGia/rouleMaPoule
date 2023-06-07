package fr.fixgia.roulemapoule.reservation;

import fr.fixgia.roulemapoule.trajet.ITrajetService;
import fr.fixgia.roulemapoule.trajet.Trajet;
import fr.fixgia.roulemapoule.trajet.TrajetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService implements IReservationService{
    private final ReservationRepository reservationRepository;
    private final ITrajetService trajetService;

    public ReservationService(ReservationRepository reservationRepository, TrajetService trajetService) {
        this.reservationRepository = reservationRepository;
        this.trajetService = trajetService;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    private void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void reserver(Reservation reservation) {
       Reservation reservationExist = reservationRepository.findReservationById(reservation.getId());
       if(reservationExist == null) {
           changerNbDePlaceDuTrajet(reservation.getPassager().size(), reservation.getTrajet().getId());
           createReservation(reservation);
       }
    }

    private void changerNbDePlaceDuTrajet(Integer nbDeUser, UUID uuid) {
       Trajet trajet = trajetService.getTrajetById(uuid);
        Integer nbDePlace = trajet.getPlaces();
        if (nbDePlace > 1) {
            trajet.setPlaces(nbDePlace - nbDeUser);
            trajetService.saveTrajet(trajet);
    }
        throw new RuntimeException("plus de place");
    }

    @Override
    public void supprimerReservation(UUID uuid) {
        Optional<Reservation> reservation = reservationRepository.findById(uuid);
        reservation.ifPresent(reservationRepository::delete);
    }
}
