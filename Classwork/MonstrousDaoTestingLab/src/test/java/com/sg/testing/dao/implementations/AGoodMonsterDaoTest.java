/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoA;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoB;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joe
 */
public class AGoodMonsterDaoTest {
    MonsterDao testDao;
    public AGoodMonsterDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        testDao = new BadMonsterDaoB();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetMonster() {
        //Arrange
        Monster testMonster = new Monster("Test Monster 1", MonsterType.LIZARDMAN, 15, "Humans");
        
        //Act
        testDao.addMonster(1, testMonster);
        Monster retrievedMonster = testDao.getMonster(1);
        
        //Assert
        assertNotNull(retrievedMonster, "Retrieved monster is null");
        assertEquals(testMonster, retrievedMonster, "Monster retrieved is not monster added");
        assertEquals(testDao.getAllMonsters().size(), 1, "Size of monster list is not 1");
    }
    
    @Test
    public void testRemoveMonster() {
        //Arrange
        Monster testMonster = new Monster("Test Monster 1", MonsterType.LIZARDMAN, 15, "Humans");
        
        //Act
        testDao.addMonster(1, testMonster);
        Monster removedMonster = testDao.removeMonster(1);
        
        //Assert
        assertEquals(testMonster, removedMonster, "Monster removed is not monster added");
        assertNotNull(removedMonster, "Monster is null");
        
        testDao.addMonster(1, testMonster);
        assertEquals(testDao.getAllMonsters().size(), 1, "Size of monster list is not 1");
        removedMonster = testDao.removeMonster(1);
        assertEquals(testDao.getAllMonsters().size(), 0, "Size of monster list is not 0");
        
        assertNull(testDao.removeMonster(1), "Empty removal returns not null");
    }
    
    @Test
    public void testGetAllMonsters() {
        //Arrange
        Monster testMonster = new Monster("Test Monster 1", MonsterType.LIZARDMAN, 15, "Humans");
        Monster testMonster2 = new Monster("Test Monster 2", MonsterType.YETI, 12, "Humans");
        //Act
        testDao.addMonster(1, testMonster);
        testDao.addMonster(2, testMonster2);
        Monster removedMonster;
        
        //Assert
        
        assertEquals(testDao.getAllMonsters().size(), 2, "Size of monster list is not 2");
        removedMonster = testDao.removeMonster(1);
        assertEquals(testDao.getAllMonsters().size(), 1, "Size of monster list is not 1");
        
        assertTrue(testDao.getAllMonsters().contains(testMonster2), "List doesn't contain remaing monster");
        removedMonster = testDao.removeMonster(2);
        assertFalse(testDao.getAllMonsters().contains(testMonster2), "List still contains a removed monster");
        
    }
    @Test
    public void testUpdateMonsters(){
        //Arrange
        Monster testMonster = new Monster("Test Monster 1", MonsterType.LIZARDMAN, 15, "Humans");
        Monster testMonster2 = new Monster("Test Monster 2", MonsterType.YETI, 12, "Humans");
        Monster testMonster3 = new Monster("Test Monster 3", MonsterType.VAMPIRE, 23, "Humans");
        //Act
        testDao.addMonster(1, testMonster);
        testDao.addMonster(2, testMonster2);
        
        testDao.updateMonster(1, testMonster3);
        
        //Assert
        assertEquals(testDao.getMonster(1), testMonster3, "Updated ID 1 contains wrong object"); 
        assertEquals(testDao.getAllMonsters().size(), 2, "List is wrong size, should be 2");
        assertFalse(testDao.getAllMonsters().contains(testMonster));
       
        
    }
    
   
    
}
