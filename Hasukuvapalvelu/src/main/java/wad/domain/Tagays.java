
package wad.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.*;


@Entity
class Tagays extends AbstractPersistable<Long>{
    private String tagi;
    
    @ManyToMany
    private List<Kuva> kuvat;
}
