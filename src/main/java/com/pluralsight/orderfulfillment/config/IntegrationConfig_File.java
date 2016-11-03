package com.pluralsight.orderfulfillment.config;

import java.util.*;

import javax.inject.*;

import org.apache.camel.builder.*;
import org.apache.camel.spring.javaconfig.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;

/**
 * Spring configuration for Apache Camel
 *
 * @author Michael Hoffman, Pluralsight
 */
@Configuration
public class IntegrationConfig_File extends CamelConfiguration {

    @Inject
    private Environment environment;

    @Override
    public List<RouteBuilder> routes() {
        List<RouteBuilder> route_notuse = new ArrayList<RouteBuilder>();
        List<RouteBuilder> routeList = new ArrayList<RouteBuilder>();

        route_notuse.add(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://" + environment.getProperty("order.fulfillment.center.1.outbound.folder") + "?noop=true")
                .to("file://" + environment.getProperty("order.fulfillment.center.1.inbound.folder") + "/test");
            }
        });



        return routeList;
    }
}
