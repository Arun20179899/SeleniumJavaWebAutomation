package javastreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class JavaStreamsDemo {

    @Test
    public void regular() {
        // Print the count of names with starting alphabet "A" in the list
        ArrayList<String> names = new ArrayList<String>();
        names.add("Arjun");
        names.add("Don");
        names.add("Bean");
        names.add("Adam");
        names.add("Arun");
        names.add("Kat");
        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actualName = names.get(i);
            if (actualName.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);

    }

    @Test
    public void javaStreamsFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Arjun");
        names.add("Don");
        names.add("Bean");
        names.add("Adam");
        names.add("Arun");
        names.add("Kat");

        // there is no life for intermediate opp if there is no terminal opp
        // terminal operation execute only if intermediate opp (filter) return true
        // We can create stream
        // how to use filter in Stream API
        // data type of the count() in the stream is long
        long d = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(d);

// if you are using lambda expression inside block we make sure use return statement explicitly
        long e = Stream.of("Arjun", "Don", "Bean", "Adam", "Arun", "Kat").filter(name -> {
            return name.startsWith("A");
        }).count();
        System.out.println(e);

        long f = Stream.of("Arjun", "Don", "Bean", "Adam", "Arun", "Kat").filter(name -> name.startsWith("A")).count();
        System.out.println(f);

        // print all the name which char > 4
//        names.stream().filter(value -> value.length() >= 4).forEach(val-> System.out.println(val));
        // only print first value
        names.stream().filter(value -> value.length() >= 4).limit(1).forEach(val-> System.out.println(val));


    }
}
