package com.example.pokemon.controllers.controllersweb;

import com.example.pokemon.model.Grass;
import com.example.pokemon.services.GrassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/grasses")
public class GrassWeb {
    @Autowired
    private GrassServices servicio;

    @RequestMapping("/tolistGrass")
    public String tolistGrass (Model model) {

        List<Grass> listGrasses = servicio.buscarTodo();
        System.out.println("List Grasses: " + listGrasses);
        model.addAttribute("listGrasses", listGrasses);
        return "/modelGrasses/tolistGrass";
    }

    @RequestMapping("/nuevo")
    public String newGrass(Model model) {
        Grass grass = new Grass ();
        model.addAttribute("grass",grass);
        return "/modelGrass/newGrass";
    }

    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String createGrass(@ModelAttribute("grass") Grass grass) {
        servicio.crear(grass);
        return "redirect:/grasses/tolistGrass";
    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editGrass(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/modelGrasses/editGrass");
        Grass grass = servicio.buscarPorId(id);
        mav.addObject("grass",grass);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String deleteGrass(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/grasses/tolistGrass";
    }
}
