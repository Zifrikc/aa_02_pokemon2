package com.example.pokemon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="fire")
@NamedQueries({
        @NamedQuery(name = "Fire.findAdll", query = "SELECT p FROM Fire p")
        ,@NamedQuery(name = "Fire.findByIdfire", query="SELECT p FROM Fire p WHERE p.idFire = :idFire")
        ,@NamedQuery(name = "Fire.findByName", query="SELECT p FROM Fire p WHERE p.name = :name")
        ,@NamedQuery(name = "Fire.findByEvolution", query="SELECT p FROM Fire p WHERE p.evolution = :evolution")
        ,@NamedQuery(name = "Fire.findByPreevolution", query="SELECT p FROM Fire p WHERE p.preevolution = :preevolution")
        ,@NamedQuery(name = "Fire.findByHp", query="SELECT p FROM Fire p WHERE p.hp = :hp")
        ,@NamedQuery(name = "Fire.findByAttack", query="SELECT p FROM Fire p WHERE p.attack = :attack")
        ,@NamedQuery(name = "Fire.findByDefense", query="SELECT p FROM Fire p WHERE p.defense = :defense")
        ,@NamedQuery(name = "Fire.findBySpattack", query="SELECT p FROM Fire p WHERE p.spattack = :spattack")
        ,@NamedQuery(name = "Fire.findBySpdefense", query="SELECT p FROM Fire p WHERE p.spdefense = :spdefense")
        ,@NamedQuery(name = "Fire.findBySpeed", query="SELECT p FROM Fire p WHERE p.speed = :speed")
        ,@NamedQuery(name = "Fire.findByTotal", query="SELECT p FROM Fire p WHERE p.total = :total")


})
public class Fire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false) //representa que este campo es obligatorio en base de datos
    @Column(name = "idFire")
    private Integer idFire;

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

    public Fire() {
    }

    public Fire(Integer idFire, String nombre) {
        this.idFire = idFire;
        this.name = nombre;
    }

    public Fire(String name, String evolution, String preevolution, Integer hp, Integer attack, Integer defense,
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

    public Integer getIdFire() {
        return idFire;
    }

    public void setIdFire(Integer idFire) {
        this.idFire = idFire;
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
        return Objects.hash(idFire);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fire other = (Fire) obj;
        return Objects.equals(idFire, other.idFire);
    }

    @Override
    public String toString() {
        return "Fire [idFire=" + idFire + "]";
    }

    public Grass buscarPorID(int i) {
        return null;
    }
}