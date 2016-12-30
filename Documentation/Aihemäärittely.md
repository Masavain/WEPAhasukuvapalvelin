**Aihe:**

Kuvapalvelin, jonne käyttäjä voi kirjautua ja lisätä kuvia omista tiedostoistaan. Käyttäjä voi siirtyä omaan profiiliinsa, jossa hän näkee lisäämänsä kuvat. 

Käyttäjä voi siirtyä kuvavirtaan, jossa hän näkee myös muiden lisäämiä kuvia. Käyttäjä voi kommentoida ja tykätä/epätykätä omista ja muiden kuvista. Jokaisen kommentin yläpuolella on kommentoijan nimimerkki, jota painamalla pääsee kommentoijan profiiliin.

Jos käyttäjällä ei ole tunnusta sivustolle, on hänellä mahdollisuus luoda sellainen toisella sivulla. Tänne hän pääsee kirjautumissivulla olevasta linkistä. (Tämän toteuttaminen ei onnistunut.)



**Toteutetut ominaisuudet:**

Kirjautumissivu
* käyttäjä voi kirjautua sisään syöttämällä järjestelmään rekisteröidyn nimimerkin ja salasanan

Profiili
* yläosassa käyttäjän nimimerkki
* linkki kuvavirtaan ja uloskirjautumiseen
* käyttäjän lisäämät kuvat
* kuvaa painamalla käyttäjä ohjataan kuvavirtaan, missä mahdollisuus kommentoida ja tykätä

Kuvavirta
* kuvavirta
* kuva
* kuvien selaus: edellinen ja seuraava
* kuvien lisäys omista tiedostoista
* kuvien kommentointi mahdollisuus
* mahdollisuus tykätä/ei-tykätä kuvasta
* linkki profiiliin ja uloskirjautumiseen


_Ei toteutetut:_

Kuvavirran näkyminen kirjautumattomalle käyttäjälle
* Tarkoituksena oli, että kirjautumaton käyttäjä voi nähdä kuvavirran. Toteutus ei onnistunut rekisteröitymissivua luodessa tulleiden ongelmien vuoksi

Rekisteröitymissivu
* Tarkoituksena oli luoda sivu, jossa uusi käyttäjä voisi rekisteröityä palveluun. Rekisteröitymisen jälkeen käyttäjä voisi siirtyä kirjautumissivulle ja kirjauduttua lisätä omia kuviaan. Rekisteröitymissivun saimme tehtyä, mutta sen liittäminen projektiin ei onnistunut. Käyttötapauskaavio on luotu tämän mukaiseksi.

Oma kirjautumissivu
* Palvelussa on jo kirjautumissivu, mutta olisimme halunneet erilaisen kirjautumissivun, jossa olisi linkki rekisteröitymissivulle. Tämän sivun saimme tehtyä, mutta sen liittäminen projektiin ei jostain syystä onnistunut.

Tagays
* tietokantataulu, joka on kuvan tietokantataulun kanssa monen-suhde-moneen yhteydessä
* Tarkoituksena: Käyttäjä voi lisätä kuvaansa tageja. Yhdellä tagilla voi olla myös muitakin kuvia ja kullakin kuvalla voi olla muitakin tageja. Tagia klikatessa käyttäjän olisi ollut mahdollista nähdä muut samalla tagilla merkityt kuvat.
