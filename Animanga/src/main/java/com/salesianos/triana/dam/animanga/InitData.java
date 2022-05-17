//package com.salesianos.triana.dam.animanga;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.salesianos.triana.dam.animanga.model.Categoria;
//import com.salesianos.triana.dam.animanga.model.Manga;
//import com.salesianos.triana.dam.animanga.model.Mangaka;
//import com.salesianos.triana.dam.animanga.repository.ICategoriaRepositorio;
//import com.salesianos.triana.dam.animanga.repository.IMangaRepositorio;
//import com.salesianos.triana.dam.animanga.repository.IMangakaRepositorio;
//
//import lombok.RequiredArgsConstructor;
//
//
//@Component
//public class InitData {
//	@Autowired
//	private  IMangaRepositorio mangaRepositorio;
//	@Autowired
//	private  IMangakaRepositorio mangakaRepositorio;
//	@Autowired
//	private  ICategoriaRepositorio categoriaRepositorio;
//
//	@PostConstruct
//
//	public void run() {
//
//		Categoria shonen = Categoria.builder().nombre("Shonen").descripcion("Shonen").build();
//		categoriaRepositorio.save(shonen);
//
//		Categoria shojo = Categoria.builder().nombre("Shojo").descripcion("Shojo").build();
//		categoriaRepositorio.save(shojo);
//
//		Categoria seinen = Categoria.builder().nombre("Seinen").descripcion("Seinen").build();
//		categoriaRepositorio.save(seinen);
//
//		Mangaka mangaka1 = Mangaka.builder().nombre("Eichiiro Oda").edad(48)
//				.urlPortada("https://www.friking.es/img/cms/eiichiro_oda_one_piece-png_673822677.png")
//				.biografia(
//						"Eiichiro Oda es un mangaka japonés conocido por su serie de manga One Piece, la cual ha vendido más de 490 millones de copias en todo el mundo y ha conseguido un récord Guinness al ser el manga con mayor cantidad de copias editadas de la misma obra de cómic realizado por un único autor en todo el mundo.")
//				.build();
//		mangakaRepositorio.save(mangaka1);
//		
//		Mangaka mangaka2 = Mangaka.builder().nombre("Akira Toriyama").edad(48)
//				.urlPortada("https://alfabetajuega.com/hero/2021/06/La-historia-de-Akira-Toriyama.jpg?width=480&aspect_ratio=19:10")
//				.biografia(
//						"Akira Toriyama es un mangaka japonés conocido por su serie de manga Dragon Ball, la cual ha vendido más de 490 millones de copias en todo el mundo y ha conseguido un récord Guinness al ser el manga con mayor cantidad de copias editadas de la misma obra de cómic realizado por un único autor en todo el mundo.")
//				.build();
//		mangakaRepositorio.save(mangaka2);
//
//		Manga manga1 = Manga.builder().urlPortada(
//				"https://i0.wp.com/codigoespagueti.com/wp-content/uploads/2022/03/Jujutsu-Kaisen-manga-volumen-19.jpg?resize=1280%2C2000&quality=80&ssl=1")
//				.nombre("Jujutsu Kaisen").descripcion("Jujutsu kaisen es un manga muy popular en japon ANAZHEE")
//				.editorial("Norma Editorial").numPags(35).isbn10("12345678910").pesoProducto(2.5).categoria(shonen)
//				.autor(mangaka1).build();
//
//		mangaRepositorio.save(manga1);	
//		
//		Manga manga2 = Manga.builder().urlPortada(
//				"https://somoskudasai.com/wp-content/uploads/2021/09/Vol-17.jpg")
//				.nombre("Jujutsu Kaisen").descripcion("Jujutsu kaisen es un manga muy popular en japon ANAZHEE")
//				.editorial("Norma Editorial").numPags(35).isbn10("12345678910").pesoProducto(2.5).categoria(shonen)
//				.autor(mangaka1).build();
//
//		mangaRepositorio.save(manga2);
//
//		Manga manga3 = Manga.builder().urlPortada(
//				"https://pm1.narvii.com/6427/ad1c18ec21693a01d8150264abf6ff18f7a5489c_hq.jpg")
//				.nombre("One Piece").descripcion("Jujutsu kaisen es un manga muy popular en japon ANAZHEE")
//				.editorial("Norma Editorial").numPags(35).isbn10("12345678910").pesoProducto(2.5).categoria(shojo)
//				.autor(mangaka1).build();
//
//		mangaRepositorio.save(manga3);
//		
//		Manga manga4 = Manga.builder().urlPortada(
//				"https://i.pinimg.com/564x/89/f1/d2/89f1d2069fa542c70bf68c6b3430e337.jpg")
//				.nombre("Naruto").descripcion("Jujutsu kaisen es un manga muy popular en japon ANAZHEE")
//				.editorial("Norma Editorial").numPags(35).isbn10("12345678910").pesoProducto(2.5).categoria(seinen)
//				.autor(mangaka1).build();
//
//		mangaRepositorio.save(manga4);
//		
//		Manga manga5 = Manga.builder().urlPortada(
//				"https://i.pinimg.com/originals/45/0e/33/450e334da7aaafc7cda718409e5c226c.jpg")
//				.nombre("Naruto").descripcion("Jujutsu kaisen es un manga muy popular en japon ANAZHEE")
//				.editorial("Norma Editorial").numPags(35).isbn10("12345678910").pesoProducto(2.5).categoria(seinen)
//				.autor(mangaka1).build();
//
//		mangaRepositorio.save(manga5);
//		
//		
//		
//	}
//}
