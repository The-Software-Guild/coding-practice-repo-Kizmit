/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.dvdlibrarydao;

import com.jdm.dvdlibrary.dto.Dvd;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Joe
 */
public class DvdLibraryDaoFileImplTest {
    DvdLibraryDao testDao;
    
    public DvdLibraryDaoFileImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testDvdLibrary.txt";
        
        new FileWriter(testFile);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        testDao = ctx.getBean("testDao", DvdLibraryDaoLambdaFileImpl.class);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetSearchDvd() {
        //Arrange
        Dvd testDvd = new Dvd("Test Case", "Test Director", "Test Studio", 
            "Test Note", "Test Rating", "2021-03-29");
        
        //Act
        testDao.addDvd(testDvd);
        Dvd retrievedDvd1 = testDao.getDvdInfo(testDvd.getTitle());
        Dvd retrievedDvd2 = testDao.searchForDvd(testDvd.getTitle());
        
        //Assert
        assertEquals(retrievedDvd1, testDvd, "getDvdInfo() test failed.");
        assertEquals(retrievedDvd2, testDvd, "searchForDvd() test failed.");
    }
    
    @Test
    public void testAddGetListDvd(){
        //Arrange
        Dvd testDvd1 = new Dvd("Test Case", "Test Director", "Test Studio", 
            "Test Note", "Test Rating", "2021-03-29");
        Dvd testDvd2 = new Dvd("Test Case 2", "Test Director 2", "Test Studio 2", 
            "Test Note 2", "Test Rating 2", "1996-05-25");
        
        //Act
        testDao.addDvd(testDvd1);
        testDao.addDvd(testDvd2);
        List<Dvd> dvdList = testDao.getDvdList();
        
        //Assert
        assertNotNull(dvdList, "The list is null");
        assertEquals(2, dvdList.size(), "The size is not 2");
        
        assertTrue(dvdList.contains(testDvd1), "The list doesn't contain one of the entries");
        assertTrue(dvdList.contains(testDvd2), "The list doesn't contain one of the entries");
    }
    
    @Test
    public void testRemoveDvd(){
        //Arrange
        Dvd testDvd1 = new Dvd("Test Case", "Test Director", "Test Studio", 
            "Test Note", "Test Rating", "2021-03-29");
        Dvd testDvd2 = new Dvd("Test Case 2", "Test Director 2", "Test Studio 2", 
            "Test Note 2", "Test Rating 2", "1996-05-25");
        testDao.addDvd(testDvd1);
        testDao.addDvd(testDvd2);
        
        //Act and assert
        assertEquals(testDao.getDvdList().size(), 2, "The size of the DVD List is not 2");
        Dvd removedDvd = testDao.removeDvd(testDvd1.getTitle());
        assertEquals(removedDvd, testDvd1, "The removed DVD should be testDvd1");
        assertEquals(testDao.getDvdList().size(), 1, "The size of the DVD List is not 1");
        assertTrue(testDao.getDvdList().contains(testDvd2), "The DVD list no longer contains testDvd2");
        
        
        assertEquals(testDao.removeDvd(testDvd2.getTitle()), testDvd2, "The removed DVD is not testDvd2");
        assertTrue(testDao.getDvdList().isEmpty(), "The DVD list should be empty");
        
        assertNull(testDao.removeDvd(testDvd2.getTitle()), "A removal on an empty library should be null");
    }
}
