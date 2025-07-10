package opt;

public class ValueError extends Error {

    private static final String[] RAINBOW = {
            "\u001B[31m", // Red
            "\u001B[33m", // Yellow/Orange
            "\u001B[32m", // Green
            "\u001B[34m", // Blue
            "\u001B[35m", // Magenta (Indigo/Violet)
            "\u001B[36m" // Cyan
    };

    private static int colorIndex = 0; // Shared static index
    private static final String RESET = "\u001B[0m";

    public ValueError(int max, int you, int run, int sim, int test, int total) {
        super(color("\n\n\nYour pick must be between ", 4) + color("1", 2) + color(" and ", 4) + color("" + max, 2)
                + color("\nYour guess was ", 4) + color("" + you, 0)
                + color("\nthis error occured on\n\n---------------", 4) + " run: " + commas(run)
                + color(" --------------- ", 4) + "sim: "
                + commas(sim) + color("  --------------- ", 4) + "test: " + commas(test) + color(" --------------- ", 4)
                + "total runs: "
                + commas(total) + color(" ---------------\n\n", 4));
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    static String rainbow(String text) {
        String colored = RAINBOW[colorIndex % RAINBOW.length] + text + RESET;
        colorIndex++;
        return colored;
    }

    static String color(String val, int index) {
        String colored = RAINBOW[index % RAINBOW.length] + val + RESET;
        return colored;
    }

    static String commas(int val) {
        return rainbow(String.format("%,d", val));
    }

}
