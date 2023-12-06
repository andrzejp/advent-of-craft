import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import people.Person;
import people.PetType;
import people.Population;

import static org.assertj.core.api.Assertions.assertThat;

class PopulationTests {
    public static final Person PETER = Person.named("Peter", "Griffin")
            .addPet(PetType.CAT, "Tabby", 2);
    public static final Person STEWIE = Person.named("Stewie", "Griffin")
            .addPet(PetType.CAT, "Dolly", 3)
            .addPet(PetType.DOG, "Brian", 9);
    public static final Person JOE = Person.named("Joe", "Swanson")
            .addPet(PetType.DOG, "Spike", 4);
    public static final Person LOIS = Person.named("Lois", "Griffin")
            .addPet(PetType.SNAKE, "Serpy", 1);
    public static final Person MEG = Person.named("Meg", "Griffin")
            .addPet(PetType.BIRD, "Tweety", 1);
    public static final Person CHRIS = Person.named("Chris", "Griffin")
            .addPet(PetType.TURTLE, "Speedy", 4);
    public static final Person CLEVELAND = Person.named("Cleveland", "Brown")
            .addPet(PetType.HAMSTER, "Fuzzy", 1)
            .addPet(PetType.HAMSTER, "Wuzzy", 2);
    public static final Person GLENN = Person.named("Glenn", "Quagmire");
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
