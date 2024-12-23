package split;

public class PercentSplit extends Split {
    private double percentage;

    public PercentSplit(Integer userId, double percentage) {
        super(userId);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return this.percentage;
    }
}
