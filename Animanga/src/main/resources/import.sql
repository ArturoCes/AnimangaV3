insert into categoria(id_categoria,nombre,descripcion)values (1,'Shonen','El manga que va dirigido a los chicos adolescentes recibe el nombre de sh?nen. Son series con grandes dosis de acción, en las que a menudo se dan situaciones humorísticas. Destaca el compañerismo entre miembros de un colectivo o de un equipo de combate. Muchos de estos mangas han devenido en anime, que es el nombre que reciben las películas de animación japonesas y los dibujos animados emitidos en televisión. Sí, el Mazinger Z de nuestra infancia (o de la mía, al menos) es shonen, aunque en otras épocas lo llamáramos los dibujos del sábado después de comer. Es shonen, en cuanto al público al que va dirigido, pero mecha por su temática; en ciencia-ficción, mecha es un vehículo de gran tamaño controlado por un piloto, muy diferente a un robot, pues este se mueve por su cuenta, de forma autónoma, sin que nadie lo controle.');

insert into categoria(id_categoria,nombre,descripcion)values (2,'Shojo','Shojo es uno de los tipos de manga: el dirigido a chicas adolescentes. Sus argumentos son siempre muy inocentes, historias de romance y fantasía, aunque tras la primera guerra del Golfo se desarrollaron personajes femeninos peleones, que luchan para proteger el destino del planeta o de una comunidad. Ese es el caso de es Sailor Moon, una alumna de secundaria nada estudiosa a la que una gata negra revela que es una poderosa guerrera cuya misión en este mundo es derrotar a varios enemigos para salvar la Tierra. Ese es el personaje que ha elegido tu hija. Sus sueños son altruistas, y sus heroínas, valientes y justas. Siéntete orgulloso.');

insert into categoria(id_categoria,nombre,descripcion)values (3,'Seinen','Seguro que alguna vez has visto un anime o leído un manga con una historia de trama más adulta de lo usual, que trata problemas muy complicados y que suele tener escenas muy violentas, e, incluso, de sexo. Aun así, a veces puede confundirse son el Shounen, pero lo que el Seinen tiene de especial es que sus tramas van dirigidas a un público más adulto. Incluso, aunque el Seinen trate una historia de fantasía, podría decirse que hay una gran dosis de realidad en ella, lo que hace que nos adentremos más en su mundo y podamos sentirnos identificados con lo que viven los personajes más fácilmente. Una vez tenemos claro esto, pasamos a analizar el Seinen más profundamente, para conocerlo mejor. ¡Allá vamos!');


insert into mangaka (id_mangaka,nombre,edad) values (1,'eichiro oda',43);

insert into manga (id,url_portada, precio,nombre, descripcion,editorial,num_pags,isbn10,peso_producto, autor_id_mangaka,categoria_id_categoria)values (1,'https://somoskudasai.com/wp-content/uploads/2021/09/Vol-17.jpg',4,'jjk','descripcion de jjk','norma Editorial',2,'123122311',0.3,1,1);
