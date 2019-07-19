package com.lovemesomecoding;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringbootLiquibaseApplication {

	public static void main(String[] args) {
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(SpringbootLiquibaseApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            // Display Environmental Useful Variables
            try {
                System.out.println("\n");
                Runtime runtime = Runtime.getRuntime();
                double mb = 1048576;// megabtye to byte
                double gb = 1073741824;// gigabyte to byte
                Environment env = ctx.getEnvironment();

                System.out.println("************************ Springboot - liquibase ***************************");
                System.out.println("** Active Profile: " + Arrays.toString(env.getActiveProfiles()));
                System.out.println("** Port: " + env.getProperty("server.port"));
                System.out.println("** Build: " + "0.0.267");
                if (Arrays.toString(env.getActiveProfiles()).equals("[local]")) {
                    System.out.println("** Internal Url: http://" + env.getProperty("project.host") + ":" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path"));
                    System.out
                            .println("** External Url: http://" + InetAddress.getLocalHost().getHostAddress() + ":" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path"));

                    System.out.println("** Internal Swagger: http://" + env.getProperty("project.host") + ":" + env.getProperty("server.port") + env.getProperty("server.servlet.context-path")
                            + "/swagger-ui.html");
                    System.out.println("** External Swagger: http://" + InetAddress.getLocalHost().getHostAddress() + ":" + env.getProperty("server.port")
                            + env.getProperty("server.servlet.context-path") + "/swagger-ui.html");

                } else {
                    System.out.println("** External Url: https://" + env.getProperty("project.host") + env.getProperty("server.servlet.context-path"));
                    System.out.println("** External Swagger: https://" + env.getProperty("project.host") + env.getProperty("server.servlet.context-path") + "/swagger-ui.html");

                }
                
                System.out.println("************************* Java - JVM *****************************************");
                System.out.println("** Number of processors: " + runtime.availableProcessors());
                String processName = ManagementFactory.getRuntimeMXBean().getName();
                System.out.println("** Process ID: "+processName.split("@")[0]);
                System.out.println("** Total memory: " + (double) (runtime.totalMemory() / mb) + " MB = " + (double) (runtime.totalMemory() / gb) + " GB");
                System.out.println("** Max memory: " + (double) (runtime.maxMemory() / mb) + " MB = " + (double) (runtime.maxMemory() / gb) + " GB");
                System.out.println("** Free memory: " + (double) (runtime.freeMemory() / mb) + " MB = " + (double) (runtime.freeMemory() / gb) + " GB");
                System.out.println("******************************************************************************");
            } catch (Exception e) {
                System.err.println("Exception, commandlineRunner -> " + e.getMessage());
            }
            System.out.println("\n");
        };
    }


}
