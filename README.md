# RATE LIMIT API

Aplikacija je odrađena spring boot-om i Java tehnologijom u razvojnom okruženju IntelliJ IDEA - Community edition.

Kreirano je:

- interfejs - GreetService.java na lokaciji src\main\java\com\nemanja\greet\service

- implementacija interfejsa - GreetServiceImpl.java na lokaciji src\main\java\com\nemanja\greet\service

- end point - GreetController.java na lokaciji src\main\java\com\nemanja\greet\controller

- aplikacija za SpringBoot koja se prva pokreće i pokreće aplikaciju - GreetApplication.java na lokaciji src\main\java\com\nemanja\greet\


Aplikacija broji hint-ove prema URL-u http://localhost/greet/me

i vraća ispis Hi, me!

Brojač je podešen da se resetuje nakon 60 sekundi i nakon 10 pokušaja vraća response:
429 - Too Many Requests

U koliko zelimo da implementiramo fleksibilnu limitaciju, moguće je dodati još jedan end-point koji ima metodu SET
kojom bi setovao druge limite

Za Load balanser i aplikaciju koja se vrti na nodovima, kreirali bi bazu i broj hintova bi manage-ovali na baznom nivou.


UPUTSTVO ZA IMPLEMENTACIJU:
