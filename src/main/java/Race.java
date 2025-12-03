public class Race {
    private String leaderName = "";
    private int leaderDistance = 0;
    private static final int RACE_TIME = 24;

    public void updateLeader(Car car) {
        int distance = car.getSpeed() * RACE_TIME;
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.getName();
        }
    }
}
