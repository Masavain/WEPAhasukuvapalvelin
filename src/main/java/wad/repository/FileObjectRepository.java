
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.FileObject;
import java.util.*;
import wad.domain.Kayttaja;

public interface FileObjectRepository extends JpaRepository<FileObject, Long>{
    List<FileObject> findByLisaaja(Kayttaja lisaaja);
}
