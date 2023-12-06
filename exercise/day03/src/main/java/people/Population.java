package people;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Population {
    private List<Person> people;

    public void addPeople(Person... people) {
        this.people = List.of(people);
    }

    public Optional<Person> personWithYoungestPet() {
        return people.stream()
                .min(Comparator.comparingInt(Person::youngestPet));
    }
}