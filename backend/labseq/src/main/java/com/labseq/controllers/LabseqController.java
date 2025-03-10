package com.labseq.controllers;

import com.labseq.services.LabseqService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/labseq")
@Tag(name = "Labseq Controller", description = "Endpoints for Labseq calculations")
public class LabseqController {

    @Inject
    private LabseqService service;

    @GET
    @Path("/{n}")
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get Labseq value",description = "Returns the Labseq value for the given index n")
    @APIResponse(responseCode = "200",description = "Successfully calculated Labseq value")
    @APIResponse(responseCode = "400",description = "Invalid parameter provided")
    public String getLabSeqValue(@Parameter(description = "The index of Labseq sequence to calculate", required = true) @PathParam("n") int n) {
        return service.getLabSeqValue(n);
    }
}
