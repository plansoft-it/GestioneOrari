
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
