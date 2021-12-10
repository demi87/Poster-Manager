package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PosterManagerTest {

    @Test
    public void shouldRemoveIfExists() {
        PosterManager manager = new PosterManager();
        int idToRemove = 1;
        Movie first = new Movie(1, "first", "Comedy", "Picture");
        Movie second = new Movie(2, "second", "Fantastic", "Picture");
        Movie third = new Movie(3, "third", "Detective", "Picture");
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};
        assertArrayEquals(expected, actual);
    }

}

class PosterManagerWithSetupTest {
    private PosterManager manager = new PosterManager();
    private Movie first = new Movie(1, "first", "Comedy", "Picture");
    private Movie second = new Movie(2, "second", "Fantastic", "Picture");
    private Movie third = new Movie(3, "third", "Detective", "Picture");
    private Movie fourth = new Movie(4, "fourth", "Cartoon", "Picture");
    private Movie fifth = new Movie(5, "fifth", "Horror", "Picture");
    private Movie sixth = new Movie(6, "sixth", "Drama", "Picture");
    private Movie seventh = new Movie(7, "seventh", "Adventure", "Picture");
    private Movie eighth = new Movie(8, "eighth", "Political", "Picture");
    private Movie ninth = new Movie(9, "ninth", "Noir", "Picture");
    private Movie tenth = new Movie(10, "tenth", "Historical", "Picture");
    private Movie eleventh = new Movie(11, "eleventh", "Action", "Picture");
    private Movie twelfth = new Movie(12, "twelfth", "Thriller", "Picture");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    public void getAll() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllWithCustomLength() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllWithCustomLength2() {
        PosterManager manager = new PosterManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 2;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExistsWithCustomLength() {
        PosterManager manager = new PosterManager(5);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        int idToRemove = 6;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd() {
        manager.add(fourth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithDefaultLength() {
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddWithCustomLength() {
        PosterManager manager = new PosterManager(3);
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}