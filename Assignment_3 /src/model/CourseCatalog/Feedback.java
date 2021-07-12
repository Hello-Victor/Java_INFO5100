/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseCatalog;

/**
 *
 * @author aeloyq
 */
public class Feedback {

    int freshLevelRate;
    int industryTrendsAlignmentRate;
    int overallRate;
    

    public Feedback() {
    }

    public Feedback(int freshLevelRate, int industryTrendsAlignmentRate, int overallRate) {
        this.freshLevelRate = freshLevelRate;
        this.industryTrendsAlignmentRate = industryTrendsAlignmentRate;
        this.overallRate = overallRate;
    }

    public int getFreshLevelRate() {
        return freshLevelRate;
    }

    public void setFreshLevelRate(int freshLevelRate) {
        this.freshLevelRate = freshLevelRate;
    }

    public int getIndustryTrendsAlignmentRate() {
        return industryTrendsAlignmentRate;
    }

    public void setIndustryTrendsAlignmentRate(int industryTrendsAlignmentRate) {
        this.industryTrendsAlignmentRate = industryTrendsAlignmentRate;
    }

    public int getOverallRate() {
        return overallRate;
    }

    public void setOverallRate(int overallRate) {
        this.overallRate = overallRate;
    }

    public double getScore() {
        return freshLevelRate * 0.25 + industryTrendsAlignmentRate * 0.25 + overallRate * 0.5;
    }
}
