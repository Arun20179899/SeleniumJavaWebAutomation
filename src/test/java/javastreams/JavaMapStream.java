package javastreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class JavaMapStream {
    @Test
    public void mapBasics() {
        // Print names which have last letter "a" with UpperCase and print only first name
        Stream.of("Aradya", "Bhakta", "Kesari", "Book", "Kempa", "Suhas")
                .filter(s -> s.endsWith("a"))
                .sorted()
                .map(s -> s.toUpperCase())
                .limit(1)
                .forEach(s -> System.out.println(s));

        //print names which have first letter as a with uppercase and sorted

        String[] vegetables = {"Tomotto", "Banana", "Betroot", "Onion", "Leaves", "Beans"};
        List<String> arrVege = Arrays.asList(vegetables);
        arrVege.stream().filter(s -> s.startsWith("B")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

    }

    @Test
    public void mapAdv() {
        // Merging Two lists into one stream
        ArrayList<String> elctronicItems = new ArrayList<String>();
        elctronicItems.add("Watch");
        elctronicItems.add("Laptop");
        elctronicItems.add("Washing Machine");
        elctronicItems.add("Water Purifier");
        elctronicItems.add("Headphone");

        List<String> kitchenItems = new ArrayList<String>();
        kitchenItems.add("Plate");
        kitchenItems.add("Sink");
        kitchenItems.add("Stove");
        kitchenItems.add("Gas Cylinder");
        kitchenItems.add("Fridge");

        Stream<String> newStream = Stream.concat(elctronicItems.stream(), kitchenItems.stream()); // creating one stream by combining two lists
//        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("sink"));
//        Assert.assertTrue(flag);
        newStream.sorted().map(s->s.toUpperCase()).forEach(d-> System.out.println(d));

    }
    @Test
    public void streamCollect(){
        List<String> kitchenItems = new ArrayList<String>();
        kitchenItems.add("Plate");
        kitchenItems.add("Sink");
        kitchenItems.add("Stove");
        kitchenItems.add("Gas Cylinder");
        kitchenItems.add("Fridge");

        List<String> ls = kitchenItems.stream().map(s->s.toUpperCase()).sorted().collect(Collectors.toList());
        System.out.println(ls.get(0));
    }

    @Test
    public void streamwithNum(){
        int[] arr = {1,4,3,6,4,5,8,2,3,6,4,9,8,7,5,1,87,54,23,11,3,5,};
        //Print the unique numbers
        List<int[]> num = Arrays.asList(arr);
        List<int[]> li =  num.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }
}
