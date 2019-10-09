import javax.naming.ServiceUnavailableException;

enum Day {MON, TUES, WEND, THU, FRI}
public class EnumDem {
    public static void main(String[] args) {
        /**
         * Init enum Type
         */
        Day today;
        today = Day.FRI;

        switch (today) {
            case THU:
            case TUES:
                System.out.println("These days start with 'T'");
                break;
            case WEND:
                System.out.println("ITS WEDNESDAY");
                break;
            case FRI:
                System.out.println("FRIDAY");
                break;
            default:
                System.out.println("this is a default val, scrub.");
        }

    }
}
