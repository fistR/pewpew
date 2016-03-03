#Manuaaliset testit#

HUOM: Jotkut näistä on myös testattu JUnit testeillä.

**Ohjelma toimii**:
- Ohjelma käynnistyy omalla koneella ja laitoksen koneella.
- Ohjelma ei jumita missään vaiheessa, toimii täydellisellä 60fps
vaikka koko näyttö olisi täynnä vihollisia ja luoteja.

**Komennot toimii**:
- Nuolinäppäimiä painaessa pelaajan kuuluu siirtyä samaan suuntaan kun
nuoli, paitsi jos peli on hävitty. Toimii 100%. 
- Välilyöntiä painaessa pelaajan kuuluu ampua 
yksi luoti katsomaansa suuntaan, paitsi jos peli on hävitty. Toimii 100%.
- Välilyöntiä alhalla pidetessä pelaajan kuuluu ampua yksi luoti, odottaa
sekunti ja sitten ampua sarjatulta, paitsi jos peli on hävitty. Toimii 100%.
- R nappia painaessa pelin tulee aina käynnistymään alusta uudelleen. Pisteet
ja elämät uusiksi. Toimii 100%
- ESC nappia painaessa milloin tahansa, pelin tulee sulkea itsensä. Toimii 100%.
- Outoja syötteitä ei ole. Peli ei voi mitenkään koitua vikatilanteeseen nappeja painamalla
tai muutenkaan, paitsi jos painaa käyttöjärjestelmän nappikomboa niin ohjelma voi sulkeutua.
Obviously.

**Pelin kulku**
- Jos pelaaja osuu viholliseen mistä tahansa suunnasta + vähän pelivaraa jotta
peli ei olisi mahdoton, vihollinen poistetaan ja pisteet nouseevat
kymmenellä. Toimii 100%.
- Jos vihollinen koskee tai on todella lähellä pelaajaa, pelaaja menettää hengen
ja vihollinen poistetaan pelistä. Toimii 100%.
- Kun pelaajan henget putoavat 0 tai alemmas, peli on ohi. Toimii aina 100%.
- Kun peli on ohi, tulee aina game over tekstit, viholliset jatkavat etsintää ikuisuuteen
koska se näyttää kivalta.
- Kun luoti menee pois ruudulta se poistetaan. Toimii 100%. Testattu konsolilla. 

