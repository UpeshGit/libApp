package com.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Library.
 */
@Entity
@Table(name = "library")
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "location_description")
    private String locationDescription;

    @OneToMany(mappedBy = "library")
    @JsonIgnore
    private Set<Books> jobs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public Library location(String location) {
        this.location = location;
        return this;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public Library locationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
        return this;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public Set<Books> getJobs() {
        return jobs;
    }

    public Library jobs(Set<Books> books) {
        this.jobs = books;
        return this;
    }

    public Library addJob(Books books) {
        this.jobs.add(books);
        books.setLibrary(this);
        return this;
    }

    public Library removeJob(Books books) {
        this.jobs.remove(books);
        books.setLibrary(null);
        return this;
    }

    public void setJobs(Set<Books> books) {
        this.jobs = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Library library = (Library) o;
        if (library.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, library.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Library{" +
            "id=" + id +
            ", location='" + location + "'" +
            ", locationDescription='" + locationDescription + "'" +
            '}';
    }
}
