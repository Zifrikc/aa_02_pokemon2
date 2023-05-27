package com.example.pokemon.services;


import com.example.pokemon.model.Grass;

import com.example.pokemon.repository.GrassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GrassServices {
    @Autowired
    private GrassRepository repositorio;

    public GrassServices() {
    }

    public List<Grass> buscarTodo() {
        return (List<Grass>) repositorio.findAll();
    }

    public Grass actualizar(Grass grassActualizar) {

        Grass grassActual = repositorio.findById(grassActualizar.getIdGrass()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        grassActual.setName(grassActualizar.getName());
        grassActual.setEvolution(grassActualizar.getEvolution());
        grassActual.setPreevolution(grassActualizar.getPreevolution());
        grassActual.setHp(grassActualizar.getHp());
        grassActual.setAttack(grassActualizar.getAttack());
        grassActual.setDefense(grassActualizar.getDefense());
        grassActual.setSpattack(grassActualizar.getSpattack());
        grassActual.setSpdefense(grassActualizar.getSpdefense());
        grassActual.setSpeed(grassActualizar.getSpeed());
        grassActual.setTotal(grassActualizar.getTotal());
        Grass grassActualizado = repositorio.save(grassActual); // registra en base de datos
        return grassActualizado;
    }

    public Grass crear(Grass grass) {
        return repositorio.save(grass);
    }

    public Grass buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
