package com.jdm.dvdlibrary.controller;

import com.jdm.dvdlibrary.dto.Dvd;
import com.jdm.dvdlibrary.ui.DvdLibraryView;
import com.jdm.dvdlibrarydao.DvdLibraryDaoException;

import com.jdm.dvdlibrarydao.DvdLibraryDaoLambda;

import java.util.List;
import java.util.Map;

/**
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 */

public class DvdLibraryController {
    private final DvdLibraryDaoLambda dao;
    private final DvdLibraryView view;
    
    public DvdLibraryController(DvdLibraryDaoLambda dao, DvdLibraryView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean exit = false;
        
        try{
            dao.loadDvdLibrary();
            
            while(!exit){
                switch(getMenuSelection()){
                    case 1: 
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editEntry();
                        break;
                    case 4:
                        viewDvdLibrary();
                        break;
                    case 5:
                        viewDvdLibraryWithFilter();
                        break;
                    case 6:
                        getDvdInfo();
                        break;
                    case 7:
                        searchForDvd();
                        break;
                    case 8:
                        getNewestOldestDvd();
                        break;
                    case 9:
                        getAverages();
                        break;
                    case 0:
                        exit = true;
                        break; 
                }
            }
        
        dao.saveDvdLibrary();
        }
        catch(DvdLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        view.printMenuBanner();
        return view.printMenuGetSelection();
    }

    private void addDvd(){
        view.printAddDvdBanner();
        dao.addDvd(view.createDvd());
        view.printAddDvdSuccess();
    }

    private void editEntry(){
        view.printEditDvdBanner();
        String dvdTitle;
        Dvd dvd = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        if(dvd != null){
            dao.editDvd(dvdTitle, view.getFieldFromUser(), view.getUpdatedFieldDataFromUser());
            view.printEditDvdSuccess();
        }
        else{
            view.printEditDvdFailure();
        }
    }

    private void removeDvd(){
        view.printRemoveDvdBanner();
        String dvdTitle;
        Dvd dvd = dao.searchForDvd(dvdTitle = view.getTitleFromUser());
        if(dvd != null){
            Dvd removedDvd = dao.removeDvd(dvdTitle);
            view.printRemoveSuccess(removedDvd);
        }
        else{
            view.printRemoveFailure();
        }
        
    }

    private void viewDvdLibrary() {
        view.printViewLibraryBannerHeader();
        List<Dvd> dvdList = dao.getDvdList();
        view.printLibraryList(dvdList);
    }

    private void getDvdInfo(){
        view.printGetDvdInfoBanner();
        Dvd dvd = dao.getDvdInfo(view.getTitleFromUser());
        if(dvd != null){
            view.printDvdInfo(dvd);
        }
        else{
            view.printDvdInfoFailure();
        }
    }

    private void searchForDvd(){
        
        view.printSearchBanner();
        Dvd dvd = dao.searchForDvd(view.getTitleFromUser());
        if(dvd != null){
            view.printSearchSucces();
            view.printDvdInfo(dvd);
        }
        else{
            view.printSearchFailure();
        }
    }

    private void viewDvdLibraryWithFilter() {
        List<Dvd> filteredDvdList = null;
        Map<String, List<Dvd>> directorRatingDvdMap = null;
        switch(view.printGetFilterMenuChoice()){
            case 1:
                //Movies released in the last N years
                filteredDvdList = dao.getDvdsInReleaseWindow(view.getReleaseWindowFromUser());
                break;
            case 2:
                //Movies with given MPAA rating
                filteredDvdList = dao.getDvdsWithRating(view.getRatingFromUser());
                break;
            case 3:
                //Movies by given director separated into lists by rating
                directorRatingDvdMap = dao.getDvdsWithDirector(view.getDirectorFromUser());
                break;
            case 4:
                //Movies released by particular studio
                filteredDvdList = dao.getDvdsWithStudio(view.getStudioFromUser());
                break;
        }
        if(directorRatingDvdMap != null){
            view.printViewLibraryBannerHeader();
            directorRatingDvdMap.forEach((rating, dvdList) -> view.printLibraryList(dvdList));
        }
        else if(filteredDvdList != null){
            view.printViewLibraryBannerHeader();
            view.printLibraryList(filteredDvdList);
        }
        else{
            view.printSearchFailure();
        }
       
    }

    private void getNewestOldestDvd() throws DvdLibraryDaoException {
        Dvd dvd = null;
        try{
            switch(view.printGetOldestNewestDvd()){
                case 1:
                    dvd = dao.getNewestDvd();
                    break;
                case 2:
                    dvd = dao.getOldestDvd();
                    break;
            }
            if(dvd != null){
                view.printGetDvdInfoBanner();
                view.printDvdInfo(dvd);
            }
            else{
                view.printDvdInfoFailure();
            }
        }
        catch(DvdLibraryDaoException e){
            throw new DvdLibraryDaoException("No elements in list when looking for newest/oldest DVD");
        }
    }

    private void getAverages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
