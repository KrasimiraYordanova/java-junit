package Exercises.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] INPUT = {7, 3, 6, 8};
    @Before
    public void setDatabase() throws OperationNotSupportedException {
        this.database = new Database(INPUT);
    }
    @Test
    public void constructor_Creating_Valid_DB() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();

        // for (int i = 0; i < elements.length; i++) {
            // Assert.assertEquals(elements[i], input[i]);
        // }
        Assert.assertArrayEquals(INPUT, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructor_Create_Invalid_DB_Throwing_Error_MoreThan_16_Elements() throws OperationNotSupportedException {
        // Integer[] input = {7, 3, 6, 8, 6, 4, 5, 8, 56, 45, 20, 18, 64, 22, 37, 96, 73};
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructor_Create_Invalid_DB_Throwing_Error_Zero_Elements() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void add_On_Null_Element_Throwing_Error() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void add_Successful_Element_Insertion() throws OperationNotSupportedException {
        database.add(42);

        Integer[] dbElements = database.getElements();

        Assert.assertEquals(INPUT.length + 1, dbElements.length);
        Assert.assertEquals(dbElements[dbElements.length - 1], Integer.valueOf(42));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void remove_Throwing_Error_With_Empty_Database() throws OperationNotSupportedException {
        for (int i = 0; i < INPUT.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void remove_Element_From_Elements_Success() throws OperationNotSupportedException {
        Integer[] dbElementsBeforeRemove = database.getElements();

        database.remove();
        Integer[] dbElementsAfterRemove = database.getElements();

        Assert.assertEquals(dbElementsBeforeRemove.length - 1, dbElementsAfterRemove.length);
        Assert.assertEquals(dbElementsBeforeRemove[dbElementsBeforeRemove.length - 1 - 1], dbElementsAfterRemove[dbElementsAfterRemove.length - 1]);
    }
}
