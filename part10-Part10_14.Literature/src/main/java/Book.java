/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dias97
 */
public class Book {
    
    private String title;
    private int ageRecommendation;

    public Book(String title, int ageRecommendation) {
        this.title = title;
        this.ageRecommendation = ageRecommendation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    public void setAgeRecommendation(int ageRecommendation) {
        this.ageRecommendation = ageRecommendation;
    }

    @Override
    public String toString() {
        return title + " (recommended for " + ageRecommendation + " year-olds or older)";
    }
    
    
    
}
