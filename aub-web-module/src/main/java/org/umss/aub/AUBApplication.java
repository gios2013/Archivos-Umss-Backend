package org.umss.aub;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.umss.aub.constants.AubConstants;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class AUBApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(AUBApplication.class);

    public static void main(String[] args) {
        var springApplication = new SpringApplication(AUBApplication.class);
        Environment environment = springApplication.run(args).getEnvironment();
        logApplicationStarup(environment);
    }

    @Bean
    public WebMvcConfigurer configureCors() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/v1/config/**")
                        .allowedOrigins("http://localhost:4200");
                registry.addMapping("/v1/tramites/**")
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }

    private static void logApplicationStarup(Environment env) {
        var protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store"))
                .map(key -> "https")
                .orElse("http");
        var serverPort = env.getProperty("server.port");
        var contextPath = Optional
                .ofNullable(env.getProperty("server.servlet.context-path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");
        var hostAddress = "localhost";

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.warn("The host name could not be determined, using 'localhost' as fallback");
        }

        var textBlock = String.format("----------------------------------------------------------\n" +
                        "                    Application \"%s\" is running! Access URLs:\n" +
                        "                    Local:              %s://localhost:%s%s\n" +
                        "                    External:           %s://%s:%s%s\n" +
                        "                    Active Profile(s):  %s\n" +
                        "                    Default Profile(s): %s\n" +
                        "                ----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                Arrays.toString(env.getActiveProfiles()),
                Arrays.toString(env.getDefaultProfiles()));
        LOGGER.info(textBlock);
    }
}
