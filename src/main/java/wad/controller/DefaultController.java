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
        Kayttaja masa = new Kayttaja();
        masa.setNimimerkki("masa");
        masa.setSalasana(passwordEncoder.encode("huhhuh"));
        masa.setEmail("asdasd@asdasd.com");
        masa.setAuthorities(Arrays.asList("ADMIN"));
        kayttajaRepo.save(masa);
        
        Kayttaja henu = new Kayttaja();
        henu.setNimimerkki("henu");
        henu.setSalasana(passwordEncoder.encode("hehheh"));
        henu.setEmail("henu@asdasd.com");
        henu.setAuthorities(Arrays.asList("USER"));
        kayttajaRepo.save(henu);
        
        Kayttaja repe = new Kayttaja();
        repe.setNimimerkki("repe");
        repe.setSalasana(passwordEncoder.encode("hahhah"));
        repe.setEmail("repe@asdasd.com");
        repe.setAuthorities(Arrays.asList("USER","ADMIN"));
        kayttajaRepo.save(repe);
        
        
    }

    @RequestMapping(method = RequestMethod.GET)
    public String redirect(Model model) {
        return "redirect:/kuvat";
    }
    


    

}
