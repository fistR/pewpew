#PewPew Game#

**Aihe:** Peli jossa liikutetaan pelaajaa ja ammutaan lähestyviä pahiksia kunnes kuollaan.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**
Nuolinäppäimet liikuttaa pelaajaa näppäimen suuntaan.

Spacebar ampuu ammuksen, tai monta jos pitää näppäintä
pohjassa tarpeeksi kauan.

R resetoi pelin.

ESC sulkee pelin.



**Ohjelman rakenne**

Ohjelman pääluokka käynnistää JavaFX:n ja sen tarvittavat luokat (Stage, GraphicsContext, Stage ym.)
ja alustaa myös pelin logiikan ja oliot.

Game Loop on saatu aikaan Timeline luokalla joka initialisoidaan sillä tavalla että saadaan aikaan
60fps peli looppi. Tässä loopissa käydään seuraavat asiat järjestyksessä läpi joka kerta(joka frame):

*Resetoidaan Grafiikka:*
Renderer luokka hoitaa visuaalisen, ja nyt kutsutaan sitä poistamaan kaikki ja uudelleen piirtämään
vain taustakuvan.

*Prosessoidaan napin painallukset:*
InputHandler luokalle syötetään kaikki KeyEventit ja se rekisteröi mitkä napit on painettu, 
ja sitten hoitaa sen minkä pitää tapahtua. Esim: Käyttäjä painaa spacebar, InputHandler tunnistaa
tämän ja lähettää GameControllerille että nyt pitää ampua.

*Päivitetään logiikka:*
GameController vastaa siitä että kaikkien olioiden tila päivitetään enimmäkseen käyttäen
ali Controllereita.

*Käsitellään törmäykset:*
CollisionController tarkistaa uusien olioiden sijainnit ja laskee tapahtuuko törmäyksiä(Collision). Jos 
tapahtuu, lisää kontrolleri kaikki törmäykset listaan ja sen jälkeen käsittelee ne riippuen mitkä oliot
törmäävät mihin. (pelaaja, vihollinen, luoti jne)

*Piirretään oliot:*
Nyt Renderer pääsee taas hommiin piirtämällä kaikki olemassa olevat oliot jotka se hakee
GameControllerilta ja sen alikontrollereilta niiden päivitettyihin sijainteihin ja suunnillaan.


**Peli loopin kulku sekvenssi:**
![Alt text](gameloop.png)

**Ammuksen elinikä:**
![Alt text](bulletlife.png)

**Pahiksen elinikä:**
![Alt text](enemylife.png)


**Luokka rakenne:**
![Alt text](luokkakaavio.png)

