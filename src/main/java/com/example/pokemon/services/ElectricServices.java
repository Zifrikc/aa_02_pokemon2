package com.example.pokemon.services;

import com.example.pokemon.model.Electric;
import com.example.pokemon.model.Grass;
import com.example.pokemon.repository.ElectricRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ElectricServices {
    @Autowired
    private ElectricRepository repositorio;

    public ElectricServices() {
    }

    public List<Electric> buscarTodo() {
        return (List<Electric>) repositorio.findAll();
    }

    public Electric actualizar(Electric electricActualizar) {

        Electric electricActual = repositorio.findById(electricActualizar.getIdElectric()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        electricActual.setName(electricActualizar.getName());
        electricActual.setEvolution(electricActualizar.getEvolution());
        electricActual.setPreevolution(electricActualizar.getPreevolution());
        electricActual.setHp(electricActualizar.getHp());
        electricActual.setAttack(electricActualizar.getAttack());
        electricActual.setDefense(electricActualizar.getDefense());
        electricActual.setSpattack(electricActualizar.getSpattack());
        electricActual.setSpdefense(electricActualizar.getSpdefense());
        electricActual.setSpeed(electricActualizar.getSpeed());
        electricActual.setTotal(electricActualizar.getTotal());
        Electric electricActualizado = repositorio.save(electricActual); // registra en base de datos
        return electricActualizado;
    }

    public Electric crear(Electric electric) {
        return repositorio.save(electric);
    }

    public Electric buscarPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void borrarPorId(Integer id) {
        repositorio.deleteById(id);
    }
}
