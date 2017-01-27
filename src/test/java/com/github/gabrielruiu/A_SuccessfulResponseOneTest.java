package com.github.gabrielruiu;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
public class A_SuccessfulResponseOneTest extends IntegrationTest {

    @Test
    public void shouldReceiveResponseFromClientImplOne() {
        String response = restTemplate.getForObject(getUrl(), String.class);

        assertThat(response, notNullValue());
        assertThat(response, is("client implementation ONE"));
    }
}
