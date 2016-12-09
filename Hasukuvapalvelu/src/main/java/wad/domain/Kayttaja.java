
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Kayttaja extends AbstractPersistable<Long>{
    
    @NotBlank
    @Length(min = 3, max = 20)
    private String nimimerkki;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 6)
    private String salasana;
    @OneToMany
    private List<Kuva> kuvat;
    @OneToMany
    private List<Kommentti> kommentit;

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }
    
    
    
}
