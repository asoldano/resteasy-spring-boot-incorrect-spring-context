package com.github.gabrielruiu;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
@ActiveProfiles("client-impl-two")
public class B_SuccessfulResponseTwoTest extends IntegrationTest {

    @Test
    public void shouldReceiveResponseFromClientImplTwo() {
        String response = restTemplate.getForObject(getUrl(), String.class);

        assertThat(response, notNullValue());
        assertThat(response, is("client implementation TWO"));
    }
}
