
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import wad.repository.KuvaRepository;

@Controller
public class KuvaController {
    
    @Autowired
    private KuvaRepository kuvaRepo;
    
    
}
