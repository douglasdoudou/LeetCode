package test;

import beans.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest {
    @Test
    public void vectorTest(){
        Vector vector = new Vector();
        Person beirut = new Person("beirut", "alibaba", 24);
        vector.add(beirut);
        vector.add("i am a string");
        vector.add(44);
        Iterator vectorIterator = vector.iterator();
        while(vectorIterator.hasNext()){
            System.out.println(vectorIterator.next());
        }
    }

    @Test
    public void arrayListTest(){
        List list = new ArrayList();
        list.add(new Person("beirut", "alibaba", 24));
        list.add("i am a string");
        list.add(88);
        for(Object one : list){
            System.out.println(one);
        }
    }
}
