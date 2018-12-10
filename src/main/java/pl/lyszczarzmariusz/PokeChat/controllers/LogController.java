package pl.lyszczarzmariusz.PokeChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import pl.lyszczarzmariusz.PokeChat.models.CityModel;
import pl.lyszczarzmariusz.PokeChat.models.UserModel;
import pl.lyszczarzmariusz.PokeChat.models.Utils;
import pl.lyszczarzmariusz.PokeChat.models.forms.RegisterForm;
import pl.lyszczarzmariusz.PokeChat.models.repositories.CityRepository;
import pl.lyszczarzmariusz.PokeChat.models.repositories.UserRepository;
import pl.lyszczarzmariusz.PokeChat.models.services.UserService;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LogController {

    final
    UserRepository userRepository;

    final
    UserService userService;

    final
    CityRepository cityRepository;

    @Autowired
    public LogController(UserRepository userRepository, UserService userService, CityRepository cityRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/login")
    public String loginGet(Model model){

        model.addAttribute("userModel", new UserModel());
        return "login";
    }

    @GetMapping("/")
    public String mainGet(){
        return "redirect:/cities";
    }

    @PostMapping("/login")
    public String loginPost(UserModel userModel){

    Optional<UserModel> user = userRepository.findByNameAndPassword(userModel.getName(),Utils.hash256SHA(userModel.getPassword()));
    if(user.isPresent()){
        userService.setUser(user);
        return "redirect:/city/" + userService.getUser().get().escapeDiacritics().toLowerCase();
    }
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
                               BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if(userRepository.existsByName(registerForm.getName())){
            model.addAttribute("NameBusy", "Nazwa jest zajęta");
            return "register";
        }
        if(!registerForm.getPassword().equals(registerForm.getRepeatPassword())){
            model.addAttribute("BadPassword", "Hasła nie są takie same");
            return "register";
        }

        UserModel userModel = new UserModel();
        userModel.setName(registerForm.getName());
        userModel.setPassword(Utils.hash256SHA(registerForm.getPassword()));
        userModel.setTeam(registerForm.getTeam());
        userModel.setYearOfBirth(registerForm.getYearOfBirth());
        userModel.setCity(registerForm.getCity());
        userModel.setLvl(registerForm.getLvl());
        userRepository.save(userModel);

        if (!cityRepository.existsByCity(registerForm.getCity())){
            CityModel cityModel = new CityModel();
            cityModel.setCity(registerForm.getCity());
            cityModel.setCityEdLc(registerForm.escapeDiacritics().toLowerCase());
            cityRepository.save(cityModel);
        }
        userService.setUser(userRepository.findByNameAndPassword(registerForm.getName(),Utils.hash256SHA(registerForm.getPassword())));
        return "redirect:/about";
    }

    @GetMapping("/logout")
    public String logoutGet(){
        userService.setUser(null);
        return "redirect:/cities";
    }
}
