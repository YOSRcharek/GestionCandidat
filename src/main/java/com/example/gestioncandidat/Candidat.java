package com.example.gestioncandidat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;


@Entity
public class Candidat implements Serializable{
    private static final long serializableVerionUID=6;
    @Id
    @GeneratedValue
    private int id;
    private String prenom,nom,email;

    public Candidat() {
        super();
    }

    public Candidat( String prenom, String nom, String email) {

        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
