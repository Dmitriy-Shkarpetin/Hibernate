package org.example;

import org.example.model.Director;
import org.example.model.Item;
import org.example.model.Movie;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class).addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //create
            Director director = session.get(Director.class, 1);
            Movie newMovie = new Movie(director, "New movie for Quentin Tarantino", 1905);
            director.getMovies().add(newMovie);
            session.save(newMovie);


            Director director2 = new Director("MyDirector", 11);
            Movie newMovie2 = new Movie(director2, "MyMovie", 1901);
            director2.setMovies(new ArrayList<>(Collections.singletonList(newMovie2)));
            session.save(director2);
            session.save(newMovie2);


            //read
            Director director3 = session.get(Director.class, 2);
            String directorName = director3.getDirectorName();
            System.out.println(directorName);
            List<Movie> movies = director3.getMovies();
            for (Movie movie : movies) {
                System.out.println(movie.getMovieName());
            }


            Movie movie = session.get(Movie.class, 5);
            System.out.println(movie.getMovieName());
            Director director4 = movie.getDirector();
            System.out.println(director4.getDirectorName());


            //update
            Movie movie2 = session.get(Movie.class, 16);
            Director director5 = session.get(Director.class, 1);
            movie2.getDirector().getMovies().remove(movie2);
            movie2.setDirector(director5);
            director5.getMovies().add(movie2);


            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 1);
            item.getOwner().getItems().remove(item);
            item.setOwner(person);
            person.getItems().add(item);


            //delete
            Director director6 = session.get(Director.class, 2);
            List<Movie> movies2 = director6.getMovies();
            for (Movie movie3 : movies2) {
                session.remove(movie3);
            }
            director6.getMovies().clear();
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}


