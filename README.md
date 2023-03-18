# Gather your party!

L'obiettivo di questo esercizio è la creazione di sottoclassi della classe `Character`. È necessario aver terminato le parti 1 e 2 prima di iniziare questo esercizio.

### Consegna
L'esercizio viene assegnato mercoledì 15 febbraio. La consegna dell'esercizio è prevista per mercoledì 22 febbraio alle 9:50. Sono previste, quindi, 5 ore in aula per il completamento dell'esercizio.

Prima di consegnare assicurati di **passare tutti gli Unit Test**.

## Task richiesti
Il compito principale di questo esercizio è estendere la classe Character e renderla non istanziabile. A tale scopo effettuare le seguenti modifiche alla classe `Character`:
- organizzare il codice in *packages* (vedi i **Suggerimenti**)
- rendere la classe *astratta*;
- rendere il costruttore *protetto*;
- aggiungere il *metodo astratto* `specialAction()`;
- aggiungere l'attributo `specialActionCost` di tipo intero maggiore di 1.
- aggiungere l'attributo difesa, il cui valore di *default* è 0. La difesa può essere passta al costruttore; se non lo fosse, va impostato il valore di default = 0. (vedi i *Suggerimenti*)
- modificare `takeDamage(int n)` in modo che il danno venga ridotto della difesa. Quindi dannoSubito = attacco – difesa. Verificare che il danno subito non possa mai essere negativo.
- aggiungere il metodo `heal(int n)` che cura il personaggio di `n`. La salute massima non può superare il valore iniziale del personaggio.
- aggiungere un metodo `int performAction()` che, se il personaggio è ancora vivo, decide in base al mana disponibile se effettuare l'azione speciale o l'attacco base.
- modificare il `main()` affinché venga richiamato il metodo `performAction()` al posto di `attack()`.

Ogni gruppo dovrà quindi creare una sottoclasse specifica della classe `Character`. Vengono di seguito ripoposti alcuni esempi dell'esercizio Code Combat assegnato lo scorso anno scolastico. Questi casi devono essere implementati, uno per gruppo. Siete liberi di implementarne anche più di una, inventandone di nuove.

Stabilite il costo in mana dell'attacco speciale in modo che sia molto maggiore dell'attacco base (ad esempio, 4 volte l'attacco base). In una fase successiva raffineremo tutti i valori per rendere l'economia di gioco bilanciata.

### Barbaro
Il barbaro ha equipaggiato uno scuodo, quindi la sua difesa deve essere diversa da zero. Impostate, ad esempio, la difesa = 2.

#### Abilità speciale: *Berserk*
Il personaggio lancia 1d6, poi effettua un’azione a seconda del risultato:
- se il risultato è 5 o 6 effettua un altro attacco, dopodiché il turno termina;
- se il risultato è 3 o 4 effettua un altro attacco, poi perde il 10% dei suoi punti vita, arrotondati per difetto, dopodiché il turno termina;
- se il risultato è 1 o 2, perde il 20% dei suoi punti vita, arrotondati per difetto, dopodiché il turno termina senza effettuare attacchi.

### Mago
*Concentrazione assoluta*: il personaggio lancia 1d6. Se il risultato è 4+, il mago aggiunge **permanentemente** 1d4 al suo attacco base.

### Ladro
*Pugnali acidi*: il personaggio lancia 1d12. Se il risultato è 7+, riduce **permanentemente** la difesa degli avversari di 1d4. Se la difesa dell'avversario è 0, i *Pugnali acidi* infliggono direttamente il doppio del risultato ottenuto come danno.

## Classe `Dummy`
Per testare le funzionalità e simulare un party composto da 2 personaggi, potete temporaneamente implementare la classe `Dummy`, che rappresenta un "manichino". Il manichino lancia 1d1 come attacco e non ha attacchi speciali (potete semplicemente mettere `return 1`.

## Suggerimenti

### Migliorie al codice
Ci sono alcune migliorie che possono essere effettuate per rendere il codice più sicuro ed efficiente.
- rendere `final` tutti i parametri che non devono cambiare
- 

### Parametri opzionali con valori di default
In Java non è possibile rendere un parametro del costruttore opzionale con un valore di default. Questa funzionalità può essere però simulata utilizzando più costruttori con parametri diversi, come nel seguente esempio:
```java
public class Example {
    private int x;
    private int y;
    
    public Example(int x) {
        this.x = x;
        this.y = 0;
    }
    
    public Example(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

### Packages
In Java, i package sono utilizzati per organizzare le classi in gruppi logici e gerarchici. I package consentono di raggruppare insieme classi con funzionalità simili, migliorando l'organizzazione del codice e rendendolo più facile da gestire.

Per utilizzare le classi di un package in un file sorgente Java, è necessario dichiarare l'import del package all'inizio del file. Ad esempio, per importare tutte le classi del package `java.util`, si può usare l'istruzione:
```java
import java.util.*;
```
In alternativa, è possibile importare una classe specifica all'interno di un package con l'istruzione:
```java
import java.util.ArrayList;
```
Per creare un nuovo package, si crea una nuova directory con il nome del package all'interno del percorso di root del progetto. Tutte le classi contenute in quella directory saranno appartenenti al package.

È possibile anche utilizzare l'accesso protetto (protected) per limitare l'accesso alle classi e ai membri all'interno di un package. Ciò significa che solo le classi all'interno dello stesso package o nelle sottoclassi possono accedere a tali membri.

L'istruzione `package NomePackage;` è utilizzata per definire il package al quale appartiene una classe Java. Tale istruzione viene solitamente scritta come prima riga del file sorgente.

Ad esempio, se abbiamo una classe `MiaClasse` che appartiene al package `com.esempio.mioPackage`, l'istruzione package `com.esempio.mioPackage`; deve essere inserita all'inizio del file sorgente della classe. In questo caso, il nome completo della classe sarebbe `com.esempio.mioPackage.MiaClasse`.

Un'organizzazione comune dei package in questo caso potrebbe essere la seguente:
- Il package radice del progetto: `codeCombatN`, dove N è la versione del progetto (in questo esercizio N=3);
- Il package per le classi delle eccezioni: `codeCombat3.exceptions`;
- Il package per le classi che estendono `Character`: `codeCombat3.characters`;

In questo modo, la struttura del progetto è organizzata in modo gerarchico, dove ogni package rappresenta una parte specifica del progetto.

L'intestazione di ogni classe dovrebbe includere l'istruzione package seguita dal nome completo del package al quale la classe appartiene. Ad esempio:

Classe Dice:
```java
package codeCombat;

public class Dice {
    // codice della classe
}
```

Classe eccezioni:
```java
package codeCombat3.exceptions;

public class CustomException extends Exception {
    // codice della classe
}
```

Sottoclasse di `Character`:
```java
package codeCombat3.characters;

import codeCombat3.Character;

public class Barbarian extends Character {
    // codice della classe
}
```