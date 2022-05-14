public class Team {

    // team attributes
    private String teamName;
    private int quarterScore;
    private int halfScore;
    private int gameScore;

    //default constructor
    public Team() {
        super();
    }

    //parameterized constructor
    public Team(String teamName, int quarterScore, int halfScore, int gameScore) {
        super();
        this.teamName = teamName;
        this.quarterScore = quarterScore;
        this.halfScore = halfScore;
        this.gameScore = gameScore;
    }

    //getter and setters
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getQuarterScore() {
        return quarterScore;
    }

    public void setQuarterScore(int quarterScore) {
        this.quarterScore = quarterScore;
    }

    public int getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(int halfScore) {
        this.halfScore = halfScore;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    //to string to print
    @Override
    public String toString() {
        return (
                "Team [teamName=" +
                        teamName +
                        ", quarterScore=" +
                        quarterScore +
                        ", halfScore=" +
                        halfScore +
                        ", gameScore=" +
                        gameScore +
                        "]"
        );
    }
}

