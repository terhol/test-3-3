# Test 3-3
Third test version 3 from subject PB162 on [FI MUNI](https://www.fi.muni.cz/)

## Description (Czech language only)
Rozhraní ani předdefinované třídy neměňte, pokud to přímo nevyžaduje zadání. Metody NEMUSÍTE dokumentovat pomocí JavaDoc komentářů. Používejte zásadně privátní atributy.

Úloha simuluje zápis známek studentům a výpočet konečné známky jako zaokrouhleného průměru získaných známek.

**Zadání:**

-   Vytvořte třídu TeachersNotebook implementující rozhraní ITeachersNotebook.
- Několik rad a poznámek:
    - Pro zaokrouhlení reálného čísla na nejbližší celé číslo viz třída java.lang.Math. Nezapomeňte také, že dělit nulou se nesmí.
    - Pokud budete uzavírat vstup/výstup, tak myslete na to, že k uzavření by mělo dojít za všech okolností, tedy i pokud nastala chyba.
    - Nezapomeňte, že metoda save() má studenty do souboru zapisovat v pořadí daném jejich přirozeným uspořádáním.
    - V metodě load() je třeba ošetřit případný chybný formát vstupních dat.


Třída Main by při správném řešení měla vypsat:

        Pepa's marks [2, 1, 1]
        Re-loading notebook from file
        Pepa's marks: [2, 1, 1] => 1
        Franta's marks: [3] => 3
        Jirka's marks: [5, 4] => 5

a zároveň by měla v aktuálním adresáři, ze kterého se spouští, vytvořit soubor notebook.txt s následujícím obsahem (pořadí řádků je důležité):
- 1 Josef Vomacka:2 1 1
- 2 Franta Vopicka:3
- 3 Jirka Jelinek:5 4

## License
MIT