package com.jdm.dvdlibrary.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public class Dvd {
    private String title, director, studio, note, mpaaRating; 
    private LocalDate releaseDate;
    
    public Dvd(String title, String director, String studio, 
            String note, String mpaaRating, String releaseDate){
        this.title = title;
        this.director = director;
        this.studio = studio;
        this.note = note;
        this.mpaaRating = mpaaRating;
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.title);
        hash = 89 * hash + Objects.hashCode(this.director);
        hash = 89 * hash + Objects.hashCode(this.studio);
        hash = 89 * hash + Objects.hashCode(this.note);
        hash = 89 * hash + Objects.hashCode(this.mpaaRating);
        hash = 89 * hash + Objects.hashCode(this.releaseDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        if (!Objects.equals(this.mpaaRating, other.mpaaRating)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }
    
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
       this.title = title;
    }
    
    public String getDirector(){
        return this.director;
    }
    public void setDirector(String director){
        this.director = director;
    }
    
    public String getStudio(){
        return this.studio;
    }
    public void setStudio(String studio){
        this.studio = studio;
    }
    
    public String getNote(){
        return this.note;
    }
    public void setNote(String note){
        this.note = note;
    }
    
    public String getMpaaRating(){
        return this.mpaaRating;
    }
    public void setMpaaRating(String mpaaRating){
        this.mpaaRating = mpaaRating;
    }
    
    public LocalDate getReleaseDate(){
        return this.releaseDate;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }
}
