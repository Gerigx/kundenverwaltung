package de.hsos.swa.Boundary;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jboss.resteasy.reactive.RestResponse;

import de.hsos.swa.Boundary.DTO.KundeDTO;
import de.hsos.swa.Controller.KundenController;
import de.hsos.swa.Entity.Kunde;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//@RequestScoped
@ApplicationScoped
@Path("/kunden")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class KundenRessource {

    @Inject
    KundenController kundenController;

    @GET
    public RestResponse<List<KundeDTO>> getAllKunden(){

        List<Kunde> kunden = kundenController.alleKundenabfragen().stream().toList(); 
        List<KundeDTO> kundenDTOs = kunden.stream()
                                    .map(KundeDTO::fromKunde)
                                    .collect(Collectors.toList());
        
        return RestResponse.ok(kundenDTOs);        
    }

    @POST
    public RestResponse<KundeDTO> addKunde(KundeDTO kundeDTO){
        Kunde kunde = KundeDTO.toKunde(kundeDTO);

        Kunde savedKunde = kundenController.kundeAnlegen(kunde);

        return RestResponse.ok(KundeDTO.fromKunde(savedKunde));
    }

}
