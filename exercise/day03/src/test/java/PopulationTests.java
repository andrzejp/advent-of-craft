import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import people.Person;
import people.PetType;
import people.Population;

import static org.assertj.core.api.Assertions.assertThat;

class PopulationTests {
    public static final Person PETER = new Person("Peter", "Griffin")
            .addPet(PetType.CAT, "Tabby", 2);
    public static final Person STEWIE = new Person("Stewie", "Griffin")
            .addPet(PetType.CAT, "Dolly", 3)
            .addPet(PetType.DOG, "Brian", 9);
    public static final Person JOE = new Person("Joe", "Swanson")
            .addPet(PetType.DOG, "Spike", 4);
    public static final Person LOIS = new Person("Lois", "Griffin")
            .addPet(PetType.SNAKE, "Serpy", 1);
    public static final Person MEG = new Person("Meg", "Griffin")
            .addPet(PetType.BIRD, "Tweety", 1);
    public static final Person CHRIS = new Person("Chris", "Griffin")
            .addPet(PetType.TURTLE, "Speedy", 4);
    public static final Person CLEVELAND = new Person("Cleveland", "Brown")
            .addPet(PetType.HAMSTER, "Fuzzy", 1)
            .addPet(PetType.HAMSTER, "Wuzzy", 2);
    public static final Person GLENN = new Person("Glenn", "Quagmire");

    private final Population population = new Population();

    @BeforeEach
    void setup() {
        population.addPeople(PETER, STEWIE, JOE, LOIS, MEG, CHRIS, CLEVELAND, GLENN);
    }

    @Test
    void whoOwnsTheYoungestPet() {
        var filtered = population.personWithYoungestPet();
        assertThat(filtered)
                .isPresent()
                .contains(LOIS);
    }
}
