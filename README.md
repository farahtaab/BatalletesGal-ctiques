# Projecte UF5 24/25 - Joc de les Batalletes Galàctiques

En aquest projecte, haureu de crear un joc de tauler anomenat *Batalletes Galàctiques*, ambientat en una guerra espacial entre dues flotes d'estrelles oposades. Cada jugador controlarà una flota amb diferents naus espacials, i l'objectiu serà destruir la nau **Mare Comandant** de l'altre bàndol. El joc es jugarà des de la consola, entre dos usuaris.

---

## **Consideracions:**

El projecte és força obert i haurà d'incloure els conceptes d'**herència, abstracció i encapsulació**, així com altres elements apresos durant el curs. El joc haurà de complir les següents normes:

### **1. Tauler i representació de les naus:**

- El tauler serà de 8x8 (un sector galàctic), on cada nau es representarà amb una lletra majúscula o minúscula segons el bàndol:

  | **Lletra** | **Tipus de nau**          |
  |------------|--------------------------|
  | **M**      | Nau Mare Comandant       |
  | **F**      | Fragata                  |
  | **C**      | Caçabombarders           |
  | **E**      | Exploradora              |
  | **D**      | Drons de combat          |

- Les lletres majúscules representen la flota **Alfa**, i les minúscules la flota **Beta**.

---

### **2. Regles de moviment i combat:**

- Cada tipus de nau té unes regles senzilles per al moviment:

  - **Nau Mare Comandant (M):** Es mou una casella en qualsevol direcció.
  - **Fragates (F):** Mouen fins a 2 caselles en línia recta i poden atacar naus a una distància màxima de 2 caselles.
  - **Caçabombarders (C):** Es mouen com el cavall en escacs (en L) i poden destruir qualsevol nau que ocupi la casella de destí.
    - Aquesta és l'única nau que pot saltar per sobre d'altres.
  - **Exploradores (E):** Es mouen en diagonal qualsevol nombre de caselles, però no poden atacar.
  - **Drons de combat (D):** Es mouen una casella cap endavant i ataquen en diagonal (com els peons dels escacs).

- Quan una nau es mou a una casella ocupada per una nau enemiga, es considera que l'ataca i la destrueix **(excepte les naus exploradores, que no poden atacar).**

---

### **3. Condicions de finalització del joc:**

- El joc acaba quan la **Nau Mare Comandant** d’un dels jugadors és destruïda.

---

### **4. Interacció amb l'usuari:**

- Els jugadors han d'introduir les coordenades del moviment en format "lletra" (a-h) per a les columnes i "nombre" (1-8) per a les files (per exemple: `e2 a e4`).
- Si el moviment no és vàlid, s'haurà de tornar a demanar.
- Cada torn es mostrarà el tauler actualitzat per consola.

---

### **5. Especificacions del tauler inicial:**

- Les naus han d'estar col·locades simètricament per cada bàndol, ocupant les dues primeres files per a cada jugador.

- Exemple d'una configuració inicial:

  ```
  c d d e f m f d
  d f e . . e f d
  . . . . . . . .
  . . . . . . . .
  . . . . . . . .
  . . . . . . . .
  D F E . . E F D
  C D D E F M F D
  ```

---

## **Requisits tècnics:**

- El projecte haurà d'incloure un mínim de 3 classes:
  1. **`BatalletesGalàctiques`:** La classe principal que controla la partida.
  2. **`SectorGalactic`:** Per gestionar el tauler i les regles del joc.
  3. **`Nau`:** Una classe abstracta base de la qual heretaran les diferents naus (Mare Comandant, Fragata, etc.).

Sort i que guanyi el millor! 🚀

