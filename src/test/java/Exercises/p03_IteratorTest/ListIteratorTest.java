package Exercises.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] NAMES = {"Pesho", "Gosho", "Tosho"};

    @Before
    public void setListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructor_Throwing_Error_On_Input_Null() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void constructor_Assigning_Inputs_To_ArrayElements() throws OperationNotSupportedException {
        new ListIterator(NAMES);
    }

    @Test
    public void hasNext_Checking_If_Next_Element_Exists() {
        for (int i = 0; i < NAMES.length ; i++) {
            if(i < (NAMES.length - 1)) {
                Assert.assertTrue(listIterator.hasNext());
                listIterator.move();
            } else {
                Assert.assertFalse(listIterator.hasNext());
            }
        }
    }

    @Test
    public void move_Moving_Element_In_Array_ToThe_Next_Index_If_Has_Next_Index() {
        for (int i = 0; i < NAMES.length ; i++) {
            if(i < (NAMES.length - 1)) {
                Assert.assertTrue(listIterator.move());
            } else {
                Assert.assertFalse(listIterator.hasNext());
            }
        }
    }

    @Test(expected = IllegalStateException.class)
    public void print_Throwing_Error_When_Iterator_Empty() throws IllegalStateException, OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }

    @Test
    public void print_The_Element_On_Current_Index() {
        Assert.assertEquals(NAMES[0], listIterator.print());
        listIterator.move();
        Assert.assertEquals(NAMES[1], listIterator.print());
    }
}