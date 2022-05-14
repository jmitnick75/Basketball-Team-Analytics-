public class BasketballGame{

    // game attributes
    private String gameName;
    private Team team;
    private Team opponent;

    // default constructor
    public BasketballGame() {
        super();
    }

    // parameterized constructor
    public BasketballGame(String gameName, Team team, Team opponent) {
        super();
        this.gameName = gameName;
        this.team = team;
        this.opponent = opponent;
    }

    // getter and setters
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getOpponent() {
        return opponent;
    }

    public void setOpponent(Team opponent) {
        this.opponent = opponent;
    }

    // to string to print
    @Override
    public String toString() {
        return (
                "Basketball Game [gameName=" +
                        gameName +
                        ", team=" +
                        team +
                        ", opponent=" +
                        opponent +
                        "]"
        );
    }
}
