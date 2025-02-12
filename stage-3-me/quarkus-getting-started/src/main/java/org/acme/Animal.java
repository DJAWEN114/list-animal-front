package org.acme;

public class Animal {
    String nom; 

    String description; 

    Animal(){}

    Animal(String nom, String description){
        this.nom = nom; 
        this.description = description;
    }

    public String getNom(){
        return this.nom;
    }

    public String getDescription(){
        return this.description;
    }
}
