package ru.netology.manager;

import ru.netology.domain.Movie;

public class PosterManager {
    private Movie[] movies = new Movie[0];
    private int amountMovies = 10;

    public PosterManager() {
    }

    public PosterManager(int amountMovies) {
        this.amountMovies = amountMovies;
    }

    public void add(Movie item) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

    public Movie[] getAll() {
        int resultLength;
        if (movies.length < amountMovies) {
            resultLength = movies.length;
        } else {
            resultLength = amountMovies;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : movies) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        movies = tmp;
    }
}
