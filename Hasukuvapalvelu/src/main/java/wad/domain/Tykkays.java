/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Tykkays extends AbstractPersistable<Long> {

    private int arvo;
    @ManyToOne
    private FileObject fileobject;
    @ManyToOne
    private Kayttaja kayttaja;

    public Tykkays() {
    }

    public Kayttaja getKayttaja() {
        return kayttaja;
    }

    public void setKayttaja(Kayttaja kayttaja) {
        this.kayttaja = kayttaja;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public FileObject getFileobject() {
        return fileobject;
    }

    public void setFileobject(FileObject fileobject) {
        this.fileobject = fileobject;
    }

}
