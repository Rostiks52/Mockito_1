package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieView;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    private MovieManager manager = new MovieManager();
     MovieView first = new MovieView(1, 123321, "Bloodshot","thriller");
     MovieView second = new MovieView(2, 234432, "Onward", "cartoon");
     MovieView third = new MovieView(3,345543,"Hotel Belgrad", "comedy");
     MovieView forth = new MovieView(4, 456654,"gentlemen", "thriller");
     MovieView fifth =new MovieView(5,567765, "The Invisible Man", "horror");
     MovieView sixth = new MovieView(6, 678876, "Trolls World Tour", "cartoon");
     MovieView seventh = new MovieView(7, 789987, "Number One", "comedy");
     MovieView eight = new MovieView(8, 891098, "Breakfast at Tiffany's", "comedy");
     MovieView ninth = new MovieView(9, 91011109, "Love affair at work", "comedy");
     MovieView tenth = new MovieView(10, 101112, "The Age of Adaline", "drama");
     MovieView eleventh = new MovieView(11, 111213, "Moana", "cartoon");

        @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eight);
        manager.add(ninth);
//        manager.add(tenth);
//        manager.add(eleventh);
    }
    @Test
    public void shouldGetLessAbilityToDisplay(){
        manager.setAllowedToDisplayMovies(manager.getAllowedToDisplayMovies());
        MovieView [] actual = manager.showLastTen();
        MovieView [] expected = new MovieView[]{tenth, ninth, eight, seventh,sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetAllowedToDisplay(){
            manager.add(tenth);
            MovieView [] actual = manager.showLastTen();
            MovieView [] expected = new MovieView[]{tenth, ninth, eight, seventh, sixth, fifth, forth, third, second, first};
            assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGetMoreThanAllowed(){
            manager.add(tenth);
            manager.add(eleventh);
            manager.setAllowedToDisplayMovies(manager.getAllowedToDisplayMovies());
            MovieView [] actual = manager.showLastTen();
            MovieView [] expected = new MovieView[]{eleventh, tenth, ninth, eight, seventh, sixth, fifth, forth, third, second};
            assertArrayEquals(expected, actual);
    }

}
