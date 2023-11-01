public class LinearEquation {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public String lineInfo() {
        return "Linear Equation: " + equation() + "\nSlope: " + slope() + "\nY-Intercept: " + roundedToHundredth(yIntercept()) + "\nDistance between the points: " + roundedToHundredth(distance());
    }

    private double distance() {
        int diffX = x2 - x1;
        int diffY = y2 - y1;
        double powX = Math.pow(diffX,2);
        double powY = Math.pow(diffY,2);
        double sum = powX + powY;
        return Math.sqrt(sum);
    }

    private String slope() {
        double diffY = y2 - y1;
        double diffX = x2 - x1;
        if (diffY % diffX == 0) {
            return "" + (int) (diffY/diffX);
        } else if (diffY/diffX == 1) {
            return "1";
        } else if (diffY/diffX == -1) {
            return "-1";
        } else if ((diffY < 0 && diffX < 0) || (diffY > 0 && diffX < 0)) {
            return (int) -diffY + "/" + (int) -diffX;
        } else if (diffY == 0) {
            return "0";
        } else {
            return (int) diffY + "/" + (int) diffX;
        }
    }

    private double yIntercept() {
        int diffY = y2 - y1;
        int diffX = x2 - x1;
        double slope = (double) diffY/diffX;
        if (y1 == x1 * slope) {
            return 0;
        } else {
            return y1 - x1 * slope;
        }
    }

    private String equation() {
        String equation = "";
        if (slope().equals("-1") && yIntercept() < 0) {
            equation = "y = -x " + yIntercept();
        } else if (slope().equals("-1") && yIntercept() > 0) {
            equation = "y = -x + " + yIntercept();
        } else if (slope().equals("1") && yIntercept() < 0) {
            equation = "y = x " + yIntercept();
        } else if (slope().equals("1") && yIntercept() > 0) {
            equation = "y = x + " + yIntercept();
        } else if (slope().equals("0")) {
            equation = "y = " + yIntercept();
        } else if (slope().equals("-1") && yIntercept() == 0) {
            equation = "y = -x ";
        } else if (slope().equals("1") && yIntercept() == 0) {
            equation = "y = x ";
        } else if (yIntercept() > 0) {
            equation = "y = " + slope() + "x + " + yIntercept();
        } else if (yIntercept() < 0) {
            equation = "y = " + slope() + "x " + yIntercept();
        } else if (yIntercept() == 0) {
            equation = "y = " + slope() + "x";
        }
        return equation;
    }

    public String coordinateForX(double x) {
        double diffY = y2 - y1;
        int diffX = x2 - x1;
        double slope = diffY/diffX;
        return String.format("%.2f",x * slope + yIntercept());
    }

    private String roundedToHundredth(double toRound) {
        return String.format("%.2f",toRound);
    }

}