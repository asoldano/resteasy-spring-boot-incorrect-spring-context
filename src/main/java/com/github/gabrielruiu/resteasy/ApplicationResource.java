package com.github.gabrielruiu.resteasy;

import com.github.gabrielruiu.client.ClientInterface;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
@Component
@Path("/")
public class ApplicationResource {

    private ClientInterface client;

    public ApplicationResource(ClientInterface client) {
        this.client = client;
    }

    @GET
    @Produces("text/plain")
    public Response delegateCallToClient() {
        return Response.ok(client.callClient()).build();
    }
}
