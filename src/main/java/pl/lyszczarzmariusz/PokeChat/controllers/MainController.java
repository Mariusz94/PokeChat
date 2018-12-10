package pl.lyszczarzmariusz.PokeChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lyszczarzmariusz.PokeChat.models.CityModel;
import pl.lyszczarzmariusz.PokeChat.models.DistrictModel;
import pl.lyszczarzmariusz.PokeChat.models.repositories.CityRepository;
import pl.lyszczarzmariusz.PokeChat.models.repositories.DistrictRepository;
import pl.lyszczarzmariusz.PokeChat.models.repositories.RaidRepository;
import pl.lyszczarzmariusz.PokeChat.models.repositories.UserRepository;
import pl.lyszczarzmariusz.PokeChat.models.services.UserService;

import java.util.Random;

@Controller
public class MainController {

    final
    UserRepository userRepository;

    final
    UserService userService;

    final
    CityRepository cityRepository;

    final
    DistrictRepository districtRepository;

    final
    RaidRepository raidRepository;

    @Autowired
    public MainController(UserRepository userRepository, UserService userService, CityRepository cityRepository, DistrictRepository districtRepository, RaidRepository raidRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.cityRepository = cityRepository;
        this.districtRepository = districtRepository;
        this.raidRepository = raidRepository;
    }

    @GetMapping("/about")
    public String indexGet(Model model) {
        model.addAttribute("user", userService.getUser());
        return "about";
    }

    @GetMapping("/cities")
    public String citiesGet(Model model) {
        model.addAttribute("user", userService.getUser());
        model.addAttribute("cities", cityRepository.findAll());
        model.addAttribute("addCity",new CityModel());
        return "cities";
    }

    @PostMapping("/cities")
    public String citiesPost(@ModelAttribute("addCity")CityModel cityModel,
                             Model model){
        if (userService.getUser()== null){
            model.addAttribute("info", "Musisz być zalogowany aby móc dodawać miasta");
            return "cities";
        }
        cityModel.setCityEdLc(cityModel.escapeDiacritics().toLowerCase());
        cityRepository.save(cityModel);
        return "redirect:/cities";
    }

    @GetMapping("/city/{city}")
    public String cityGet(@PathVariable("city") String city,
                          Model model) {
        if (!cityRepository.existsByCityEdLc(city)){
            return "redirect:/cities";
        }
        model.addAttribute("user", userService.getUser());
        model.addAttribute("districts", districtRepository.findAllByCity(city));
        model.addAttribute("city", city);
        model.addAttribute("addDistrict", new DistrictModel());
        return "city";
    }

    @PostMapping("/city/{city}")
    public String cityPost(@PathVariable("city") String city,
                          @ModelAttribute("addDistrict") DistrictModel districtModel,
                          Model model) {
        if (userService.getUser()== null){
            model.addAttribute("info", "Musisz być zalogowany aby móc dodawać dzielnice");
            return "city";
        }
        districtModel.setDistrictEdLc(districtModel.escapeDiacritics().toLowerCase());
        districtModel.setCity(city);
        districtRepository.save(districtModel);

        return "redirect:/city/" + city;
    }

    @GetMapping("/district/{district}")
    public String districtGet(@PathVariable("district") String district,
                              Model model) {
        model.addAttribute("user", userService.getUser());
        model.addAttribute("raids", raidRepository.findAllByDistrict(district));
        return "district";
    }

    @GetMapping("/raid/{id}")
    public String raidGet(@PathVariable("id") int id,
                          Model model) {
        model.addAttribute("user", userService.getUser());
        model.addAttribute("raid", raidRepository.findOne(id));
        return "raid";
    }
}
