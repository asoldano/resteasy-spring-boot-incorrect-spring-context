package com.github.gabrielruiu.resteasy;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
@Component
@ApplicationPath("/app")
public class JaxRsApplication extends Application {
}
