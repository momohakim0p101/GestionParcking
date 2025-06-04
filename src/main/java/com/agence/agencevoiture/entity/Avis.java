package com.agence.agencevoiture.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "avis")
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avis")
    private Long idAvis;

    @Column(name = "note")
    private int note; // 1 à 5

    @Column(name = "commentaire", length = 500)
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "cin_client", referencedColumnName = "cin")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "immatriculation_voiture", referencedColumnName = "immatriculation")
    private Voiture voiture;

    public Avis(Long idAvis, int note, String commentaire, Client client, Voiture voiture) {
        this.idAvis = idAvis;
        this.note = note;
        this.commentaire = commentaire;
        this.client = client;
        this.voiture = voiture;
    }

    public Avis() {

    }



    public Long getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(Long idAvis) {
        this.idAvis = idAvis;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "idAvis=" + idAvis +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", client=" + client +
                ", voiture=" + voiture +
                '}';
    }
}
