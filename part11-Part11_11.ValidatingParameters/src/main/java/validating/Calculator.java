package validating;

public class Calculator {

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if (subsetSize > setSize) {
            throw new IllegalArgumentException("Subset size cannot be greater than set size");
        }
        
        if (setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("Sizes must be non-negative numbers");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
