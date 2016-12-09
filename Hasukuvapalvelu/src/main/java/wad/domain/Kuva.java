
package wad.domain;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kuva extends AbstractPersistable<Long>{
    @OneToMany
    private List<Tykkays> tykkaukset;
    private int tykkayksienSumma;
    @ManyToOne
    private Kayttaja lisaaja;
    @ManyToMany
    private List<Tagays> tagaykset;
    
}
