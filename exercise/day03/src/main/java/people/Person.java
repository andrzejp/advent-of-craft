package people;

import java.util.ArrayList;
import java.util.List;

public record Person(String firstName, String lastName, List<Pet> pets) {
    private Person(String firstName, String lastName) {
        this(firstName, lastName, new ArrayList<>());
    }

    public static Person named(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }

    public Person withPet(PetType petType, String name, int age) {
        pets.add(new Pet(petType, name, age));
        return this;
    }

    public int youngestPet() {
        return pets()
                .stream()
                .mapToInt(Pet::age)
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}
