package wad.service;

import java.util.Arrays;
import java.util.List;
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
import wad.domain.FileObject;
import wad.domain.Kayttaja;
import wad.domain.Kommentti;
import wad.repository.FileObjectRepository;
import wad.repository.KayttajaRepository;
import wad.repository.KommenttiRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainTesteja {

    @Autowired
    private FileObjectRepository fileObjectRepo;
    @Autowired
    private KommenttiRepository kommenttiRepo;
    @Autowired
    private KayttajaRepository kayttajaRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testTallentuukoKayttaja() {

        Kayttaja testiKayttaja = new Kayttaja();

        testiKayttaja.setNimimerkki("testi");
        testiKayttaja.setEmail("testi@asdasd.com");
        testiKayttaja.setAuthorities(Arrays.asList("ADMIN"));
        testiKayttaja.setSalasana(passwordEncoder.encode("salasana"));
        //onks ongelma et kyseessä repo eikä service?
        kayttajaRepo.save(testiKayttaja);

        Kayttaja loydetty = kayttajaRepo.findByNimimerkki("testi");
        assertNotNull(loydetty);
        assertEquals("testi@asdasd.com", loydetty.getEmail());
        assertTrue(loydetty.getAuthorities().contains("ADMIN"));
    }

    @Test
    public void testTallentuukoKommentti() {

        Kommentti testiKommentti = new Kommentti();
        testiKommentti.setSisalto("Hei olen Testi-Kommentti!");
        
        Kayttaja kommentinLisaaja = new Kayttaja();
        kommentinLisaaja.setNimimerkki("kommentoija");
        kommentinLisaaja.setEmail("kommentoija@asdasd.com");
        kommentinLisaaja.setAuthorities(Arrays.asList("USER"));
        kommentinLisaaja.setSalasana(passwordEncoder.encode("salasana"));
        kayttajaRepo.save(kommentinLisaaja);
        testiKommentti.setKayttaja(kommentinLisaaja);
        
        
        FileObject fileObject = new FileObject();
        fileObjectRepo.save(fileObject);
        testiKommentti.setFileobject(fileObject);

        kommenttiRepo.save(testiKommentti);

        List<Kommentti> loydettyLista = kommenttiRepo.findByFileobject(fileObject);
        Kommentti loydettyKommentti = loydettyLista.get(0);

        assertNotNull(loydettyKommentti);
        assertEquals("Hei olen Testi-Kommentti!", loydettyKommentti.getSisalto());
        assertEquals(kommentinLisaaja, loydettyKommentti.getKayttaja());
        assertEquals(fileObject, loydettyKommentti.getFileobject());

    }

}
