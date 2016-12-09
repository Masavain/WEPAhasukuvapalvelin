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
        return "redirect:/etusivu";
    }

    @RequestMapping(value = "/etusivu", method = RequestMethod.GET)
    public String etusivu(Model model) {
        model.addAttribute("kuvat", foRepo.findAll());
        return "index";
    }

    @RequestMapping(value = "/etusivu", method = RequestMethod.POST)
    public String postKuva(@RequestParam("metadata") String metadata,
            @RequestParam("file") MultipartFile file) throws IOException {
        FileObject kuva = new FileObject();
        kuva.setNimi(metadata);
        kuva.setContent(file.getBytes());
        kuva.setSize(file.getSize());
        kuva.setTagaykset(new ArrayList<Tagays>());
        kuva.setTykkaukset(new ArrayList<Tykkays>());
        kuva.setTykkayksienSumma(0);
        
        return "redirect:/etusivu";
    }

}
