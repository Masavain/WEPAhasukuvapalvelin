
package wad.controller;


import static org.codehaus.groovy.runtime.DefaultGroovyMethods.find;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTesteja {
    
   
    
    
    @Test
    public void ifNotLoggedIn(){
        //Jos ei kirjautunut, ohjaa login-sivulle.
    }
    
    @Test
    public void workingLinkProfile(){
        //Tarkistetaan, että linkki johtaa oikealle sivulle.
    }
    
    @Test 
    public void logOutWorks(){
        //Tarkistetaan, että uloskirjautuminen toimii.
    }
    
    @Test
    public void picAdd(){
        //Tarkistetaan kuvanlisäysominaisuus.
    }
    
    @Test
    public void loginWithLegitUserRightPass(){
        //Tarkistetaan, että kirjautuminen toimii oikealla käyttäjällä.   
    }
    
    @Test
    public void loginWithWrongPass() {
        //Tarkistetaan, että kirjautuminen ei onnistu väärällä käyttäjällä.
    }
    
    @Test
    public void loginWithUserDoesntExist() {
        //Tarkistetaan, että kirjautuminen ei onnistu olemattomalla käyttäjällä.
    }
    
    @Test
    public void likeCountUpdates() {
        //Tarkistetaan, että tykkäysten määrä lisääntyy kuvasta tykättäessä.
    }
    
    @Test
    public void commentAppears() {
        //Tarkistetaan, että kommentti ilmestyy sivulle.
    }
    
}
