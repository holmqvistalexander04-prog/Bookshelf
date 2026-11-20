# Bokhyllan – Java / objektorientering med arrayer

Det här projektet löser grunduppgiften i **Bokhyllan_objektorientering.pdf**.
Det är ett litet konsolprogram där du kan lägga in, ta ut, söka efter
och visa böcker på en bokhylla med **exakt 10 platser**.

## Öppna och kör i IntelliJ IDEA

1. Packa upp ZIP-filen.
2. Starta **IntelliJ IDEA** och välj **File → Open**.
3. Välj mappen **Bokhyllan-IntelliJ** (den innehåller `pom.xml`).
4. Godkänn projektimport om IntelliJ frågar.
5. Se till att **Project SDK** är **JDK 17** eller nyare
   (File → Project Structure → Project → SDK).
6. Öppna `src/main/java/Main.java`.
7. Klicka på den gröna triangeln vid `main()` och välj **Run 'Main.main()'**.
8. Skriv en siffra i **Run**-fönstret och tryck Enter för att välja i menyn.

Ingen databas eller externa bibliotek behövs. `pom.xml` finns med för att
IntelliJ enkelt ska känna igen projektet.

## Vad finns i filerna?

- `Book.java`: En bok med privata fält för ISBN, titel och författare.
  Du kan läsa värdena via getters (`getIsbn`, `getTitle`, `getAuthor`).
- `Bookshelf.java`: En **privat `Book[]`-array** med tio platser.
  Metoder för att sätta in, ta ut, hitta och visa böcker.
- `Main.java`: Menyn som användaren arbetar med. Visar hur `Book` och
  `Bookshelf` samverkar.

## Varför används null?

När arrayen skapas är alla 10 platser `null` (tomma).
`addBook` letar efter första platsen som är `null`. När `removeBook`
tar ut en bok sätts just den platsen till `null` igen, så platsen
kan återanvändas.

## Kraven i uppgiften

- [x] En klass för bokhyllan och en för böcker.
- [x] ISBN, titel och författare som text (`String`).
- [x] Max 10 böcker.
- [x] Ett tydligt meddelande vid försök att lägga till bok nr 11.
- [x] Möjlighet att läsa information om en bok.
- [x] Visa hyllans innehåll när som helst via menyn.
- [x] Uttagen bok lämnar ett `null` i arrayen.
- [x] Privata datafält: användaren hanterar objekten via metoder.

**Frivillig extrauppgift:** Lånekonton/personer ingår inte här, eftersom
PDF:en beskriver dem som en utökning *om ni har tid över*.

## Testa själv

1. Lägg till två böcker och välj **3** för att se dem.
2. Ta ut boken på plats **1**, välj **3** och se att platsen blir ledig.
3. Lägg till en ny bok och se att plats **1** används igen.
4. Fyll alla tio platser och försök sätta in ytterligare en bok.
5. Sök efter ett ISBN som finns och ett som inte finns.

## Frågor att fundera på

1. Varför är `books` privat i `Bookshelf`?
2. Varför jämför vi med `null` i `addBook`?
3. Varför använder vi `placeNumber - 1` i `removeBook`?
4. Varför behövs ingen `extends` eller `interface` i denna uppgift?

Projektet använder vanliga klasser och en array eftersom det är just
**objektorientering med arrayer** som övningen handlar om.
