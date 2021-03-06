
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Kayttaja extends AbstractPersistable<Long>{
    
    @NotBlank
    @Length(min = 3, max = 20)
    @Column(unique=true)
    private String nimimerkki;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 6)
    @Column(unique=true)
    private String salasana;
    @OneToMany
    private List<FileObject> fileobjects;
    @OneToMany
    private List<Kommentti> kommentit;
    
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities;

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
    
    public List<String> getAuthorities() {
        return authorities;
    }
 
    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
    
}
