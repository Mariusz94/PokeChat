package pl.lyszczarzmariusz.PokeChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/")
    public String indexGet(Model model) {
        model.addAttribute("user", userService.getUser());
        return "main";
    }

    @GetMapping("/cities")
    public String cityGet(Model model) {
        model.addAttribute("cities", cityRepository.findAll());
        return "cities";
    }

    @GetMapping("/city/{city}")
    public String cityGet(@PathVariable("city") String city,
                          Model model) {
        model.addAttribute("districts", districtRepository.findAllByCity(city));
        return "city";
    }

    @GetMapping("/district/{district}")
    public String districtGet(@PathVariable("district") String district,
                              Model model) {
        model.addAttribute("raids", raidRepository.findAllByDistrict(district));
        return "district";
    }

    @GetMapping("/raid/{id}")
    public String raidGet(@PathVariable("id") int id,
                          Model model) {
        model.addAttribute("raid", raidRepository.findOne(id));
        return "raid";
    }
}
