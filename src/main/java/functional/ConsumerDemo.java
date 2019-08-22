package functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerDemo {

    // Problem Statement :- Print the content of the list using functional programming.
    // We have to apply print method on every element of the list.


    // Solution :- Since we are going to apply a method on every element of the list,
    // This method should print the passed input element.

    public <T> void printList(List<T> elements, Consumer<T> consumer){
        elements.forEach(e-> consumer.accept(e));
    }

    public <T> void printLine(T e){
        System.out.println(e);
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Jai Ganesh", "Jai Hanuman", "Jai Shri Ram",
        "Jai Shiv Shankar","Jai Mata Di", "Jai Mahalaxmi", "Jai Maa Saraswati","Jai Maha Vishnu","Jai GuruDev", "Jai BrahmDev");

        ConsumerDemo demo = new ConsumerDemo();
        demo.printList(stringList,e-> demo.printLine(e));
        //demo.printList(stringList,ConsumerDemo::printLine);


    }

    /*public <T> void printListThoughBiConsumer(List<T> elements, BiConsumer<ConsumerDemo,T> f){
        elements.forEach(e-> f.);
    }*/
}
