package com.agence.agencevoiture.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    @Column(name = "identifiant", unique = true, nullable = false)
    private String identifiant;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @Column(name = "role") // "CHEF", "GESTIONNAIRE"
    private String role;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "date_recrutement")
    @Temporal(TemporalType.DATE)
    private Date dateRecrutement;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    public Utilisateur(Long idUtilisateur, String identifiant, String motDePasse, String role, String prenom, String nom, Date dateRecrutement, String email, String telephone) {
        this.idUtilisateur = idUtilisateur;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.role = role;
        this.prenom = prenom;
        this.nom = nom;
        this.dateRecrutement = dateRecrutement;
        this.email = email;
        this.telephone = telephone;
    }

    public Utilisateur() {

    }




    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
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

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", identifiant='" + identifiant + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", role='" + role + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateRecrutement=" + dateRecrutement +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
