package de.hsos.swa.Boundary;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.common.util.RestMediaType;

import de.hsos.swa.Boundary.DTO.KundeResponseDTO;
import de.hsos.swa.Controller.KundenController;
import de.hsos.swa.Entity.Kunde;
import io.quarkus.resteasy.reactive.links.InjectRestLinks;
import io.quarkus.resteasy.reactive.links.RestLink;
import io.quarkus.resteasy.reactive.links.RestLinkType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//@RequestScoped
@Path("/kunde/{id}")
@ApplicationScoped
@Transactional
@Produces({MediaType.APPLICATION_JSON, RestMediaType.APPLICATION_HAL_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class KundeRessource {

    @Inject
    KundenController kundenController;


    @GET
    @RestLink(rel = "self")
    @InjectRestLinks(RestLinkType.INSTANCE)
    public RestResponse<KundeResponseDTO> getKunde(
        @Parameter(description = "ID eines Schiffes")
        @PathParam("id") long id
    ){
        Kunde kunde = kundenController.kundeAbfragen(id);
        if (kunde == null) {
            throw new NotFoundException();
        }

        return RestResponse.ok(KundeResponseDTO.from(kunde));
    }

    @POST
    public 

}
