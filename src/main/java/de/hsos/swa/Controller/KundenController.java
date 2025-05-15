package de.hsos.swa.Controller;

import java.util.List;

import de.hsos.swa.Entity.Kunde;

public interface KundenController {
    public Kunde kundeAnlegen(Kunde kunde);

    public Kunde kundeAbfragen(long id);
    public List<Kunde> alleKundenabfragen();

    public Kunde kundeAendern(long id, Kunde kunde);

    public Kunde kundeLoeschen(long id);

    // adresse

    public Kunde adresseAnlegen(long id, Kunde kunde);

    public Kunde adresseAbfragen(long id);

    public Kunde adresseAendern(long id, Kunde kunde);

    public Kunde adresseLoeschen(long id);

}
