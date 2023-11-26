package Exercises.p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private Person toshko = new Person(1, "Toshko");
    private Person peshko = new Person(2, "Peshko");
    private Person goshko = new Person(3, "Goshko");
    @Before
    public void setDatabase() throws OperationNotSupportedException {
        this.database = new Database(toshko, peshko, goshko);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsername_Throwing_Error_When_InputUsername_Is_Null() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsername_Throwing_Error_When_Person_Searched_Is_Missing() throws OperationNotSupportedException {
        database.findByUsername("ginka");
    }

    @Test
    public void findByUsername_Adding_Found_Person_InThe_List() throws OperationNotSupportedException {
        Person foundPerson = database.findByUsername(peshko.getUsername());
        Assert.assertEquals(peshko.getId(), foundPerson.getId());
        Assert.assertEquals(peshko.getUsername(), foundPerson.getUsername());
    }
}
