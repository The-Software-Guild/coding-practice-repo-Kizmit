package com.jdm.dvdlibrary.ui;

import com.jdm.dvdlibrary.dto.Dvd;

import java.util.List;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public class DvdLibraryView {
    private final UserIO io;
    
    public DvdLibraryView(UserIO io){
        this.io = io;
    }
    
    public int printMenuGetSelection(){
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List DVD collection");
        io.print("5. List DVD collection with filter");
        io.print("6. Get information about a DVD");
        io.print("7. Search for a DVD");
        io.print("8. Get the newest or oldest movie in collection");
        io.print("9. Get average age of movies/number of notes");
        io.print("0. Exit");
        
        return io.readInt("Please make your menu selection from the above choices: ", 0, 9);
    }
    
    public void printMenuBanner(){
        io.print("=======================MENU========================");
    }

    public void printAddDvdBanner() {
        io.print("=================ENTER DVD DETAILS=================");
    }
    public void printAddDvdSuccess() {
        io.print("The DVD was successfully added to the collection.");
    }
    
    public void printViewLibraryBannerHeader() {
        io.print("================================================================================DVD LIBRARY=================================================================================");
        String tableHeader = String.format("%-35s%-25s%-25s%-50s%-25s%-25s\n", "Title", "Director", "Studio", "Note", "MPAA Rating", "Release Date");
        io.print(tableHeader);
    }
    
    public void printRemoveDvdBanner() {
        io.print("====================DVD REMOVAL====================");
    }
    public void printRemoveSuccess(Dvd removedDvd){
        io.print("DVD \"" + removedDvd.getTitle() + "\" removed.");
    }
    public void printRemoveFailure() {
        io.print("Failed to remove entry; it doesn't exist in the collection.");
    }
    
    public void printEditDvdBanner() {
        io.print("====================DVD EDITOR=====================");
    }
    public void printEditDvdSuccess() {
        io.print("DVD field updated successfully.");
    }
    public void printEditDvdFailure() {
        io.print("Edit failed: The DVD you wish to update doesn't exist.");
    }
    
    public void printSearchBanner(){
        io.print("======================SEARCH=======================");
    }
    public void printSearchSucces() {
        io.print("The DVD was found in the collection.");
    }
    public void printSearchFailure() {
        io.print("No DVD with that title exists in the collection.");
    }
    
    public void printGetDvdInfoBanner() {
        io.print("=================DVD INFORMATION==================");
    }
    public void printDvdInfo(Dvd dvd){
        io.print("Title: " + dvd.getTitle());
        io.print("Director: " + dvd.getDirector());
        io.print("Studio: " + dvd.getStudio());
        io.print("Note: " + dvd.getNote());
        io.print("MPAA Rating: " + dvd.getMpaaRating());
        io.print("Release Date: " + dvd.getReleaseDate());
    }
    public void printDvdInfoFailure() {
        io.print("Failed to get information on DVD(s); it/they don't exist in the collection.");
    }
 
    public Dvd createDvd(){
        Dvd dvd = new Dvd(io.readString("Title:"), io.readString("Director:"), io.readString("Studio:")
                          , io.readString("Note:"), io.readString("MPAA Rating:"), io.readString("Release Date (yyyy-mm-dd):"));
        return dvd;
    }

    public void printLibraryList(List<Dvd> dvdList) {
        String fDvdStr;
        
        for(Dvd dvd : dvdList){
            fDvdStr = String.format("%-35s%-25s%-25s%-50s%-25s%-25s\n", dvd.getTitle(), dvd.getDirector(), dvd.getStudio()
                              , dvd.getNote(), dvd.getMpaaRating(), dvd.getReleaseDate());
            io.print(fDvdStr);
        }
    }

    public String getTitleFromUser() {
        String title = io.readString("Enter the title of the DVD: ");
        return title;
    }
    
    public int getFieldFromUser(){
        io.print("Which field would you like to update: ");
        io.print("1. Title");
        io.print("2. Director");
        io.print("3. Studio");
        io.print("4. Note");
        io.print("5. MPAA Rating");
        io.print("6. Release Date");
        int field = io.readInt("Enter the value of the menu choices above: ", 1, 6);
        return field;
    }

    public String getUpdatedFieldDataFromUser() {
        String newField = io.readString("Enter the information preferred in the field selected: ");
        return newField;
    }

    public void displayErrorMessage(String message) {
        System.out.println(message);
    }

    public int printGetFilterMenuChoice() {
        io.print("Which filter would you like to apply: ");
        io.print("1. DVDs released in the last N years");
        io.print("2. DVDs with specified MPAA rating");
        io.print("3. DVDs with specified director (sorted by MPAA rating)");
        io.print("4. DVDs released by a specified studio");
        return io.readInt("Enter the value of the menu choices above: ", 1, 4);
    }

    public int getReleaseWindowFromUser() {
        return io.readInt("Enter number of years to go back (min 1, max 100):", 1, 100);
    }

    public String getRatingFromUser() {
        return io.readString("Enter the MPAA rating you're interested in: ");
    }

    public String getDirectorFromUser() {
        return io.readString("Enter the director you're interested in: ");
    }

    public String getStudioFromUser() {
        return io.readString("Enter the studio you're interested in: ");
    }

    public int printGetOldestNewestDvd() {
        io.print("Oldest or newest: ");
        io.print("1. Newest");
        io.print("2. Oldest");
        return io.readInt("Enter the value of the menu choices above: ", 1, 2);
    }
}
