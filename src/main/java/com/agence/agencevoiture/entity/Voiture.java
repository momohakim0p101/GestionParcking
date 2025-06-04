package com.agence.agencevoiture.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @Column(name = "immatriculation", length = 20)
    private String immatriculation;

    @Column(name = "nombre_places")
    private int nombrePlaces;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

    @Column(name = "date_mise_en_circulation")
    @Temporal(TemporalType.DATE)
    private Date dateMiseEnCirculation;

    @Column(name = "kilometrage")
    private double kilometrage;

    @Column(name = "type_carburant")
    private String typeCarburant; // Essence, Diesel, Électrique...

    @Column(name = "categorie")
    private String categorie; // SUV, Berline, etc.

    @Column(name = "prix_location_jour")
    private double prixLocationJour;

    @Column(name = "disponible")
    private boolean disponible = true;

    @OneToMany(mappedBy = "voiture")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "voiture")
    private List<Avis> avis;




    public Voiture(String immatriculation, int nombrePlaces, String marque, String modele, Date dateMiseEnCirculation, double kilometrage, String typeCarburant, String categorie, double prixLocationJour, boolean disponible, List<Reservation> reservations, List<Avis> avis) {
        this.immatriculation = immatriculation;
        this.nombrePlaces = nombrePlaces;
        this.marque = marque;
        this.modele = modele;
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.kilometrage = kilometrage;
        this.typeCarburant = typeCarburant;
        this.categorie = categorie;
        this.prixLocationJour = prixLocationJour;
        this.disponible = disponible;
        this.reservations = reservations;
        this.avis = avis;
    }

    public Voiture() {

    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Date getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrixLocationJour() {
        return prixLocationJour;
    }

    public void setPrixLocationJour(double prixLocationJour) {
        this.prixLocationJour = prixLocationJour;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "immatriculation='" + immatriculation + '\'' +
                ", nombrePlaces=" + nombrePlaces +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", dateMiseEnCirculation=" + dateMiseEnCirculation +
                ", kilometrage=" + kilometrage +
                ", typeCarburant='" + typeCarburant + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prixLocationJour=" + prixLocationJour +
                ", disponible=" + disponible +
                ", reservations=" + reservations +
                ", avis=" + avis +
                '}';
    }
}
