package de.hsos.swa.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import de.hsos.swa.Entity.Adresse;
import de.hsos.swa.Entity.Kunde;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

//@RequestScoped
@ApplicationScoped
public class KundenService implements KundenController {

    private Map<Long, Kunde> kundenMap = new ConcurrentHashMap<>();
    private AtomicLong idCounter = new AtomicLong(1);
    

    @Override
    public Kunde kundeAnlegen(Kunde kunde) {
        long id = idCounter.getAndIncrement();
        kunde.setId(id);
        kundenMap.put(id, kunde);
        return kunde;
    }

    @Override
    public Kunde kundeAbfragen(long id) {
        return kundenMap.get(id);
    }

    @Override
    public List<Kunde> alleKundenabfragen() {
        return new ArrayList<>(kundenMap.values());
    }

    @Override
    public Kunde kundeAendern(long id, Kunde neuerKunde) {
        Kunde kunde = kundenMap.get(id);
        if (kunde != null) {
            kunde.setVorname(neuerKunde.getVorname());
            kunde.setNachname(neuerKunde.getNachname());
            kundenMap.put(id, kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde kundeLoeschen(long id) {
        return kundenMap.remove(id);
    }

    @Override
    public Kunde adresseAnlegen(long id, Kunde kundeWithAdresse) {
        Kunde kunde = kundenMap.get(id);
        if (kunde != null && kundeWithAdresse.getAdresse() != null) {
            kunde.setAdresse(kundeWithAdresse.getAdresse());
            kundenMap.put(id, kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde adresseAbfragen(long id) {
        Kunde kunde = kundenMap.get(id);
        return (kunde != null && kunde.getAdresse() != null) ? kunde : null;
    }

    @Override
    public Kunde adresseAendern(long id, Kunde kundeWithAdresse) {
        Kunde kunde = kundenMap.get(id);
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
            
            kundenMap.put(id, kunde);
            return kunde;
        }
        return null;
    }

    @Override
    public Kunde adresseLoeschen(long id) {
        Kunde kunde = kundenMap.get(id);
        if (kunde != null) {
            kunde.setAdresse(null);
            kundenMap.put(id, kunde);
            return kunde;
        }
        return null;
    }

}
