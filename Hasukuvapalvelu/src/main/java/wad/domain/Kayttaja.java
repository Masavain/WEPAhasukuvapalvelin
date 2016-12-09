
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.*;


@Entity
public class Kayttaja extends AbstractPersistable<Long>{
    
    private String nimimerkki;
    private String salasana;
    @OneToMany
    private List<Kuva> kuvat;
    @OneToMany
    private List<Kommentti> kommentit;
    
    
}
