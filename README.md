Chat Gjinaj Ciavarella 

Accesso/Registrazione


Quando parte il client sarà chiesto se si vuole accedere o registrarsi:


-a→Accesso;

-r→Registrazione;


note:

-Il programma non accetterà altre lettere oltre alle 2 indicate sopra;

-Non si può accedere se prima non ci si registra;

-Lo stesso utente non essere online da due client diversi contemporaneamente;


-Una volta inserita la password e fatto invio bisognerà dare invio una seconda volta per entrare nella chat.


  Chat con utenti
	
Una volta nella chat il software ci chiederà il destinatario del nostro messaggio:

All→messaggio a tutti gli utenti;
un nome utente qualsiasi registrato→messaggio privato a quel singolo utente;

Dopo questo dovremmo inserire il messaggio effettivo, il mandante vedrà il messaggio sulla destra con io:”contenuto del messaggio”, mentre il ricevente lo vedrà sempre sulla destra con nomeDelUtenteCheLoHaInviato:”contenuto del messaggio”



Esempio di visualizzazione messaggio privato:

Invio messaggio




![invioMes](https://user-images.githubusercontent.com/98747325/208304895-a4e8f109-86be-41cc-a743-0eb8f822e831.PNG)




Ricezione messaggio


![riceviMes](https://user-images.githubusercontent.com/98747325/208304938-5131db6c-c7e2-4272-8df8-f78002d819bb.PNG)


Esempio di visualizzazione messaggio pubblico:

Invio messaggio



![InvioAll](https://user-images.githubusercontent.com/98747325/208304943-89145066-e102-47fb-90b8-982cbaf275cb.PNG)






Ricezione primo utente



![riceviAll1](https://user-images.githubusercontent.com/98747325/208304946-7c3a4956-dfca-48df-8112-7beddabe2b0a.PNG)




Ricezione secondo utente



![ricevi all2](https://user-images.githubusercontent.com/98747325/208304951-7ebd425c-8348-4baa-a372-ffb0e5549ff9.PNG)







Ricapitolando nella colonna di sinistra ci saranno i comandi per mandare i messaggi mentre in quella di destra gli effettivi messaggi.





Funzionamento:

-Accesso/Registrazione 

Quando si proverà a fare l’accesso o la registrazione il client creerà un oggetto di tipo utente con il nome utente e la password forniti, una volta fatto questo lo serializza in un json e lo manderà al server.
Il server deserializza il json in un oggetto di tipo utente(che è in comune con il client) e ne ricava le informazioni necessarie per i controlli.

-Messaggio 

Discorso simile per lo scambio di messaggi infatti il client creerà un oggetto di tipo messaggio con le informazioni fornite esso poi sarà serializzato e mandato al server che lo deserializzerà in un oggetto di tipo messaggio(che è in comune con il client), da qui ne ricaverà le informazioni necessarie per mandare il messaggio al singolo utente o a tutti.

