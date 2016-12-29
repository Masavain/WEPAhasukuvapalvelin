package wad.controller;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import wad.domain.FileObject;
import wad.domain.Kommentti;
import wad.domain.Tagays;
import wad.domain.Tykkays;
import wad.repository.FileObjectRepository;
import wad.repository.KayttajaRepository;
import wad.repository.KommenttiRepository;
import wad.repository.TagaysRepository;
import wad.repository.TykkaysRepository;

@Controller
public class KuvaController {

    @Autowired
    private FileObjectRepository foRepo;
    @Autowired
    private KayttajaRepository kayttajaRepo;
    @Autowired
    private KommenttiRepository kommenttiRepo;
    @Autowired
    private TykkaysRepository tykkaysRepo;
    @Autowired
    private TagaysRepository tagRepo;

    @RequestMapping(value = "/kuvat", method = RequestMethod.GET)
    public String getKuvat() {
        return "redirect:/kuvat/1";
    }

    @RequestMapping(value = "/kuvat", method = RequestMethod.POST)
    public String postKuva(Authentication auth, @RequestParam("file") MultipartFile file) throws IOException {
        FileObject kuva = new FileObject();
        kuva.setNimi(file.getOriginalFilename());
        kuva.setContent(file.getBytes());
        kuva.setSize(file.getSize());
        kuva.setTagaykset(new ArrayList<Tagays>());
        kuva.setTykkaukset(new ArrayList<Tykkays>());
        kuva.setLisaaja(kayttajaRepo.findByNimimerkki(auth.getName()));
        kuva.setTykkayksienSumma(0);

        foRepo.save(kuva);
        return "redirect:/kuvat";
    }

    @RequestMapping(value = "/kuvat/{id}", method = RequestMethod.GET)
    public String getGif(Model model, @PathVariable Long id, Authentication auth) throws Exception {
        model.addAttribute("count", foRepo.count());
        model.addAttribute("kayttaja", kayttajaRepo.findByNimimerkki(auth.getName()));
        model.addAttribute("kuvat", foRepo.findAll());

        if (id > 1) {
            model.addAttribute("previous", id - 1);
        }
        if (id < foRepo.count()) {
            model.addAttribute("next", id + 1);

        }

        model.addAttribute("current", id);
        model.addAttribute("currentPic", foRepo.findOne(id));
        model.addAttribute("kommentit", kommenttiRepo.findByFileobject(foRepo.findOne(id)));
        List<Tykkays> tykkaykset = tykkaysRepo.findByFileobject(foRepo.findOne(id));

        int tykkayksienSumma = 0;
        for (Tykkays t : tykkaykset) {
            tykkayksienSumma = tykkayksienSumma + t.getArvo();
        }
        model.addAttribute("tykkaykset", tykkayksienSumma + "");

        return "index";
    }

    @RequestMapping(value = "/kuvat/{id}/content", method = RequestMethod.GET, produces = "image/jpeg")
    @ResponseBody
    public byte[] getContent(@PathVariable Long id) throws Exception {
        return foRepo.findOne(id).getContent();
    }

    @RequestMapping(value = "/kuvat/{id}/kommentti", method = RequestMethod.POST)
    public String kommentoi(Authentication auth, @PathVariable Long id, @RequestParam String content) {
        Kommentti kommentti = new Kommentti();
        kommentti.setFileobject(foRepo.findOne(id));
        kommentti.setKayttaja(kayttajaRepo.findByNimimerkki(auth.getName()));
        kommentti.setSisalto(content);
        kommenttiRepo.save(kommentti);
        return "redirect:/kuvat/" + id;
    }

    @RequestMapping(value = "/kuvat/{id}/upvote", method = RequestMethod.POST)
    public String tykkaa(Authentication auth, @PathVariable Long id) {
        FileObject kuva = foRepo.findOne(id);
        if (!tykkaysRepo.findByKayttajaAndFileobject(kayttajaRepo.findByNimimerkki(auth.getName()), kuva).isEmpty()) {
            return "redirect:/kuvat/" + id;
        }

        Tykkays t = new Tykkays();
        t.setKayttaja(kayttajaRepo.findByNimimerkki(auth.getName()));
        t.setFileobject(kuva);
        t.setArvo(1);
        tykkaysRepo.save(t);
        return "redirect:/kuvat/" + id;
    }

    @RequestMapping(value = "/kuvat/{id}/downvote", method = RequestMethod.POST)
    public String epatykkaa(Authentication auth, @PathVariable Long id) {
        FileObject kuva = foRepo.findOne(id);
        if (!tykkaysRepo.findByKayttajaAndFileobject(kayttajaRepo.findByNimimerkki(auth.getName()), kuva).isEmpty()) {
            return "redirect:/kuvat/" + id;
        }
        Tykkays t = new Tykkays();
        t.setKayttaja(kayttajaRepo.findByNimimerkki(auth.getName()));
        t.setFileobject(kuva);
        t.setArvo(-1);
        tykkaysRepo.save(t);
        return "redirect:/kuvat/" + id;
    }

}
