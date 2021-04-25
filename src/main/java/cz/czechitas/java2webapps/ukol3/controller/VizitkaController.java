package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
  private final List<Vizitka> vizitky;

  public VizitkaController(){
    vizitky=List.of(
            new Vizitka("John Lawrence","Eagle Fang Karate","Jurkovičova 2","63800 Brno","strikefirst@eaglefang.com",null,null),
            new Vizitka("Daniel LaRusso","Miagi-do Karate","Zeleného 10","60200 Brno","DannyLaRusso@miagi-do.com","+420 605528124","www.miagi-do.com"),
            new Vizitka("John Kreese","Cobra Kai Karate","Stará Osada 3984/15","61500 Brno","nomercy@cobrakai.com","+420 777658243",null),
            new Vizitka("Miguel Diaz","Eagle Fang Karate","Jurkovičova 5","63800 Brno","MiguelDiaz@eaglefang.com","+420 608748264","www.eaglefang.com")
    );

  }



  @GetMapping("/")
public ModelAndView vizitka(){
    ModelAndView modelAndView = new ModelAndView("seznam");
    modelAndView.addObject("seznamvizitek",vizitky);
    return modelAndView;
  }

  @GetMapping("/detail")
  public ModelAndView detail(int id){
    ModelAndView modelAndView = new ModelAndView("detail");
    modelAndView.addObject("detaily",vizitky.get(id));
    return modelAndView;
  }


}
