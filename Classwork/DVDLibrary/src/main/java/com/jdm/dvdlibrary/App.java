package com.jdm.dvdlibrary;

import com.jdm.dvdlibrary.controller.DvdLibraryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author  Joe McAdams
 * @email   joedmcadams@gmail.com
 * @purpose DVD collection program for 2nd MThree Java bootcamp assessment
 */

public class App {
    public static void main(String[] args){
       /* UserIO io = new UserIOConsoleImpl();                                    //Input/output object
        DvdLibraryView view = new DvdLibraryView(io);                           //View injected with input/output object
        //DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
        DvdLibraryDaoLambda dao = new DvdLibraryDaoLambdaFileImpl();                        //Data access object
        DvdLibraryController controller = new DvdLibraryController(dao, view);  //Controller object injected with dao and view
        controller.run();    */                                                  //Run main program logic
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdLibraryController controller = ctx.getBean("controller", DvdLibraryController.class);
        controller.run();
    }
}
