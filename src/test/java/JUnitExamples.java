import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Here is before all()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Here is before each()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    Here is after each()");
    }

    @Test
    void firstTest() {
        System.out.println("        Here is first test()");
    }

    @Test
    void secondTest() {
        System.out.println("        Here is second test()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Here is after all()");
    }
}
