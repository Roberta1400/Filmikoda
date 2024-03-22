package com.example.demo.filmid;

import com.example.demo.filmid.FilmService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    public FilmService filmService(FilmRepository filmRepository) {
        return new FilmService(filmRepository);
    }

    @Bean
    @Order(1)
    CommandLineRunner filmCommandLineRunner(FilmRepository repository){
        return args -> {
            Film lotte = new Film(1L,"Lotte", "animatsioon", "0", "eesti", "https://lottemaa.ee/wp-content/uploads/2023/01/4741281318809.png");
            Film interstellar = new Film("Interstellar", "scifi", "14", "inglise","https://m.media-amazon.com/images/I/81v1NMJBrlL._AC_UF894,1000_QL80_.jpg");
            Film film1 = new Film("Pulp Fiction", "drama", "18", "inglise", "https://cdn.europosters.eu/image/750/poster/pulp-fiction-one-sheet-i4435.jpg");
            Film film2 = new Film("The Notebook", "romcom", "12", "inglise", "https://m.media-amazon.com/images/I/51sQ796v0nL._AC_UF894,1000_QL80_.jpg");
            Film film3 = new Film("The Shining", "horror", "16", "inglise", "https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg");
            Film film4 = new Film("The Godfather", "drama", "18", "inglise", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg");
            Film film5 = new Film("Titanic", "romcom", "12", "inglise", "https://m.media-amazon.com/images/I/51nbDBJ2h3L._AC_UF1000,1000_QL80_.jpg");
            Film film6 = new Film("Psycho", "horror", "16", "inglise", "https://www.originalfilmart.com/cdn/shop/products/psycho_1960_linen_original_film_art_f2_1200x.jpg?v=1593652743");
            Film film7 = new Film("Forrest Gump", "drama", "12", "inglise", "https://m.media-amazon.com/images/I/41Al9falobL._AC_UF894,1000_QL80_.jpg");
            Film film8 = new Film("Bridget Jones's Diary", "romcom", "12", "inglise", "https://m.media-amazon.com/images/I/51QSukon9OL._AC_UF894,1000_QL80_.jpg");
            Film film9 = new Film("The Exorcist", "horror", "18", "inglise", "https://m.media-amazon.com/images/I/61tF7jKagWL._AC_UF894,1000_QL80_.jpg");
            Film film10 = new Film("The Shawshank Redemption", "drama", "16", "inglise", "https://m.media-amazon.com/images/I/71715eBi1sL._AC_UF894,1000_QL80_.jpg");
            Film film11 = new Film("10 Things I Hate About You", "romcom", "12", "inglise", "https://m.media-amazon.com/images/I/71dgB-Pj61S.jpg");
            Film film12 = new Film("A Quiet Place", "horror", "16", "inglise", "https://m.media-amazon.com/images/I/516fV0Y-OaL._AC_UF1000,1000_QL80_.jpg");
            Film film13 = new Film("The Green Mile", "drama", "16", "inglise", "https://m.media-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1_FMjpg_UX1000_.jpg");
            Film film14 = new Film("When Harry Met Sally", "romcom", "12", "inglise", "https://m.media-amazon.com/images/I/51teQcMQrPL._AC_UF894,1000_QL80_.jpg");
            Film film15 = new Film("Scream", "horror", "18", "inglise", "https://m.media-amazon.com/images/I/7114ViRptyL.jpg");
            Film film16 = new Film("Fight Club", "drama", "18", "inglise", "https://m.media-amazon.com/images/I/81sZU-iKNGL.jpg");
            Film film17 = new Film("Notting Hill", "romcom", "12", "inglise", "https://m.media-amazon.com/images/I/81X22GSrSXL._AC_UF894,1000_QL80_.jpg");
            repository.saveAll(List.of(lotte, interstellar, film1, film2, film3, film4, film5, film6, film7, film8, film9, film10,
                    film11, film12, film13,film14, film15, film16, film17));
        };
    }
}
