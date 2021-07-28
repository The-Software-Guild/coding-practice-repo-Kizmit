/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.classroster;

import com.jdm.classroster.controller.ClassRosterController;
import com.jdm.classroster.dao.ClassRosterDao;
import com.jdm.classroster.dao.ClassRosterDaoFileImpl;
import com.jdm.classroster.ui.ClassRosterView;
import com.jdm.classroster.ui.UserIO;
import com.jdm.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }   
}
