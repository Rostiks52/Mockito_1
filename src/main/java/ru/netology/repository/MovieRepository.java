package ru.netology.repository;

import ru.netology.manager.MovieManager;
import ru.netology.domain.MovieView;

public class MovieRepository {
    private MovieView[] movies = new MovieView[0];

    public void save(MovieView view){
        int lenght = movies.length + 1;
        MovieView[] tmp = new MovieView[lenght];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = view;
        movies = tmp;
    }

    public MovieView[] findAll(){
        return movies;
    }
    public void removeById(int id){
        int index = 0;
        for (MovieView view : movies) {
            if (view.getId() == id) {
                int lenght = movies.length - 1;
                MovieView[] tmp = new MovieView[lenght];
                for (MovieView view1 : movies){
                    if (view1.getId() != id){
                        tmp[index] = view1;
                        index++;
                    }
                }
                movies = tmp;
                return;
            }
        }
    }
}
