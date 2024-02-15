package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class TestNouvelleAPI {

    @Path("{param}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testeExpressionLitterale(String param) {
        String res = "contient que des caracteres autorisés ? ";
        res += neContientQueDesCaracteresAutorises(param);
        return res;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "salut machin !";
    }

    public static boolean neContientQueDesCaracteresAutorises(String chaine) {
        // Utilisation d'une expression régulière pour vérifier si la chaîne contient
        // uniquement des chiffres
        return chaine.matches("[0-9a-z()+\\-*/]+");
    }

}
