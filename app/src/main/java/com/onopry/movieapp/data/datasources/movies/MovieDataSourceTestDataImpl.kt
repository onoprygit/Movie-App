package com.onopry.movieapp.data.datasources.movies

import com.onopry.movieapp.data.models.actors.ActorDto
import com.onopry.movieapp.data.models.genre.GenreDto
import com.onopry.movieapp.data.models.movie.MoviesDto

class MovieDataSourceTestDataImpl: MovieDataSource {
    override fun fetchMovies() = listOf(
        MoviesDto(
            id = 1,
            title = "Гнев человеческий",
            description = "Эйч — загадочный и холодный на вид джентльмен, но внутри него пылает жажда справедливости. Преследуя...",
            rating = 3,
            ageLimit = 18,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5JP9X5tCZ6qz7DYMabLmrQirlWh.jpg"
        ),
        MoviesDto(
            id = 2,
            title = "Мортал Комбат",
            description = "Боец смешанных единоборств Коул Янг не раз соглашался проиграть за деньги. Он не знает о своем наследии...",
            rating = 5,
            ageLimit = 18,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pMIixvHwsD5RZxbvgsDSNkpKy0R.jpg"
        ),
        MoviesDto(
            id = 3,
            title = "Упс... Приплыли!",
            description = "От Великого потопа зверей спас ковчег. Но спустя полгода скитаний они готовы сбежать с него куда угодно...",
            rating = 5,
            ageLimit = 6,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/546RNYy9Wi5wgboQ7EtD6i0DY5D.jpg"
        ),
        MoviesDto(
            id = 4,
            title = "The Box",
            description = "Уличный музыкант знакомится с музыкальным продюсером, и они вдвоём отправляются в путешествие...",
            rating = 4,
            ageLimit = 12,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fq3DSw74fAodrbLiSv0BW1Ya4Ae.jpg"
        ),
        MoviesDto(
            id = 5,
            title = "Сага о Дэнни Эрнандесе",
            description = "Tekashi69 или Сикснайн — знаменитый бруклинский рэпер с радужными волосами — прогремел...",
            rating = 2,
            ageLimit = 18,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5xXGQLVtTAExHY92DHD9ewGmKxf.jpg"
        ),
        MoviesDto(
            id = 6,
            title = "Пчелка Майя",
            description = "Когда упрямая пчелка Майя и ее лучший друг Вилли спасают принцессу-муравьишку, начинается сказочное...",
            rating = 4,
            ageLimit = 0,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xltjMeLlxywym14NEizl0metO10.jpg"
        ),
        MoviesDto(
            id = 7,
            title = "Круэлла",
            description = "Невероятно одаренная мошенница по имени Эстелла решает сделать себе имя в мире моды.",
            rating = 4,
            ageLimit = 12,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hUfyYGP9Xf6cHF9y44JXJV3NxZM.jpg"
        ),
        MoviesDto(
            id = 8,
            title = "Чёрная вдова",
            description = "Чёрной Вдове придется вспомнить о том, что было в её жизни задолго до присоединения к команде Мстителей",
            rating = 3,
            ageLimit = 16,
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mbtN6V6y5kdawvAkzqN4ohi576a.jpg"
        ),
    )

    override fun fetchGenres() = listOf(
        GenreDto(id = 1, "Боевик"),
        GenreDto(id = 2, "Приключения"),
        GenreDto(id = 3, "Мультик"),
        GenreDto(id = 4, "Комедия"),
        GenreDto(id = 5, "Криминал"),
        GenreDto(id = 6, "Документальное"),
        GenreDto(id = 7, "Драма"),
        GenreDto(id = 8, "Семейный"),
        GenreDto(id = 9, "Фантастика"),
        GenreDto(id = 10, "Исторический"),
        GenreDto(id = 11, "Ужасы"),
        GenreDto(id = 12, "Музыка"),
        GenreDto(id = 13, "Мистика"),
        GenreDto(id = 14, "Романтика"),
        GenreDto(id = 15, "Научная фантастика"),
        GenreDto(id = 16, "Триллер"),
        GenreDto(id = 17, "Военный"),
        GenreDto(id = 18, "Вестерн")
    )

    override fun fetchActorsByMovieId(movieId: Int) = listOf(
        ActorDto(
            id = 1,
            name = "Igor Igorevich",
            characterName = "Character IgorI",
            imageUrl = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2/4SYTH5FdB0dAORV98Nwg3llgVnY.jpg"
        ),
        ActorDto(
            id = 2,
            name = "Andrey Andreevich",
            characterName = "Character AndreA",
            imageUrl = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2/4SYTH5FdB0dAORV98Nwg3llgVnY.jpg"
        ),
        ActorDto(
            id = 3,
            name = "Katia Katievna",
            characterName = "Character KatiaK",
            imageUrl = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2/4SYTH5FdB0dAORV98Nwg3llgVnY.jpg"
        ),
        ActorDto(
            id = 4,
            name = "Misha Mishevich",
            characterName = "Character MishaM",
            imageUrl = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2/4SYTH5FdB0dAORV98Nwg3llgVnY.jpg"
        ),
        ActorDto(
            id = 1,
            name = "Tolik Alkogolik",
            characterName = "Character Ivan",
            imageUrl = "https://www.themoviedb.org/t/p/w300_and_h450_bestv2/4SYTH5FdB0dAORV98Nwg3llgVnY.jpg"
        ),
    )
}
