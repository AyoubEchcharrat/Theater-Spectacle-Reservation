package com.demo.api.personnes;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/rest") // Pas besoin d'ajouter d'autres configurations
public class RestApplicationConfiguration extends Application {

}