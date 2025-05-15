package de.hsos.swa.Boundary.DTO;

import de.hsos.swa.Entity.Adresse;
import de.hsos.swa.Entity.Kunde;
import io.quarkus.resteasy.reactive.links.RestLinkId;

public class KundeResponseDTO {
    
    @RestLinkId
    public long ID;
    public String vorname;
    public String nachname;
    public String adresse;

    public static KundeResponseDTO from(Kunde kunde){
        KundeResponseDTO response = new KundeResponseDTO();
        response.ID = kunde.getId();
        response.vorname = kunde.getVorname();
        response.nachname = kunde.getNachname();
        response.adresse = kunde.getAdresse().toString();

        return response;
    }

}
