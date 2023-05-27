package com.example.pokemon.services;

import com.example.pokemon.model.Fire;
import com.example.pokemon.model.Water;
import com.example.pokemon.repository.FireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class FireServices {
    @Autowired
    private FireRepository repositorio;

    public FireServices() {
    }

    public List<Fire> buscarTodo() {
        return (List<Fire>) repositorio.findAll();
    }

    public Fire actualizar(Fire fireActualizar) {

        Fire fireActual = repositorio.findById(fireActualizar.getIdFire()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        fireActual.setName(fireActualizar.getName());
        fireActual.setEvolution(fireActualizar.getEvolution());
        fireActual.setPreevolution(fireActualizar.getPreevolution());
        fireActual.setHp(fireActualizar.getHp());
        fireActual.setAttack(fireActualizar.getAttack());
        fireActual.setDefense(fireActualizar.getDefense());
        fireActual.setSpattack(fireActualizar.getSpattack());
        fireActual.setSpdefense(fireActualizar.getSpdefense());
        fireActual.setSpeed(fireActualizar.getSpeed());
        fireActual.setTotal(fireActualizar.getTotal());
        Fire fireActualizado = repositorio.save(fireActual); // registra en base de datos
        return fireActualizado;
    }

    public Fire crear(Fire fire) {
        return repositorio.save(fire);
    }

    public Fire buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
