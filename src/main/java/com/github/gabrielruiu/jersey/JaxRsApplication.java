package com.github.gabrielruiu.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
@Component
public class JaxRsApplication extends ResourceConfig {

    public JaxRsApplication() {
        register(ApplicationResource.class);
    }
}
