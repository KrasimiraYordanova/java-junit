package Exercises.p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    CustomLinkedList<String> list;

    @Before
    public void setList() {
        list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Gosho");
        list.add("Tosho");
    }

    @Test
    public void add_Should_Add_New_Element() {
        int previousSize = list.getCount();
        list.add("Ivan");
        int currentSize = list.getCount();
        Assert.assertEquals(previousSize + 1, currentSize);
        Assert.assertEquals(list.getCount() - 1, list.indexOf("Ivan"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void get_Throwing_Error_When_Negative_Index() {
        list.get(-2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void get_Throwing_Error_When_Big_Index() {
        list.get(list.getCount() + 1);
    }

    @Test
    public void get_Getting_The_Element() {
        Assert.assertEquals("Gosho", list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_Throwing_Error_When_Negative_Index() {
        list.set(-2, "Toshko");
    }
    @Test(expected = IllegalArgumentException.class)
    public void set_Throwing_Error_When_Big_Index() {
        list.set(list.getCount() + 1, "Ivan");
    }

    @Test
    public void set_Setting_The_Element() {
        list.set(1, "Grisho");
        Assert.assertEquals("Grisho", list.get(1));
    }
}