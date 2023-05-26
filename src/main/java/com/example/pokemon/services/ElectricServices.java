package com.example.pokemon.services;


import com.example.pokemon.model.Electric;
import com.example.pokemon.repository.ElectricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ElectricServices {
    @Autowired
    private ElectricRepository  repositorio;

    public ElectricServices() {
    }

    public List<Electric> buscarTodo() {
        return (List<Electric>) repositorio.findAll();
    }

    public Electric actualizar(Electric electricActualizar) {

        Electric electricActual = repositorio.findById(electricActualizar.getIdPokemon()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        electricActual.setNombre(electricActualizar.getNombre());
        electricActual.setImg(electricActualizar.getImg());
        electricActual.setClase(electricActualizar.getClase());
        electricActual.setRegion(electricActualizar.getRegion());
        electricActual.setCategoria(electricActualizar.getCategoria());
        electricActual.setAtaque(electricActualizar.getAtaque());
        electricActual.setVida(electricActualizar.getVida());
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

