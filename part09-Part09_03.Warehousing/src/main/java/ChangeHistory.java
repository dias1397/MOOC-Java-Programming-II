
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class ChangeHistory {
 
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<Double>();
    }
    
    public void add(double status) {
        history.add(status);
    }
    
    public void clear() {
        history.clear();
    }
    
    public double maxValue() {
        double max = 0;
        for (double d : this.history) {
            if (d >= max) {
                max = d;
            }
        }
        return max;
    }
    
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double min = Double.POSITIVE_INFINITY;
        for (double d : this.history) {
            if (d <= min) {
                min = d;
            }
        }
        return min;
    }
    
    public double average() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double d : this.history) {
            sum += d;
        }
        return sum / this.history.size();
    }

    @Override
    public String toString() {
        return this.history.toString();
    }
    
}
