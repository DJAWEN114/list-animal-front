package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class GreetingResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "salut Nolann";
    }

    @Path("/animal/{param}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String animal_definition(String param) {
        String reponse;
        switch (param) {
            case "orque":
                reponse = "Les orques, également appelées épaulards, sont des mammifères marins de la famille des delphinidés. Ils se distinguent par leur coloration noire et blanche et leurs habitudes sociales complexes.";
                break;
            case "tigre":
                reponse = "Le tigre est un grand félin de la famille des panthéridés, connu pour son pelage rayé et sa puissance.";
                break;
            case "lion":
                reponse = "Le lion est un grand félin de la famille des panthéridés, souvent appelé roi de la jungle, et connu pour sa crinière.";
                break;
            case "tortue":
                reponse = "La tortue est un reptile de l'ordre des testudines, caractérisé par une carapace dure qui protège son corps.";
                break;
            case "chat":
                reponse = "Le chat est un petit mammifère carnivore domestiqué, apprécié pour sa compagnie et ses qualités de chasseur.";
                break;
            case "chien":
                reponse = "Le chien est un mammifère carnivore domestiqué, connu pour être un fidèle compagnon de l'homme.";
                break;
            default:
                reponse = "Erreur : Mot inconnu.";
        }
        return reponse;
    }

    @Path("/orque")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String orque() {
        return "Les orques, également appelées épaulards, sont des mammifères marins de la famille des delphinidés. Ils se distinguent par leur coloration noire et blanche et leurs habitudes sociales complexes.";
    }

    @Path("/tigre")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String tigre() {
        return "Le tigre est un grand félin de la famille des panthéridés, connu pour son pelage rayé et sa puissance.";
    }

    @Path("/tortue")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String tortue() {
        return "La tortue est un reptile de l'ordre des testudines, caractérisé par une carapace dure qui protège son corps.";
    }

    @Path("/chat")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String chat() {
        return "Le chat est un petit mammifère carnivore domestiqué, apprécié pour sa compagnie et ses qualités de chasseur.";
    } 

    @Path( "/list-animal" )
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response list() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("chat", "le chat fait miaou"));
        list.add(new Animal("chien", "wof wof"));

        
        

        String result = list.stream()
                            .map(animal -> animal.getNom())
                            .collect(Collectors.joining(","));

        return Response.ok(result).build();
    }
}  
    
