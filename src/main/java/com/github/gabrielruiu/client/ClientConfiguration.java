package com.github.gabrielruiu.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
@Configuration
public class ClientConfiguration {

    @Bean
    @Profile("client-impl-two")
    public ClientInterface clientImplementationTwo() {
        return new ClientImplementationTwo();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClientInterface clientImplementationOne() {
        return new ClientImplementationOne();
    }
}
