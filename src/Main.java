import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        System.out.println(persons.stream().filter(person -> person.getAge() < 18).count());
        List<String> recruit = persons.stream()
                .filter(person -> person.getAge() == 18 && person.getAge() <= 27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());

        recruit.stream().forEach(System.out::println);

        List<String> workablePeople = persons.stream()
                .filter(person -> person.getAge() == 18 && person.getAge() <= 60 && person.getSex() == Sex.WOMAN)
                .filter(person -> person.getAge() == 18 && person.getAge() <= 65 && person.getSex() == Sex.MAN)
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .map(person -> person.getFamily())
                .collect(Collectors.toList());

    }
}
