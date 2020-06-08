# Gestione Orari

Viene richiesto di risolvere il problema di import delle presenze giornaliere aziendali lavorate. Quando viene eseguito un aggiornamento del software o un calcolo di fine anno l'inserimento delle presenze viene bloccato, per cui le presenze devono essere segnate in uno strumento di terze parti che per la maggior parte è un foglio o un file di testo. 

Ogni giorno contiente una serie di intervalli di tempo (>=1), ogni intervallo di tempo è relativo a una commessa e contiene una nota descrittiva del lavoro svolto.

Es: Il giorno **27/05/20** ho lavorato **dalle 9 alle 18** per la commessa **Formazione** il lavoro che ho svolto è **Studio Java**.

È possibile creare un software in java che preso in input un file di testo in cui sono segnati i dati sopra mi restituisca le informazioni cumulative di lavoro?

Considerare che in un file può esserci più di un giorno e che ogni giorno si possa lavorare per più commesse in intervalli diversi.

## Develop 

Dipendenze Java: 
- [Lombok](#lombok)

### Lombok

Utilizzata per ridurre le righe di codice per metodi e costruttori, vedi [sito Lombok](https://projectlombok.org/).

#### Installazione in ambiente Linux
1. Andare su [Lombok](https://projectlombok.org/download) e cliccare su **Download** per scaricare il *lombok.jar*.
(Il browser potrebbe segnalare il *.jar* come dannoso, ignoratelo)
2. Eseguire *lombok.jar*: `java -jar lombok.jar`
- Se Lombok è in grado di individuare uno o più IDEE, selezionare quelli su cui si vuole installare Lombok e cliccare su **Install/Update**.
- Se Lombok non è in grado di individuare un IDEE, cliccare su **Specify location...** e selezionare l'eseguibile dell'IDEE su cui si vuole installare Lombok. Cliccare quindi **Install/Update**.
3. Chiudere l'installer.
4. Aprire l'IDEE e selezionare il progetto in cui si vuole utilizzare Lombok (consiglio il tab *Package Explorer*).
5. Creare una nuova cartella  `Rigth Click -> New -> Folder`
6. Assegnare un nome alla cartella (es: *lib*) e cliccare su **Finish**.
7. Aggiungere alla cartella *lib* appena creata il *lombok.jar* (Drag and Drop nell'IDEE, navigando nel filesystem, ... )
8. Nell'IDEE selezionare nuovamente il progetto,  premere **F5** sulla propria tastiera oppure `Rigth Click -> Refresh`
9. Nella cartella *lib* dovrebbe essere comparso il *lombok.jar*. Selezionarlo e `Rigth Click -> Build Path -> Add to Build Path`
10. Chiudere e riaprire l'IDEE.

#### Installazione in ambiente Windows
Seguire gli stessi passaggi illustrati sopra, fatta eccezione per il punto 2.

#### Cosa fare se dopo l'installazione Eclipse non si dovesse aprire

Nella cartella in cui è installato Eclipse individuare e aprire il file *eclipse.ini*.
Rimuovere l'ultima riga, dovrebbe assomigliare a:

`-javaagent:/home/ant/anto/eclipse/lombok.jar`

Il problema è probabilmente dovuto ad eventuali spazi nel path, provate a rimuoverli. Es:

`-javaagent:/dir uno/dirdue/lombok.jar` 

`-javaagent:/diruno/dirdue/lombok.jar`
