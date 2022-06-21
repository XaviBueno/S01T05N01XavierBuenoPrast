Executar:

java -jar listdir.jar [nom de directori] [/s] [/f nomarxiu.txt] [/r nomarxiu.txt] [/serout nomarxiu.ser]


[/s] llista els subdirectoris recursivament
[/f nomarxiu.txt] llista el directori(i subdirectoris si hi ha l'opció /s) al arxiu nomarxiu.txt
[/r nomarxiu.txt] llista l'arxiu txt. Si es posa aquesta opció ignora les demés
[/serout nomarxiu.ser] Els arguments de la línea de comandes es posen en un objecte classe Arguments
aques objecte es serialitza en l'arxiu .ser
[/serin nomarxiu.ser] L'arxiu .ser es deserialita en un objecte de la callse arguments.  list dir s'executa 
amb els arguments rebuts de l'arxiu especificat. Si es fa servi aquesta opció ignora la resta d'arguments.
si aquest arxiu existeix l'esborra abans de carregar el llistat
Si no s'especifica directori llista l'actual
