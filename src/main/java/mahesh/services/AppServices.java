package mahesh.services;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.peppermintchain.core.services.PMCServiceContext;

@Path("/")
public class AppServices {

    private PMCServiceContext serviceContext;

    @Inject
    public AppServices(PMCServiceContext ctx) {
	this.serviceContext = ctx;
    }

    @Path("/testService")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, ? extends Object> testService(Map<String, ? extends Object> params) throws Exception {
	/*
	Set<String> signingPeers = new HashSet<>();
	signingPeers.add((String) params.get("buyerId"));
	signingPeers.add((String) params.get("sellerId"));
	serviceContext.runContract(signingPeers, "mahesh", "testContract", params);
	*/
	return params;
    }

}
