
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
    private List<FileObject> fileobjects;

    public Tagays() {
        this.fileobjects = new ArrayList<>();
    }

    public String getTagi() {
        return tagi;
    }

    public void setTagi(String tagi) {
        this.tagi = tagi;
    }

    public List<FileObject> getFileobjects() {
        return fileobjects;
    }

    public void setFileobjects(List<FileObject> fileobjects) {
        this.fileobjects = fileobjects;
    }
    
    public void addFileobject(FileObject fo) {
        this.fileobjects.add(fo);
    }
    
    
}
