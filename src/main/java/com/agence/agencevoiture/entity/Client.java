package com.agence.agencevoiture.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

@Table(name="clients")
public class Client {
    @Id
    @Column(name="cin", length=20)
    private String cin;

    @Column(name="prenom", nullable = false)
    private String prenom;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "sexe", length = 1)
    private String sexe;

    @Column(name = "addresse")
    private String adresse;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telephone", unique = true)
    private String telephone;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Reservation> reservation;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Avis> reviews;


    public Client() {

    }

    public Client(String cin, String prenom, String nom, String sexe, String adresse, String email, String telephone, List<Reservation> reservation, List<Avis> reviews) {
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.reservation = reservation;
        this.reviews = reviews;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public List<Avis> getReviews() {
        return reviews;
    }

    public void setReviews(List<Avis> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cin='" + cin + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", reservation=" + reservation +
                ", reviews=" + reviews +
                '}';
    }
}
