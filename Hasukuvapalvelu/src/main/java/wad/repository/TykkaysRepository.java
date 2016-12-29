
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Tykkays;
import java.util.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import wad.domain.FileObject;
import wad.domain.Kayttaja;

public interface TykkaysRepository extends JpaRepository<Tykkays, Long>{
    List<Tykkays> findByFileobject(FileObject fileobject);
    @Query("SELECT t FROM Tykkays t WHERE t.kayttaja = :kayttaja AND t.fileobject = :fileobject")
    List<Tykkays> findByKayttajaAndFileobject(@Param("kayttaja") Kayttaja kayttaja, @Param("fileobject") FileObject fileobject);
}
