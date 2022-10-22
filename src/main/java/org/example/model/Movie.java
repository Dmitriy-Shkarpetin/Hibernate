package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

    @Column(name = "name")
    private String movieName;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    public Movie() {
    }

    public Movie(Director director, String movieName, int yearOfProduction) {
        this.director = director;
        this.movieName = movieName;
        this.yearOfProduction = yearOfProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfPublication(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", director=" + director +
                ", movieName='" + movieName + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
