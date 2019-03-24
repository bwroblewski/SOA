public class sda {
    private static sda ourInstance = new sda();

    public static sda getInstance() {
        return ourInstance;
    }

    private sda() {
    }
}
