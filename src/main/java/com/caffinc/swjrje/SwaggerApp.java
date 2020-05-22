package com.caffinc.swjrje;

import com.caffinc.swjrje.webservices.EntityBrowser;
//import com.wordnik.swagger.config.ConfigFactory;
//import com.wordnik.swagger.config.ScannerFactory;
//import com.wordnik.swagger.config.SwaggerConfig;
//import com.wordnik.swagger.jaxrs.config.ReflectiveJaxrsScanner;
//import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
//import com.wordnik.swagger.jaxrs.listing.ApiListingResource;
//import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
//import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
//import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
//import com.wordnik.swagger.reader.ClassReaders;
import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.annotation.PostConstruct;

//http://localhost:8080/rest/swagger.json
// http://localhost:8080/rest/api-docs
// /Users/a18502648/Maven/bin/mvn jetty:run
public class SwaggerApp extends ResourceConfig {

    public SwaggerApp() {
      /*  register(EntityBrowser.class);
        register(ApiListingResource.class);
        //register(ApiDeclarationProvider.class);
        //register(ApiListingResourceJSON.class);
        //register(ResourceListingProvider.class);

        property(MessageProperties.XML_FORMAT_OUTPUT, true);
       // property(ServerProperties.TRA, "ALL");*/

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Swagger API Title");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[] { "http" });
        beanConfig.setHost("http://localhost:8080/");
        beanConfig.setBasePath("/rest");
        beanConfig.setResourcePackage(
                "com.caffinc.swjrje.webservices");
        beanConfig.setScan(true);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, Boolean.TRUE);
        packages("com.caffinc.swjrje.webservices");
        packages("io.swagger.jaxrs.listing");
//        register(MoxyJsonFeature.class);
        // register(BadRequestExceptionMapper.class);
        /*register(new MoxyJsonConfig().setFormattedOutput(true)
                // Turn off BV otherwise the entities on server would be validated by MOXy as well.
                .property(MarshallerProperties.BEAN_VALIDATION_MODE, BeanValidationMode.NONE).resolver());*/

//        register(MoxyXmlFeature.class);
        register(RolesAllowedDynamicFeature.class);

    }

//    @PostConstruct
    public void initializeSwaggerConfiguration() {

//        final ReflectiveJaxrsScanner scanner = new ReflectiveJaxrsScanner();
//        scanner.setResourcePackage("com.caffinc.swjrje.webservices");
//        ScannerFactory.setScanner(scanner);
//        ClassReaders.setReader(new DefaultJaxrsApiReader());
//        final SwaggerConfig config = ConfigFactory.config();
//        config.setApiVersion("1.0");
//        config.setBasePath("http://localhost:8080/rest");
    }
}