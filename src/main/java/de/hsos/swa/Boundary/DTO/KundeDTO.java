package de.hsos.swa.Boundary.DTO;

import de.hsos.swa.Entity.Adresse;
import de.hsos.swa.Entity.Kunde;
import io.quarkus.resteasy.reactive.links.RestLinkId;

public class KundeDTO {
    
    @RestLinkId
    public long ID;
    public String vorname;
    public String nachname;
    public Adresse adresse;

    public static KundeDTO fromKunde(Kunde kunde){
        KundeDTO response = new KundeDTO();
        response.ID = kunde.getId();
        response.vorname = kunde.getVorname();
        response.nachname = kunde.getNachname();
        response.adresse = kunde.getAdresse();

        return response;
    }

    public static Kunde toKunde(KundeDTO kundeDTO){

        Kunde kunde = new Kunde(kundeDTO.vorname, kundeDTO.nachname);

        if (kundeDTO.adresse != null){
            kunde.setAdresse(kundeDTO.adresse);
        }

        return kunde;
        
    }

}
