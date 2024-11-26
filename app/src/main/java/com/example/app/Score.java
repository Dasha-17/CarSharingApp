package com.example.app;

public class Score {
    private String studentName;
    private String testName;
    private String score;

    public Score(String studentName, String testName, String score) {
        this.studentName = studentName;
        this.testName = testName;
        this.score = score;
    }

    public Score(String studentName) {
        this.studentName = studentName;
    }

    public Score(String testName, String score) {
        this.testName = testName;
        this.score = score;
    }

    public Score() {}

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
