package com.example.pokemon.services;

import com.example.pokemon.model.Grass;
import com.example.pokemon.model.Water;
import com.example.pokemon.repository.GrassRepository;
import com.example.pokemon.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class WaterServioces {
    @Autowired
    private WaterRepository repositorio;

    public WaterServioces() {
    }

    public List<Water> buscarTodo() {
        return (List<Water>) repositorio.findAll();
    }

    public Water actualizar(Water waterActualizar) {

        Water waterActual = repositorio.findById(waterActualizar.getIdWater()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        waterActual.setName(waterActualizar.getName());
        waterActual.setEvolution(waterActualizar.getEvolution());
        waterActual.setPreevolution(waterActualizar.getPreevolution());
        waterActual.setHp(waterActualizar.getHp());
        waterActual.setAttack(waterActualizar.getAttack());
        waterActual.setDefense(waterActualizar.getDefense());
        waterActual.setSpattack(waterActualizar.getSpattack());
        waterActual.setSpdefense(waterActualizar.getSpdefense());
        waterActual.setSpeed(waterActualizar.getSpeed());
        waterActual.setTotal(waterActualizar.getTotal());
        Water waterActualizado = repositorio.save(waterActual); // registra en base de datos
        return waterActualizado;
    }

    public Water crear(Water water) {
        return repositorio.save(water);
    }

    public Water buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
