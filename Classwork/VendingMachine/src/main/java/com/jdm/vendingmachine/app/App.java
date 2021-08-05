package com.jdm.vendingmachine.app;

import com.jdm.vendingmachine.controller.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class App {
    public static void main(String[] args){
        /*UserIO io = new UserIOConsoleImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, auditDao);
        VendingMachineController controller = new VendingMachineController(service, view);
        controller.run();*/
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
    }
}
