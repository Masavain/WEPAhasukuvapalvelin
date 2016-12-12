package wad.controller;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.FileObject;
import wad.domain.Kayttaja;
import wad.repository.FileObjectRepository;
import wad.repository.KayttajaRepository;
import java.util.*;
import org.springframework.security.core.Authentication;
import wad.domain.Tagays;
import wad.domain.Tykkays;

@Controller
@RequestMapping("/*")
public class DefaultController {

    @Autowired
    private KayttajaRepository kayttajaRepo;
    @Autowired
    private FileObjectRepository foRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Kayttaja k = new Kayttaja();
        k.setNimimerkki("masa");
        k.setSalasana(passwordEncoder.encode("huhhuh"));
        k.setEmail("asdasd@asdasd.com");
        kayttajaRepo.save(k);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(Model model) {
        return "redirect:/kuvat";
    }
    


    

}
