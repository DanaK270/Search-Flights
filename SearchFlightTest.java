import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class SearchFlightTest {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    //test availableDest method:

    // TC1: when destination is available
    @Test
    void testAvailableDest() {
        assertTrue(SearchFlight.availableDest("amman"));
    }

    // TC2: when destination is unavailable
    @Test
    public void testUnavailableDest() {
        assertFalse(SearchFlight.availableDest("ankara"));
    }


    //test availableFlights method:

    // TC3: when the destination has available flights
    @Test
    public void testAvailableFlights() {
        SearchFlight.initializeFlightData();
        String[][] flights = SearchFlight.availableFlights("Dubai");
        int flightsNum=flights.length;
        assertEquals(3, flightsNum );
    }

    // TC4: when the destination does not have available flights
    @Test
    public void testUnavailableFlights() {
        String[][] flights = SearchFlight.availableFlights("New York");
        assertEquals(0, flights.length);
    }


    //test testIsValidInput method:

    // TC5: When the user input only letters in both cases in a valid length (valid input)
    @Test
    public void testIsValidInput_letters() {

        assertTrue(SearchFlight.isValidInput("AbcDef"));
    }

    // TC6: When the user input only letters, dots and whitespaces in a valid length (valid input)
    @Test
    public void testIsValidInput_dots() {

        assertTrue(SearchFlight.isValidInput("S. sudan"));
    }

    // TC7: When the user input numbers in a valid length(invalid input)
    @Test
    public void testIsValidInput_Numbers() {

        assertFalse(SearchFlight.isValidInput("123"));
    }

    // TC8: When the user input special characters in a valid length(invalid input)
    @Test
    public void testIsValidInput_SpecialCharacters() {

        assertFalse(SearchFlight.isValidInput("d_&"));
    }

    // TC9: When the user input valid characters but in an invalid length(invalid input)
    @Test
    public void testIsValidInput_short() {

        assertFalse(SearchFlight.isValidInput("d"));
    }

    // TC10: When the user input valid characters but in an invalid length(invalid input)
    @Test
    public void testIsValidInput_long() {

        assertFalse(SearchFlight.isValidInput("dhhhbbnbnbhfishjgkojdghngmlfphhffjfj"));
    }

    // TC11: When the user input invalid characters in an invalid length(invalid input)
    @Test
    public void testIsValidInput_ShortAndNumbers() {

        assertFalse(SearchFlight.isValidInput("5"));
    }



}