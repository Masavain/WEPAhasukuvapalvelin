
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wad.repository.KayttajaRepository;

@Controller
public class KayttajaController {
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    
    
    
}
