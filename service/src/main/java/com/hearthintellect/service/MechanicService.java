package com.hearthintellect.service;

import com.google.gson.Gson;
import com.hearthintellect.dao.MechanicRepository;
import com.hearthintellect.model.Mechanic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.hearthintellect.utils.RsResponseUtils.badRequest;
import static com.hearthintellect.utils.RsResponseUtils.notFound;
import static com.hearthintellect.utils.RsResponseUtils.ok;

/**
 * JAX-RS service class for {@link Mechanic}.
 */
@Path("/mechanics")
@Produces(MediaType.APPLICATION_JSON)
public class MechanicService {
    private static final Logger LOG = LoggerFactory.getLogger(MechanicService.class);

    @Autowired private MechanicRepository mechanicRepository;
    @Autowired private Gson gson;

    @GET
    public Response listMechanics() {
        LOG.debug("GET  /mechanics");

        return ok(gson.toJson(mechanicRepository.findAll()));
    }

    @GET
    @Path("/{mechanicId}")
    public Response getMechanic(@PathParam("mechanicId") String mechanicIdStr) {
        if (mechanicIdStr.trim().isEmpty())
            return badRequest("Mechanic ID cannot be empty.");

        Integer mechanicId;
        try {
            mechanicId = Integer.valueOf(mechanicIdStr);
        } catch (NumberFormatException ex) {
            return notFound("Mechanic with ID `" + mechanicIdStr + "` does not exist.");
        }

        Mechanic mechanic = mechanicRepository.findById(mechanicId);
        if (mechanic == null)
            return notFound("Mechanic with ID `" + mechanicIdStr + "` does not exist.");

        return ok(gson.toJson(mechanic));
    }

    public MechanicRepository getMechanicRepository() {
        return mechanicRepository;
    }

    public void setMechanicRepository(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

}
