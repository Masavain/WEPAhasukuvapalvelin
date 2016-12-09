
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
    private String nimi;

    public List<Tykkays> getTykkaukset() {
        return tykkaukset;
    }

    public void setTykkaukset(List<Tykkays> tykkaukset) {
        this.tykkaukset = tykkaukset;
    }

    public int getTykkayksienSumma() {
        return tykkayksienSumma;
    }

    public void setTykkayksienSumma(int tykkayksienSumma) {
        this.tykkayksienSumma = tykkayksienSumma;
    }

    public Kayttaja getLisaaja() {
        return lisaaja;
    }

    public void setLisaaja(Kayttaja lisaaja) {
        this.lisaaja = lisaaja;
    }

    public List<Tagays> getTagaykset() {
        return tagaykset;
    }

    public void setTagaykset(List<Tagays> tagaykset) {
        this.tagaykset = tagaykset;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
 
    
    
}
