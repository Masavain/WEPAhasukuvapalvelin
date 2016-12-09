
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.*;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Tagays extends AbstractPersistable<Long>{
    
    @NotBlank
    private String tagi;
    
    @ManyToMany
    private List<Kuva> kuvat;
}
