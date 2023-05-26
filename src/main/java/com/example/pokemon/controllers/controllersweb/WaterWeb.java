package com.example.pokemon.controllers.controllersweb;

import com.example.pokemon.model.Water;
import com.example.pokemon.services.WaterServices;
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
@RequestMapping("/waters")
public class WaterWeb {
    @Autowired
    private WaterServices servicio;

    @RequestMapping("/tolistWater")
    public String tolistWater (Model model) {

        List<Water> listWaters = servicio.buscarTodo();
        System.out.println("List Waters: " + listWaters);
        model.addAttribute("listWaters", listWaters);
        return "/modelWaters/tolistWaters";
    }

    @RequestMapping("/nuevo")
    public String newWater(Model model) {
        Water water = new Water ();
        model.addAttribute("water",water);
        return "/modelWaters/newWater";
    }

    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String createWater(@ModelAttribute("water") Water water) {
        servicio.crear(water);
        return "redirect:/waters/tolistWater";
    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editWater(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/modelWaters/editWater");
        Water water = servicio.buscarPorId(id);
        mav.addObject("water",water);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String deleteWater(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/waters/tolistWater";
    }
}
