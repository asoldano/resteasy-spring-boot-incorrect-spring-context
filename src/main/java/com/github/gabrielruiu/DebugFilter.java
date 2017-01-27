package com.github.gabrielruiu;

import com.github.gabrielruiu.client.ClientInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:gabriel.ruiu@1and1.ro">Gabriel Ruiu</a>
 */
@Component
public class DebugFilter extends GenericFilterBean {

    private static final Logger LOG = LoggerFactory.getLogger(DebugFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        LOG.info("Implementation of ClientInterface: " + context.getBean(ClientInterface.class).getClass());
        chain.doFilter(request, response);
    }
}
