
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Kommentti extends AbstractPersistable<Long>{
    
    @NotBlank
    private String sisalto;
    
    @ManyToOne
    private Kayttaja kayttaja;
    
    @ManyToOne
    private Kuva kuva;
}
