/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.classroster.service;

import com.jdm.classroster.dao.ClassRosterAuditDao;
import com.jdm.classroster.dao.ClassRosterPersistenceException;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException{
        
    }
}
