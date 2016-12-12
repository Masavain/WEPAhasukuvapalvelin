package wad.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import wad.domain.Tagays;
import wad.domain.Tykkays;
import wad.repository.FileObjectRepository;
import wad.repository.KayttajaRepository;

@Controller
public class KuvaController {

    @Autowired
    private FileObjectRepository foRepo;
    @Autowired
    private KayttajaRepository kayttajaRepo;

    @RequestMapping(value = "/kuvat", method = RequestMethod.GET)
    public String getKuvat() {
        return "redirect:/kuvat/1";
    }

    @RequestMapping(value = "/kuvat", method = RequestMethod.POST)
    public String postKuva(@RequestParam("file") MultipartFile file) throws IOException {
        FileObject kuva = new FileObject();
        kuva.setNimi(file.getOriginalFilename());
        kuva.setContent(file.getBytes());
        kuva.setSize(file.getSize());
        kuva.setTagaykset(new ArrayList<Tagays>());
        kuva.setTykkaukset(new ArrayList<Tykkays>());
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
        return "index";
    }
    
    @RequestMapping(value = "/kuvat/{id}/content", method = RequestMethod.GET, produces = "image/jpeg")
    @ResponseBody
    public byte[] getContent(@PathVariable Long id) throws Exception{
        return foRepo.findOne(id).getContent();
    }

}
