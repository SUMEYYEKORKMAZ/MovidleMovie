package com.example.movidlemovie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadMovieList {

    public static ArrayList<Movie> movieList = new ArrayList<>();

    public static void ReaderMovie() {

        try (BufferedReader reader = new BufferedReader(new FileReader("res/imdb_top_250.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length == 8) {
                    String MID = parts[0].trim();
                    String MName = parts[1].trim();
                    String MYear = parts[2].trim();
                    String MGenre = parts[3].trim();
                    String MOrigin = parts[4].trim();
                    String MDirector = parts[5].trim();
                    String MStar = parts[6].trim();
                    String MLink = parts[7].trim();

                    Movie movie = new Movie(MName, MYear, MGenre, MOrigin, MDirector, MStar, MID, MLink);
                    movieList.add(movie);
                }
            }
            assignQuotesFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void assignQuotesFromFile() {
        String filepath = "res/quotes.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < movieList.size()) {
                Movie movie = movieList.get(index);
                movie.setMQuotes(line);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Movie getMovieById(List<Movie> movieList) {
        if (movieList.isEmpty()) {
            throw new RuntimeException("Film listesi boş");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(movieList.size());

        return movieList.get(randomIndex);
    }

    public static Movie getMovieDetails(String movieName, ArrayList<Movie> movieList) {
        for (Movie movie : movieList) {
            if (movie.getMName().equalsIgnoreCase(movieName)) {
                return movie;
            }
        }
        return null;
    }
}
