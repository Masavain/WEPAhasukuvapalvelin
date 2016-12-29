package wad.domain;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class FileObject extends AbstractPersistable<Long> {

    private Long size;
    @Lob
    private byte[] content;

    @OneToMany
    private List<Tykkays> tykkaukset;
    private int tykkayksienSumma;
    @ManyToOne
    private Kayttaja lisaaja;
    @ManyToMany
    private List<Tagays> tagaykset;
    private String nimi;
    @OneToMany
    private List<Kommentti> kommentit;

    public FileObject() {
    }
    
    

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
