package de.hsos.swa.Gateway;

import java.util.List;

import de.hsos.swa.Controller.KundenController;
import de.hsos.swa.Entity.Adresse;
import de.hsos.swa.Entity.Kunde;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

//@RequestScoped
@ApplicationScoped
public class KundeRepo implements KundenController, PanacheRepository<Kunde> {

    @Override
    public Kunde kundeAnlegen(Kunde kunde) {
        persist(kunde);
        return kunde;
    }

    @Override
    public Kunde kundeAbfragen(long id) {
        return findById(id);
    }

    @Override
    public List<Kunde> alleKundenabfragen() {
        return listAll();
    }

    @Override
    public Kunde kundeAendern(long id, Kunde neuerKunde) {
        Kunde kunde = findById(id);
        if (kunde != null) {
            kunde.setVorname(neuerKunde.getVorname());
            kunde.setNachname(neuerKunde.getNachname());
            persist(kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde kundeLoeschen(long id) {
        Kunde kunde = findById(id);
        if (kunde != null) {
            delete(kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde adresseAnlegen(long id, Kunde kundeWithAdresse) {
        Kunde kunde = findById(id);
        if (kunde != null && kundeWithAdresse.getAdresse() != null) {
            kunde.setAdresse(kundeWithAdresse.getAdresse());
            persist(kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde adresseAbfragen(long id) {
        Kunde kunde = findById(id);
        return (kunde != null && kunde.getAdresse() != null) ? kunde : null;
    }

    @Override
    public Kunde adresseAendern(long id, Kunde kundeWithAdresse) {
        Kunde kunde = findById(id);
        if (kunde != null && kundeWithAdresse.getAdresse() != null) {
            Adresse neueAdresse = kundeWithAdresse.getAdresse();
            
            if (kunde.getAdresse() == null) {
                kunde.setAdresse(neueAdresse);
            } else {
                Adresse adresse = kunde.getAdresse();
                adresse.setStrasse(neueAdresse.getStrasse());
                adresse.setHausnummer(neueAdresse.getHausnummer());
                adresse.setPlz(neueAdresse.getPlz());
                adresse.setOrt(neueAdresse.getOrt());
            }
            
            persist(kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde adresseLoeschen(long id) {
        Kunde kunde = findById(id);
        if (kunde != null) {
            kunde.setAdresse(null);
            persist(kunde);
            return kunde;
        }
        return null;
    }

}
