package com.example.pokemon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="electric")
@NamedQueries({
        @NamedQuery(name = "Electric.findAdll", query = "SELECT p FROM Electric p")
        ,@NamedQuery(name = "Electric.findByIdpokemon", query="SELECT p FROM Electric p WHERE p.idPokemon = :idPokemon")
        ,@NamedQuery(name = "Electric.findByNombre", query="SELECT p FROM Electric p WHERE p.nombre = :nombre")
        ,@NamedQuery(name = "Electric.findByImg", query="SELECT p FROM Electric p WHERE p.img = :img")
        ,@NamedQuery(name = "Electric.findByClase", query="SELECT p FROM Electric p WHERE p.clase = :clase")
        ,@NamedQuery(name = "Electric.findByRegion", query="SELECT p FROM Electric p WHERE p.region = :region")
        ,@NamedQuery(name = "Electric.findByCategoria", query="SELECT p FROM Electric p WHERE p.categoria = :categoria")
        ,@NamedQuery(name = "Electric.findByAtaque", query="SELECT p FROM Electric p WHERE p.ataque = :ataque")
        ,@NamedQuery(name = "Electric.findByVida", query="SELECT p FROM Electric p WHERE p.vida = :vida")

})
public class Electric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name ="id_electric")
    private Integer id_electric;

    @Basic(optional = false)
    @Column(name ="name")
    private String name;

    @Column(name="evolution")
    private String evolution;

    @Column(name="preevolution")
    private String preevolution;

    @Column(name="hp")
    private Integer hp;

    @Column(name="attack")
    private Integer attack;

    @Column(name="defense")
    private Integer defense;

    @Column(name="sp_attack")
    private Integer sp_attack;

    @Column(name="sp_defense")
    private Integer sp_defense;

    @Column(name="speed")
    private Integer speed;

    @Column(name="total")
    private Integer total;

    public Electric(){

    }

    public Electric(Integer id_electric, String name) {
        this.id_electric = id_electric;
        this.name = name;
    }

    public Electric(String name, String evolution, String preevolution, Integer hp, Integer attack, Integer defense, Integer sp_attack, Integer sp_defense, Integer speed, Integer total) {
        super();
        this.name = name;
        this.evolution = evolution;
        this.preevolution = preevolution;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.sp_attack = sp_attack;
        this.sp_defense = sp_defense;
        this.speed = speed;
        this.total = total;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(Integer ataque) {
        this.ataque = ataque;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(Integer vida) {
        this.vida = vida;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPokemon);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Electric other = (Electric) obj;
        return Objects.equals(idPokemon, other.idPokemon);
    }

    @Override
    public String toString() {
        return "Electric [idPokemon=" + idPokemon + "]";
    }

    public Electric buscarPorID(int i) {
        return null;
    }





}
