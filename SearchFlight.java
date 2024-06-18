import java.util.*;
public class SearchFlight {
    public static final Map<String, List<String>> flightData = new HashMap<>();
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        initializeFlightData();
        String dest="";
        System.out.println("* Welcome FDA Flight Reservation System *");
        System.out.println("Enter the destination name to search for flights (only letters, dots and spaces are allowed): ");
        dest=kbd.nextLine();

        while (!isValidInput(dest)){
           System.out.println("Invalid input, the destination name must only contain letters ");
           System.out.println("Enter another destination: ");
           dest=kbd.nextLine();
        }

        dest = dest.toLowerCase();
        if(availableDest(dest)) {

            String[][] flights;

                flights = availableFlights(dest);
                if( flights.length==0)
                    System.out.println("Sorry!! " + dest + " has no flights yet");
                else {
                    System.out.println(dest + " has the following available flights: ");
                    printFlights(flights);}

        }// end of if

        else {
            System.out.println("Sorry!! " + dest + " is not an available destination");

        }//end of else

    }//end of main



    public static boolean availableDest(String destSearched){
        String[] dests = {"Al Muharraq","Rome","New York","London","Paris","Doha","Dubai",
                "Riyadh","Kuwait","Amman","Tokyo","Bali","Istanbul","Hong Kong","Mumbai","Muscat",
                "Moscow","Singapore","Baku","Cairo","Beirut"};
        for (String d : dests) {
            if (d.trim().equalsIgnoreCase( destSearched.trim() )) {
                return true;
            }
        }
        return false;
    }

    public static String[][] availableFlights(String destSearched) {
        destSearched=destSearched.toLowerCase();
        List<String> destinationFlights = flightData.get(destSearched);
        if (destinationFlights == null) {
            return new String[0][0];
        }

        int numFlights = destinationFlights.size();
        String[][] matrix = new String[numFlights][4];

        for (int i = 0; i < numFlights; i++) {
            String flightInfo = destinationFlights.get(i);
            String[] flightDetails = flightInfo.split(",");
            for (int j = 0; j < flightDetails.length; j++) {
                matrix[i][j] = flightDetails[j];
            }
        }
        return matrix;
    }


    public static void initializeFlightData() {
        List<String> alMuharraqFlights = new ArrayList<>();
        alMuharraqFlights.add("11001,Gulf Air,2024-01-15 10:00,10");
        alMuharraqFlights.add("11002,Qatar Airlines,2024-01-16 14:30,5");
        flightData.put("al muharraq", alMuharraqFlights);

        List<String> londonFlights = new ArrayList<>();
        londonFlights.add("12001,London Airlines,2024-01-20 10:00,13");
        londonFlights.add("12002,Qatar Airlines,2024-01-17 14:30,22");
        flightData.put("london", londonFlights);

        List<String> romeFlights = new ArrayList<>();
        romeFlights.add("13001,Gulf Air,2024-02-15 13:00,14");
        romeFlights.add("13002,Gulf Air,2024-01-25 11:30,25");
        romeFlights.add("13003,Qatar Airlines,2024-01-22 14:00,42");
        flightData.put("rome", romeFlights);

        List<String> DohaFlights = new ArrayList<>();
        DohaFlights.add("14001,Qatar Airlines,2024-01-15 10:00,03");
        flightData.put("doha", DohaFlights);

        List<String> DubaiFlights = new ArrayList<>();
        DubaiFlights.add("15001,Gulf Air,2024-01-26 10:00,13");
        DubaiFlights.add("15002,Gulf Air,2024-01-16 15:30,23");
        DubaiFlights.add("15003,Qatar Airlines,2024-01-21 16:30,34");
        flightData.put("dubai", DubaiFlights);

        List<String> AmmanFlights = new ArrayList<>();
        AmmanFlights.add("16001,Gulf Air,2024-01-20 12:00,20");
        flightData.put("amman", AmmanFlights);

        List<String> IstanbulFlights = new ArrayList<>();
        IstanbulFlights.add("17001,Turkish Airlines,2024-02-02 16:00,13");
        IstanbulFlights.add("17002,Qatar Airlines,2024-01-17 14:30,27");
        flightData.put("istanbul", IstanbulFlights);

        List<String> TokyoFlights = new ArrayList<>();
        TokyoFlights.add("18001,Gulf Air,2024-01-20 12:00,20");
        flightData.put("tokyo", TokyoFlights);

    }

    public static boolean isValidInput(String destSearched){
            String dest = destSearched.trim();
            int length = destSearched.length();
            return dest.matches("[a-zA-Z. ]+") && length >= 2 && length <= 30;
    }

    public static void printFlights(String[][] flights) {
        System.out.println("Flight Number \t||\t Airlines \t||\t  Date and Time \t||\t  Number of Available Seats");
        for (String[] flight : flights) {
            for (String info : flight) {
                System.out.print(info + "\t||\t ");
            }
            System.out.println();
        }
    }
}





