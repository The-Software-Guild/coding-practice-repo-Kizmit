/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.Dvd;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Joe McAdams
 */
public interface DvdLibraryDaoLambda extends DvdLibraryDao{
    
    /**
     * Return a list of DVDs that have been released in the last n years
     * @param n
     * @return List<Dvd>
     */
    public List<Dvd> getDvdsInReleaseWindow(int n);
    
    /**
     * Return a list of DVDs that have the rating passed in through the parameter
     * @param rating
     * @return List<Dvd>
     */
    public List<Dvd> getDvdsWithRating(String rating);
    
    /**
     * Return a list of DVDs with specified director separated into different
     * data structures by MPAA rating
     * @param director
     * @return List<Dvd>
     */
    public List<Dvd> getDvdsWithDirector(String director);
    
    /**
     * Return a list of Dvds created by the specified studio
     * @param studio
     * @return List<Dvd>
     */
    public List<Dvd> getDvdsWithStudio(String studio);
    
    /**
     * Return the average age of the DVDs in the collection
     * @return List<Dvd>
     */
    public BigDecimal calculateAverageAgeOfDvds();
    
    /**
     * Return the DVD with the most recent release date
     * @return BigDecimal avg
     */
    public Dvd getNewestDvd();
    
    /**
     * Return the DVD with the oldest release date
     * @return Dvd obj
     */
    public Dvd getOldestDvd();
    
    /**
     * Return the average number of notes (?) associated with DVDs in the collection
     * @return BigDecimal avg
     */
    public BigDecimal calculateAverageNumberOfNotes();
    
}
