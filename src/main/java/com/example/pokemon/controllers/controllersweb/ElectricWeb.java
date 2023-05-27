package com.example.pokemon.controllers.controllersweb;

import com.example.pokemon.model.Electric;
import com.example.pokemon.services.ElectricServices;
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
@RequestMapping("/electrics")
public class ElectricWeb {
    @Autowired
    private ElectricServices servicio;

    @RequestMapping("/tolistElectric")
    public String tolistElectric (Model model) {

        List<Electric> listElectrics = servicio.buscarTodo();
        System.out.println("List Electrics: " + listElectrics);
        model.addAttribute("listElectrics", listElectrics);
        return "/modelElectrics/tolistElectric";
    }

    @RequestMapping("/nuevo")
    public String newElectric(Model model) {
        Electric electric = new Electric ();
        model.addAttribute("electric",electric);
        return "/modelElectrics/newElectric";
    }


    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String createElectric(@ModelAttribute("electric") Electric electric) {
        servicio.crear(electric);
        return "redirect:/electrics/tolistElectric";
    }


    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editAquatic(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/modelElectrics/editElectric");
        Electric electric = servicio.buscarPorId(id);
        mav.addObject("electric",electric);
        return mav;
    }


    @RequestMapping(value = "/eliminar/{id}")
    public String deleteElectric(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/electrics/tolistElectric";
    }

}
