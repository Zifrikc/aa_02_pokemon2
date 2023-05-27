package com.example.pokemon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="water")
@NamedQueries({
        @NamedQuery(name = "Water.findAdll", query = "SELECT p FROM Water p")
        ,@NamedQuery(name = "Water.findByIdwater", query="SELECT p FROM Water p WHERE p.idWater = :idWater")
        ,@NamedQuery(name = "Water.findByName", query="SELECT p FROM Water p WHERE p.name = :name")
        ,@NamedQuery(name = "Water.findByEvolution", query="SELECT p FROM Water p WHERE p.evolution = :evolution")
        ,@NamedQuery(name = "Water.findByPreevolution", query="SELECT p FROM Water p WHERE p.preevolution = :preevolution")
        ,@NamedQuery(name = "Water.findByHp", query="SELECT p FROM Water p WHERE p.hp = :hp")
        ,@NamedQuery(name = "Water.findByAttack", query="SELECT p FROM Water p WHERE p.attack = :attack")
        ,@NamedQuery(name = "Water.findByDefense", query="SELECT p FROM Water p WHERE p.defense = :defense")
        ,@NamedQuery(name = "Water.findBySpattack", query="SELECT p FROM Water p WHERE p.spattack = :spattack")
        ,@NamedQuery(name = "Water.findBySpdefense", query="SELECT p FROM Water p WHERE p.spdefense = :spdefense")
        ,@NamedQuery(name = "Water.findBySpeed", query="SELECT p FROM Water p WHERE p.speed = :speed")
        ,@NamedQuery(name = "Water.findByTotal", query="SELECT p FROM Water p WHERE p.total = :total")


})
public class Water implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) //representa que este campo es obligatorio en base de datos
    @Column(name = "idWater")
    private Integer idWater;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Column(name = "evolution")
    private String evolution;

    @Column(name = "preevolution")
    private String preevolution;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "attack")
    private Integer attack;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "spattack")
    private Integer spattack;

    @Column(name = "spdefense")
    private Integer spdefense;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "total")
    private Integer total;

    public Water() {
    }

    public Water(Integer idWater, String nombre) {
        this.idWater = idWater;
        this.name = nombre;
    }

    public Water(String name, String evolution, String preevolution, Integer hp, Integer attack, Integer defense,
                 Integer spattack, Integer spdefense, Integer speed, Integer total) {
        super();
        this.name = name;
        this.evolution = evolution;
        this.preevolution = preevolution;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spattack = spattack;
        this.spdefense = spdefense;
        this.speed = speed;
        this.total = total;
    }

    public Integer getIdWater() {
        return idWater;
    }

    public void setIdWater(Integer idWater) {
        this.idWater = idWater;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public String getPreevolution() {
        return preevolution;
    }

    public void setPreevolution(String preevolution) {
        this.preevolution = preevolution;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpattack() {
        return spattack;
    }

    public void setSpattack(Integer spattack) {
        this.spattack = spattack;
    }

    public Integer getSpdefense() {
        return spdefense;
    }

    public void setSpdefense(Integer spdefense) {
        this.spdefense = spdefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWater);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Water other = (Water) obj;
        return Objects.equals(idWater, other.idWater);
    }

    @Override
    public String toString() {
        return "Water [idWater=" + idWater + "]";
    }

    public Grass buscarPorID(int i) {
        return null;
    }
}