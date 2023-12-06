import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import people.Person;
import people.Population;

import static org.assertj.core.api.Assertions.assertThat;
import static people.PetType.*;

class PopulationTests {
    public static final Person PETER = Person.named("Peter", "Griffin")
            .withPet(CAT, "Tabby", 2);
    public static final Person STEWIE = Person.named("Stewie", "Griffin")
            .withPet(CAT, "Dolly", 3)
            .withPet(DOG, "Brian", 9);
    public static final Person JOE = Person.named("Joe", "Swanson")
            .withPet(DOG, "Spike", 4);
    public static final Person LOIS = Person.named("Lois", "Griffin")
            .withPet(SNAKE, "Serpy", 1);
    public static final Person MEG = Person.named("Meg", "Griffin")
            .withPet(BIRD, "Tweety", 1);
    public static final Person CHRIS = Person.named("Chris", "Griffin")
            .withPet(TURTLE, "Speedy", 4);
    public static final Person CLEVELAND = Person.named("Cleveland", "Brown")
            .withPet(HAMSTER, "Fuzzy", 1)
            .withPet(HAMSTER, "Wuzzy", 2);
    public static final Person GLENN = Person.named("Glenn", "Quagmire");
    private final Population population = new Population();

    @BeforeEach
    void setup() {
        population.addPeople(PETER, STEWIE, JOE, LOIS, MEG, CHRIS, CLEVELAND, GLENN);
    }

    @Test
    void whoOwnsTheYoungestPet() {
        var result = population.personWithYoungestPet();
        assertThat(result)
                .isPresent()
                .contains(LOIS);
    }
}
