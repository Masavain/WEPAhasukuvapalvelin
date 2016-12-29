
package wad.service;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import wad.domain.Kayttaja;
import wad.repository.KayttajaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KayttajaTest {
    
    
    @Autowired
    private KayttajaRepository kayttajaRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Test
    public void testTallentuukoKayttaja() {
        
        Kayttaja koeKayttaja = new Kayttaja();
        koeKayttaja.setNimimerkki("koe");
        koeKayttaja.setSalasana(passwordEncoder.encode("salasana"));
        koeKayttaja.setEmail("koe@asdasd.com");
        koeKayttaja.setAuthorities(Arrays.asList("ADMIN"));
        kayttajaRepo.save(koeKayttaja);
        
        
        Kayttaja loydetty = kayttajaRepo.findByNimimerkki("koe");
        assertNotNull(loydetty);
        assertEquals("koe@asdasd.com",loydetty.getEmail());
        assertTrue(loydetty.getAuthorities().contains("ADMIN"));
    }
    
   
}
