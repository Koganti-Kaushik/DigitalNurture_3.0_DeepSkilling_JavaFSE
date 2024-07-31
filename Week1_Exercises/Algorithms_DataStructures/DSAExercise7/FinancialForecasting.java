package DSAExercise7;

public class FinancialForecasting {

    public double recursionForecast(double principalAmount, double annualReturnRate, int numYears) {
        if (numYears == 0) {
            return principalAmount;
        }
        return recursionForecast(principalAmount * (1 + annualReturnRate), annualReturnRate, numYears - 1);
    }

    public double iterativeForecast(double principalAmount, double annualReturnRate, int numYears) {
        double projectedValue = principalAmount;
        for (int year = 0; year < numYears; year++) {
            projectedValue *= (1 + annualReturnRate);
        }
        return projectedValue;
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();
        double principalAmount = 5000;
        double annualReturnRate = 0.07;
        int numYears = 15;

        double forecastValueRecursive = forecasting.recursionForecast(principalAmount, annualReturnRate, numYears);
        double forecastValueIterative = forecasting.iterativeForecast(principalAmount, annualReturnRate, numYears);

        System.out.println("Forecast Value (Recursive): " + String.format("%.2f", forecastValueRecursive));
        System.out.println("Forecast Value (Iterative): " + String.format("%.2f", forecastValueIterative));
    }
}
