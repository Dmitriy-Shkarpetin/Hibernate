package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @Column(name = "director_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String directorName;

    @Column(name = "age")
    private int directorAge;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director() {
    }

    public Director(String directorName, int directorAge) {
        this.directorName = directorName;
        this.directorAge = directorAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getDirectorAge() {
        return directorAge;
    }

    public void setDirectorAge(int directorAge) {
        this.directorAge = directorAge;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", directorName='" + directorName + '\'' +
                ", directorAge=" + directorAge +
                ", movies=" + movies +
                '}';
    }
}
