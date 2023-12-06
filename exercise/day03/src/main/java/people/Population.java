package people;

import java.util.Comparator;
import java.util.List;

public class Population {
    private List<Person> people;

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Person personWithYoungestPet() {
        return people.stream()
                .min(Comparator.comparingInt(Person::youngestPet))
                .orElse(null);
    }
}