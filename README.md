# javafejleszt-tesztfeladatnovin
Bebesi András Teszt Feladat megoldás  Novin 

Ez a program a Novin Informatikának az állás interjú tesztfeladatára készült.

A program Spring framework-ben készült.
Tartalmazza a lombok és JUnit könyvtárakat is.

Szoftver használata:
1. Git repository klónozása a személyi számítógépre.
2. Egy IDE-ben megnyitni. És lefutattni a programot. 
3. Meghívni a localhost:8080/data POST végpontot ez vagy ehhez hasonló JSON fájlal:
[
    {
        "value":"alma",
        "length":3
    },
    {
        "value":"tehervonat",
        "length":10
    },
    {
        "value":"ember",
        "length":1
    },
    {
        "value":"aaaaaab",
        "length":6
    }
]
4. A config.conf fájl módosítássával adhatja meg a tiltott karakterek listáját. 
Jelenlegi verzióban egyetlen karakter tiltott az 'a' karakter. 
Minden tiltott karakter új sorba kerüljön.
Módosítás érvényesítése nem igényel sem újra build-delést, sem újra indítást. Csak ismét meg kell hívni a végpontot.


Megjegyzés:
Junit teszt a a számításokhoz készült.

