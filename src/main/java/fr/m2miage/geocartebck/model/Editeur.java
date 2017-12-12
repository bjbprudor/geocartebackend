package fr.m2miage.geocartebck.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "editeur")
public class Editeur implements Serializable
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String nom;

    @ManyToMany
    @JoinTable(
            name="editeurCommune",
            joinColumns=@JoinColumn(name="editeur", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="commune", referencedColumnName="insee"))
    private List<Commune> communes;

	@OneToMany(mappedBy = "editeur")
    private List<CartePostale> cartePostales;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(List<Commune> communes) {
        this.communes = communes;
    }

    public List<CartePostale> getCartePostales() {
        return cartePostales;
    }

    public void setCartePostales(List<CartePostale> cartePostales) {
        this.cartePostales = cartePostales;
    }

    public Editeur() {
    }

    public Editeur(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

}