package pl.lyszczarzmariusz.PokeChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lyszczarzmariusz.PokeChat.models.UserModel;
import pl.lyszczarzmariusz.PokeChat.models.forms.RegisterForm;
import pl.lyszczarzmariusz.PokeChat.models.repositories.UserRepository;
import pl.lyszczarzmariusz.PokeChat.models.services.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

@Controller
public class LogController {

    final
    UserRepository userRepository;

    final
    UserService userService;

    @Autowired
    public LogController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginGet(Model model){

        model.addAttribute("userModel", new UserModel());
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(UserModel userModel){
    Optional<UserModel> user = userRepository.findByNameAndPassword(userModel.getName(),userModel.getPassword());
    if(user.isPresent()){
        userService.setUser(user);
        return "redirect:/";
    }
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("registerForm")RegisterForm registerForm){
        if(userRepository.existsByName(registerForm.getName())){
            return "register";
        }
        if(!registerForm.getPassword().equals(registerForm.getRepeatPassword())){
            //nie są takie same
            return "register";
        }
        UserModel userModel = new UserModel();
        userModel.setName(registerForm.getName());
        userModel.setPassword(registerForm.getPassword());
        userModel.setTeam(registerForm.getTeam());
        userModel.setAge(registerForm.getAge());
        userModel.setCity(registerForm.getCity());
        userModel.setLvl(registerForm.getLvl());
        userRepository.save(userModel);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoutGet(){
        userService.setUser(null);
        return "redirect:/";
    }
}
