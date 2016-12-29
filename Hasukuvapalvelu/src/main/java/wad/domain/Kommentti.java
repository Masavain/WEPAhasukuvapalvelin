package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kommentti extends AbstractPersistable<Long> {

    @NotBlank
    private String sisalto;

    @ManyToOne
    private Kayttaja kayttaja;

    @ManyToOne
    private FileObject fileobject;

    public Kommentti() {
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public FileObject getFileobject() {
        return fileobject;
    }

    public void setFileobject(FileObject fileobject) {
        this.fileobject = fileobject;
    }
    
    
}
