package people;

import java.util.Comparator;
import java.util.List;

public class Population {
    public List<Person> population;

    public List<Person> getPopulation() {
        return population;
    }

    public void setPopulation(List<Person> population) {
        this.population = population;
    }

    public Population() {
    }

    public Person personWithYoungestPet() {
        return population.stream()
                .min(Comparator.comparingInt(Person::youngestPet))
                .orElse(null);
    }
}