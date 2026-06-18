class Solution {
    public double angleClock(int hour, int minutes) {
        double hrAngle = 30 * ( hour%12) + 0.5*minutes;
        double minAngle = 6*minutes;
        double diff = Math.abs(hrAngle - minAngle);
        return Math.min(diff , 360 -diff);
    }
}