package studentsystem;

public class Score extends Class {
     private int score;

    public Score() {
    }

    public Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score < 0|| score >100){
            throw new NumberOutException(score + "范围有误，应该是0~100");
        }
        this.score = score;
    }

    public String toString() {
        return "Score{score = " + score + "}";
    }
}
