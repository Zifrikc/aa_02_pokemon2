package com.example.pokemon.services;

import com.example.pokemon.model.Water;
import com.example.pokemon.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WaterServices {
    @Autowired
    private WaterRepository repositorio;

    public WaterServices() {
    }

    public List<Water> buscarTodo() {
        return (List<Water>) repositorio.findAll();
    }

    public Water actualizar(Water waterActualizar) {

        Water waterActual = repositorio.findById(waterActualizar.getIdPokemon()).get();

        //peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
        waterActual.setNombre(waterActualizar.getNombre());
        waterActual.setImg(waterActualizar.getImg());
        waterActual.setClase(waterActualizar.getClase());
        waterActual.setRegion(waterActualizar.getRegion());
        waterActual.setCategoria(waterActualizar.getCategoria());
        waterActual.setAtaque(waterActualizar.getAtaque());
        waterActual.setVida(waterActualizar.getVida());
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
