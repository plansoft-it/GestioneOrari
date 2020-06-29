
# Gestione Orari

Viene richiesto di risolvere il problema di import delle presenze giornaliere aziendali lavorate. Quando viene eseguito un aggiornamento del software o un calcolo di fine anno l'inserimento delle presenze viene bloccato, per cui le presenze devono essere segnate in uno strumento di terze parti che per la maggior parte è un foglio o un file di testo. 

Ogni giorno contiente una serie di intervalli di tempo (>=1), ogni intervallo di tempo è relativo a una commessa e contiene una nota descrittiva del lavoro svolto.

Es: Il giorno **27/05/20** ho lavorato **dalle 9 alle 18** per la commessa **Formazione** il lavoro che ho svolto è **Studio Java**.

È possibile creare un software in java che preso in input un file di testo in cui sono segnati i dati sopra mi restituisca le informazioni cumulative di lavoro?

Considerare che in un file può esserci più di un giorno e che ogni giorno si possa lavorare per più commesse in intervalli diversi.

## Develop 

Dipendenze Java: 
- [Lombok](#lombok)
- [AssertJ](#assertj)
- [Mockito](#mockito)

#### Prima di iniziare l'installazione

1. Aprire l'IDEE e selezionare il progetto in cui si vuole installare le dipendenze.
2. Creare una nuova cartella  `Rigth Click -> New -> Folder`
3. Assegnare un nome alla cartella il nome *lib* e cliccare su **Finish**.

### Lombok

Utilizzata per ridurre le righe di codice per metodi e costruttori, vedi [sito Lombok](https://projectlombok.org/).

#### Installazione
1. Andare su [Lombok](https://projectlombok.org/download) e cliccare su **Download** per scaricare il *lombok.jar*.
(Il browser potrebbe segnalare il *.jar* come dannoso, ignoratelo)
2. Eseguire *lombok.jar* (Su linux: `java -jar lombok.jar`)
	- Se Lombok è in grado di individuare uno o più IDEE, selezionare quelli su cui si vuole installare Lombok e cliccare su **Install/Update**.
	- Se Lombok non è in grado di individuare un IDEE, cliccare su **Specify location...** e selezionare l'eseguibile dell'IDEE su cui si vuole installare Lombok. Cliccare quindi **Install/Update**.
3. Chiudere l'installer.
4. Spostare  il *lombok.jar* nella cartella *lib* del progetto in cui vogliamo installare la dipendenza (Drag and Drop nell'IDEE, navigando nel filesystem, ... )
5. Nell'IDEE selezionare nuovamente il progetto,  premere **F5** sulla propria tastiera oppure `Rigth Click -> Refresh`
6. Nella cartella *lib* dovrebbe essere comparso il *lombok.jar*. Selezionarlo e `Rigth Click -> Build Path -> Add to Build Path`
7. Chiudere e riaprire l'IDEE.

#### Cosa fare se dopo l'installazione Eclipse non si dovesse aprire

Nella cartella in cui è installato Eclipse individuare e aprire il file *eclipse.ini*.
Rimuovere l'ultima riga, dovrebbe assomigliare a:

`-javaagent:/home/ant/anto/eclipse/lombok.jar`

Il problema è probabilmente dovuto ad eventuali spazi nel path, provate ad aggiornare i nomi delle directory in modo da rimuoverli. Es:

`-javaagent:/dir uno/dirdue/lombok.jar` 

`-javaagent:/diruno/dirdue/lombok.jar`

### AssertJ

Libreria utilizzata per semplificare e rendere più leggibili i test. Vedi [sito](https://assertj.github.io/doc/) e [documentazione](https://www.javadoc.io/doc/org.assertj/assertj-core/latest/index.html).

#### Installazione
1. Scaricare da [mvnrepository.com](https://mvnrepository.com/artifact/org.assertj/assertj-core) la versione desiderata del *AssertJ*. 
	- Nella colonna *Version* cliccare sulla versione desiderata.  
	- Nella nuova pagina cliccare sul link  *jar* alla riga denominata *Files*.
2. Spostare  il *assertj-core-x.xx.x.jar* nella cartella *lib* del progetto in cui vogliamo installare la dipendenza (Drag and Drop nell'IDEE, navigando nel filesystem, ... )
8. Nell'IDEE selezionare nuovamente il progetto,  premere **F5** sulla propria tastiera oppure `Rigth Click -> Refresh`
9. Nella cartella *lib* dovrebbe essere comparso il *assertj-core-x.xx.x.jar*. Selezionarlo e `Rigth Click -> Build Path -> Add to Build Path`
10. Chiudere e riaprire l'IDEE.


### Mockito
Framework per la simulazione delle dipendenze di una classe durante gli unit test. Vedi [sito](https://site.mockito.org/).
#### Installazione (TL;DR alla fine)
1. Scaricare da [mvnrepository.com](https://mvnrepository.com/artifact/org.mockito/mockito-core) la versione desiderata di *Mockito*. 
	- Nella colonna *Version* cliccare sulla versione desiderata.  
	- Nella nuova pagina cliccare sul link  *jar* alla riga denominata *Files*.
2. Scaricare le dipendenze di Mockito
	- Nella pagina corrente, andare alla voce *Compile Dependencies (3)*
	- Per ogni riga (3 in totale) cliccare sul link nella colonna *Version*
		- Nella nuova pagina scaricare il *jar* cliccando sul link  *jar* alla riga denominata *Files*
3. Spostare  i *jar* scaricati nella cartella *lib* del progetto in cui vogliamo installare la dipendenza (Drag and Drop nell'IDEE, navigando nel filesystem, ... )
4. Nell'IDEE selezionare nuovamente il progetto,  premere **F5** sulla propria tastiera oppure `Rigth Click -> Refresh`
5. Nella cartella *lib* dovrebbe essere comparsi i jar aggiunti. Selezionarli e `Rigth Click -> Build Path -> Add to Build Path`
6. Chiudere e riaprire l'IDEE.


#### TL;DR scaricare Mockito 3.3.3
1. Scaricare i seguenti *jar*
	- [mockito 3.3.3](https://repo1.maven.org/maven2/org/mockito/mockito-core/3.3.3/mockito-core-3.3.3.jar)
	- [byte-buddy 1.10.5](https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/1.10.5/byte-buddy-1.10.5.jar)
	- [byte-buddy-agent 1.10.5](https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy-agent/1.10.5/byte-buddy-agent-1.10.5.jar)
	- [objenesis 2.6](https://repo1.maven.org/maven2/org/objenesis/objenesis/2.6/objenesis-2.6.jar)
2. Spostare i *jar* nella cartella *lib*.
3. Nell'IDEE, su ogni *jar* in *lib* eseguire `Rigth Click -> Build Path -> Add to Build Path`.


## Classi 

### src/parser/Parser.java

#### Descrizione
Questa classe ha il compito di prendere il file con le presenze, eseguirne il parse. Questa classe implementa l'interfaccia IParser.
Per inizzializare un oggetto di tipo **Parser** e necessario passargli una stringa con il il percorso del file.

#### Funzioni

##### parse()
>public List<Row> parse() throws IOException

###### Descrizione Funzione
La funzione ha il compito di leggere il file, linea per linea, e separare i singoli dati sulla linea (utilizzando .split).
I dati nel file vengono separati in in delle righe, le quali (tutte) hanno:
  -data
  -Ora di inizio del lavoro (per una determinata commessa)
  -Ora di conclusione del lavoro (per una determinata commessa)
  -Commessa per la quale ha lavorato
  -Note varie

###### Parametri
La funzione non ha parametri.

###### Return
La funzione ritorna un oggetto di tipo List<Row> , all' interno del quale sono presenti tutte le righe. 





### src/parser/FormatChecker.java

#### Descrizione
Questa classe è utilizzata per controllare se i dati elaborati all'interno della classe Parser.Java sono "corretti"  (Ad esempio, che non vengono scritti orari/date che non esistono

#### Funzioni

##### checkDate()
>public static Date checkDate(String date) throws ParseException

###### Descrizione Funzione
La funzione ha il compito di prendere una data e controllare se sia una data che esista e sia corretta (e successivamente ritornare un dato di tipo SimpleDateFormat), e qualora non esista lanciare un eccezione che comunichi che la data è sbaglia/non corretta.
 

###### Parametri
La funzione prende come parametro un dato di tipo **String**

###### Return
La funzione ritorna un oggetto di tipo SimpleDateFormat. 


##### checkTimeCustomFormat()
>public static LocalTime checkTimeCustomFormat(String time) throws WrongFormatException 

###### Descrizione Funzione
La funzione ha il compito di prendere un orario e controllare che esista e sia corretto (e successivamente ritornare un dato di tipo LocalTime), e qualora non esista lanciare un eccezione che comunichi che l'orario è sbaglio/non corretto.
 

###### Parametri
La funzione prende come parametro un dato di tipo **String**

###### Return
La funzione ritorna un oggetto di tipo LocalTime. 


##### checkOrderTime()
>public static void checkOrderTime(LocalTime start, LocalTime end) throws WrongFormatException

###### Descrizione Funzione
La funzione è utilizzata per controllare che l'orario di inizio del lavoro, sia antecedente a quello della fine. Qualora non fosse cosi, verra lanciata un eccezione comunicando che che l'orario iniziale deve essere antecedente a quello finale.

###### Parametri
La funzione prende come parametro due dati di tipo **LocalTime** , dove il primo (start) è l' orario iniziale, e il secondo (end) e l'orario finale

###### Return
La funzione è di tipo void, quindi, non ritorna  niente.



 
 
  

   



