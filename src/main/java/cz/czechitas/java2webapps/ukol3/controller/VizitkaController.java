package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.divideUnsigned;
import static java.lang.Integer.parseInt;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
private final List<Vizitka> vizitky;

  public VizitkaController(){
    vizitky= new ArrayList<>();
    vizitky.add(new Vizitka("John Lawrence","Eagle Fang Karate","Jurkovičova 2","63800 Brno","strikefirst@eaglefang.com",null,null));
    vizitky.add(new Vizitka("Daniel LaRusso","Miagi-do Karate","Zeleného 10","60200 Brno","DannyLaRusso@miagi-do.com","+420 605528124","www.miagi-do.com"));
            vizitky.add (new Vizitka("John Kreese","Cobra Kai Karate","Stará Osada 3984/15","61500 Brno","nomercy@cobrakai.com","+420 777658243",null));
            vizitky.add(new Vizitka("Miguel Diaz","Eagle Fang Karate","Jurkovičova 5","63800 Brno","MiguelDiaz@eaglefang.com","+420 608748264","www.eaglefang.com"));


  }



  @GetMapping("/")
public ModelAndView vizitka(){
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("seznamvizitek",vizitky);
    return modelAndView;

  }
  @GetMapping("/nova")
  public ModelAndView novaViz(){
    ModelAndView novaViz = new ModelAndView("nova");
    return novaViz;
  }

  @PostMapping(value="/nova", params={"jmeno","firma","ulice","obecPsc","email","telefon","web"})
  public String novaVizitka(Vizitka vizitka){
    vizitky.add(vizitka);
     return "redirect:/";

  }

  @GetMapping("/detail")
  public ModelAndView detail(int id){
    ModelAndView detailVizitky = new ModelAndView("detail");
    detailVizitky.addObject("detaily",vizitky.get(id));
    detailVizitky.addObject("id",id);
    return detailVizitky;
     }
     @PostMapping(value="/detail", params="id")
  public String delete(int id){
  vizitky.remove(id);
  return "redirect:/";

    }
  }

