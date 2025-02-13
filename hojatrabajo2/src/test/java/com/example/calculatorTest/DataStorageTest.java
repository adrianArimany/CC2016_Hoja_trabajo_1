package com.example.calculatorTest;

import java.io.File;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.data_manager.DataStorage;
import com.example.utils.Logger;


/**
 * @TODO
 * 
 * 1. Add null pointer exeption to createDirectory
 * 
 * 2. fix bug in case that has an empty path.
 * 
 * 3. fix bug in case that the path is not a directory in createNewFile()
 */

public class DataStorageTest {

    private static final String TEST_DIR = "test_dir";
    private static final String TEST_DIR_PATH = System.getProperty("user.dir") + File.separator + TEST_DIR;

    @Before
    public void setup() {
        // Create a mock logger to avoid logging during tests
        Logger log = mock(Logger.class);
        DataStorage.log = log;
    }

    @After
    public void cleanup() {
        // Delete the test directory if it exists
        File testDir = new File(TEST_DIR_PATH);
        if (testDir.exists()) {
            testDir.delete();
        }
    }

    

    @Test
    public void testCreateDirectory_DirectoryAlreadyExists() {
        // Arrange
        File directory = new File(TEST_DIR_PATH);
        directory.mkdirs();

        // Act
        DataStorage.createDirectory(TEST_DIR_PATH);

        // Assert
        assertTrue(directory.exists());
        verify(DataStorage.log).logSevere("Failed to create directory: " + TEST_DIR_PATH);
    }

    @Test
    public void testCreateDirectory_NullPath() {
        // Act and Assert
        try {
            DataStorage.createDirectory(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Expected
        }
    }

    @Test
    public void testCreateDirectory_EmptyPath() {
        // Act and Assert
        try {
            DataStorage.createDirectory("");
            fail("Expected java.lang.AssertionError at com.example.calculatorTest.DataStorageTest.testCreateDirectory_EmptyPath(DataStorageTest.java:79)");
        } catch (java.lang.AssertionError e) {
            // Expected
        }
    }

}