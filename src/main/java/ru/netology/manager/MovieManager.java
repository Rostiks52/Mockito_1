package ru.netology.manager;

import ru.netology.domain.MovieView;
import lombok.Data;


public class MovieManager {
    private MovieView[] movies = new MovieView[0];
    private int allowedToDisplayMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int allowedToDisplayMovies) {
        this.allowedToDisplayMovies = allowedToDisplayMovies;
    }

    public MovieView[] getMovies() {
        return movies;
    }

    public void setMovies(MovieView[] movies) {
        this.movies = movies;
    }

    public int getAllowedToDisplayMovies() {
        return allowedToDisplayMovies;
    }

    public void setAllowedToDisplayMovies(int allowedToDisplayMovies) {
        this.allowedToDisplayMovies = allowedToDisplayMovies;
    }

    public void add(MovieView movie) {
        int length = movies.length + 1;
        MovieView[] tmp =new MovieView[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }
    public MovieView[] getAll() {
        MovieView[] result = new MovieView[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
    public MovieView[] showLastTen() {
        MovieView[] result = getAll();
        if (result.length >=allowedToDisplayMovies){
            MovieView[] shownList = new MovieView[allowedToDisplayMovies];
            for (int i = 0; i < allowedToDisplayMovies; i++) {
                shownList[i] = result[i];
            }
            return shownList;
        }
        return result;
    }
    public void removeById(int id) {
        int length = movies.length - 1;
        MovieView[] tmp = new MovieView[length];
        int index = 0;
        for (MovieView movie : movies){
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }
}
