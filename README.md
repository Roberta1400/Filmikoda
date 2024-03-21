# CGI Suvepraktika Ülesanne - Filmikoda

Filmikoda veebirakendus pakub kasutajatele võimalust avastada laia valikut filme, leida sobivaid seansse ning broneerida pileteid mugavalt. Kasutajad saavad valida erinevaid filtreid, et leida kiirelt ja lihtsalt just neile huvipakkuvaid filme. Lisaks piletite broneerimisel pakutakse kasutajale kõige paremaid vabu kohti kinosaalis, võimaldades neil nautida parimat vaadet ning kogemust filmi vaatamisel.

# Kuidas käivitada projekti?

## Andmebaasi setup

1. Laadige alla PostgresSQL ja PgAdmin tööriist
2. PostgreSQL installimise käigus määra üldkasutaja parool, port ja kasutajanimi.

## Backendi ühendus andmebaasiga

1. Ava application.properties fail (src/main/resources/application.properties)
2. Lisa oma username ja password vastavatesse ridadesse (spring.datasource.username=postgres ja spring.datasource.password=password)

## Backendi käivitamine 

### 1. Nõuded:
  - Java Development Kit (JDK) - versioon 21
  - Maven

### 2. Paigaldamine ja käivitamine:
  2.1. Laadige alla või kloonige backendi repositoorium oma arvutisse. (package demo)
  2.2. Avage IntelliJ ning jooksutage DemoApplication (src/main/java/com/example/demo/DemoApplication.java)

## Frontendi käivitamine

### 1. Nõuded
   -Node.js
   -npm
   *Mõlemat saab laadida alla nodejs.org. lehelt

### 2. Käivitamine

Liigu frontend kausta
`cd frontend`

Laadi alla paketid
`npm install`

Käivitage rakendus
`npm start`

## Autor
### Roberta Solom


