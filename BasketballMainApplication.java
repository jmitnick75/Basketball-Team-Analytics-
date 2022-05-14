//Jon Mitnick
//ITN-261-2W1
//Final Project
//April 27, 2022

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class BasketballMainApplication {

    static String optionNumber;

    // menu printing method
    public static String menu() {
        return (
                optionNumber =
                        JOptionPane.showInputDialog(
                                "Please select an option Number : \n" +
                                        "1 : Add Basketball Game\n" +
                                        "2 : Edit Game Score\n" +
                                        "3 : Show Report\n" +
                                        "4 : Save Report\n" +
                                        "5 : Exit"
                        )
        );
    }

    // main method calls menu method
    public static void main(String[] args) {
        List<BasketballGame> gameList = new ArrayList<BasketballGame>();
        String Report = "";
        // loop till exit is selected
        while (true) {
            optionNumber = menu();
            if (optionNumber.equals("5")) {
                System.exit(0);
            }
            // switch condition depending on the option selected
            switch (optionNumber) {
                case "1":
                    BasketballGame game = new BasketballGame();
                    game.setGameName(
                            JOptionPane.showInputDialog("Enter Game season Name : ")
                    );
                    String teamName = JOptionPane.showInputDialog("Enter Team Name");
                    int quarterScore = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter Quarter Score")
                    );
                    int halfScore = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter Half Score")
                    );
                    int gameScore = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter Final Game Score")
                    );
                    game.setTeam(new Team(teamName, quarterScore, halfScore, gameScore));
                    String opponentName = JOptionPane.showInputDialog(
                            "Enter Opponent Name"
                    );
                    int quarterScoreO = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter Opponent Quarter Score")
                    );
                    int halfScoreO = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter Opponent Half Score")
                    );
                    int gameScoreO = Integer.parseInt(
                            JOptionPane.showInputDialog("Enter Opponent Final Game Score")
                    );
                    game.setOpponent(
                            new Team(opponentName, quarterScoreO, halfScoreO, gameScoreO)
                    );
                    gameList.add(game);
                    break;
                case "2":
                    String gameName = JOptionPane.showInputDialog(
                            "Enter Game season Name to be edited : "
                    );
                    for (BasketballGame g : gameList) {
                        if (g.getGameName().equals(gameName)) {
                            String teamNameEdit = JOptionPane.showInputDialog(
                                    "Enter Team/Opponent Name"
                            );
                            if (g.getTeam().getTeamName().equals(teamNameEdit)) {
                                int quarterScoreEdit = Integer.parseInt(
                                        JOptionPane.showInputDialog("Enter New Quarter Score")
                                );
                                int halfScoreEdit = Integer.parseInt(
                                        JOptionPane.showInputDialog("Enter New Half Score")
                                );
                                int gameScoreEdit = Integer.parseInt(
                                        JOptionPane.showInputDialog("Enter New Final Game Score")
                                );
                                g.setTeam(
                                        new Team(
                                                teamNameEdit,
                                                quarterScoreEdit,
                                                halfScoreEdit,
                                                gameScoreEdit
                                        )
                                );
                            } else if (g.getOpponent().getTeamName().equals(teamNameEdit)) {
                                int quarterScoreEdit = Integer.parseInt(
                                        JOptionPane.showInputDialog("Enter New Quarter Score")
                                );
                                int halfScoreEdit = Integer.parseInt(
                                        JOptionPane.showInputDialog("Enter New Half Score")
                                );
                                int gameScoreEdit = Integer.parseInt(
                                        JOptionPane.showInputDialog("Enter New Final Game Score")
                                );
                                g.setOpponent(
                                        new Team(
                                                teamNameEdit,
                                                quarterScoreEdit,
                                                halfScoreEdit,
                                                gameScoreEdit
                                        )
                                );
                            }
                        }
                    }

                    break;
                case "3":
                    JOptionPane.showMessageDialog(
                            null,
                            "Report is displayed in the Console."
                    );
                    for (BasketballGame g : gameList) {
                        Report =
                                "Game Name : " +
                                        g.getGameName() +
                                        "\n" +
                                        "Team Name : " +
                                        g.getTeam().getTeamName() +
                                        "\n" +
                                        "Team Quarter Score : " +
                                        g.getTeam().getQuarterScore() +
                                        "\n" +
                                        "Team Half Score : " +
                                        g.getTeam().getHalfScore() +
                                        "\n" +
                                        "Team Final Game Score : " +
                                        g.getTeam().getGameScore() +
                                        "\n" +
                                        "Opponent Name : " +
                                        g.getOpponent().getTeamName() +
                                        "\n" +
                                        "Opponent Quarter Score : " +
                                        g.getOpponent().getQuarterScore() +
                                        "\n" +
                                        "Opponent Half Score : " +
                                        g.getOpponent().getHalfScore() +
                                        "\n" +
                                        "Opponent Final Game Score : " +
                                        g.getOpponent().getGameScore() +
                                        "\n";
                    }
                    Report =
                            Report +
                                    "Average points per Quarter : " +
                                    getTeamAverageQuarterScore(gameList) +
                                    "\n" +
                                    "Average points per Half : " +
                                    getTeamAverageHalfScore(gameList) +
                                    "\n" +
                                    "Average points per Game : " +
                                    getTeamAverageGameScore(gameList) +
                                    "\n" +
                                    "Average Difference of points per Quarter : " +
                                    getTeamDifferentialQuarterScore(gameList) +
                                    "\n" +
                                    "Average Difference of points per Half : " +
                                    getTeamDifferentialHAlfScore(gameList) +
                                    "\n" +
                                    "Average Difference of points per Game : " +
                                    getTeamDifferentialGameScore(gameList) +
                                    "\n" +
                                    "Lowest points scored per Quarter : " +
                                    getTeamMinScore(gameList) +
                                    "\n" +
                                    "Highest points scored per Quarter : " +
                                    getTeamHighestScore(gameList) +
                                    "\n";
                    System.out.println(Report);
                    break;
                case "4":
                    // get file name
                    String fileName = JOptionPane.showInputDialog(
                            "Enter file name to save report : "
                    );

                    // write to file
                    File myObj = new File(fileName);
                    PrintWriter pw;
                    try {
                        pw = new PrintWriter(new FileWriter(myObj.getName(), true));
                        pw.write(Report);
                        pw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Successfully wrote to file.");

                    break;
            }
        }
    }

    // ,method to get Team Differential Game Score
    private static float getTeamDifferentialGameScore(
            List<BasketballGame > gameList
    ) {
        int[] gameScore = new int[gameList.size()];
        int diffGame = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            gameScore[index] =
                    Math.abs(g.getTeam().getGameScore() - g.getOpponent().getGameScore());
            index++;
        }
        for (int i = 0; i < gameScore.length; i++) {
            diffGame += gameScore[i];
        }
        return diffGame / gameScore.length;
    }

    // method to get Team Differential HAlf Score
    private static float getTeamDifferentialHAlfScore(
            List<BasketballGame> gameList
    ) {
        int[] halfScore = new int[gameList.size()];
        int diffHAlf = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            halfScore[index] =
                    Math.abs(g.getTeam().getHalfScore() - g.getOpponent().getHalfScore());
            index++;
        }
        for (int i = 0; i < halfScore.length; i++) {
            diffHAlf += halfScore[i];
        }
        return diffHAlf / halfScore.length;
    }

    // method to get Team Differential Quarter Score
    private static float getTeamDifferentialQuarterScore(
            List<BasketballGame> gameList
    ) {
        int[] quarterScore = new int[gameList.size()];
        int diffQuarter = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            quarterScore[index] =
                    Math.abs(
                            g.getTeam().getQuarterScore() - g.getOpponent().getQuarterScore()
                    );
            index++;
        }
        for (int i = 0; i < quarterScore.length; i++) {
            diffQuarter += quarterScore[i];
        }
        return diffQuarter / quarterScore.length;
    }

    // method to get Team Average Game Score
    private static float getTeamAverageGameScore(List<BasketballGame> gameList) {
        int[] gameScore = new int[gameList.size()];
        int sumGame = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            gameScore[index] = g.getTeam().getGameScore();
            index++;
        }
        for (int i = 0; i < gameScore.length; i++) {
            sumGame += gameScore[i];
        }
        return sumGame / gameScore.length;
    }

    // method to get Team Average Half Score
    private static float getTeamAverageHalfScore(List<BasketballGame> gameList) {
        int[] halfScore = new int[gameList.size()];
        int sumHAlf = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            halfScore[index] = g.getTeam().getHalfScore();
            index++;
        }
        for (int i = 0; i < halfScore.length; i++) {
            sumHAlf += halfScore[i];
        }
        return sumHAlf / halfScore.length;
    }

    // method to get Team Average Quarter Score
    public static float getTeamAverageQuarterScore(List<BasketballGame> gameList) {
        int[] quarterScore = new int[gameList.size()];
        int sumQuarter = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            quarterScore[index] = g.getTeam().getQuarterScore();
            index++;
        }
        for (int i = 0; i < quarterScore.length; i++) {
            sumQuarter += quarterScore[i];
        }
        return sumQuarter / quarterScore.length;
    }

    // method to get Team Minimum Score
    public static int getTeamMinScore(List<BasketballGame> gameList) {
        int[] gameScore = new int[gameList.size()];
        int minScore = 100000;
        int index = 0;
        for (BasketballGame g : gameList) {
            gameScore[index] = g.getTeam().getGameScore();
            index++;
        }
        for (int i = 0; i < gameScore.length; i++) {
            if (gameScore[i] < minScore) {
                minScore = gameScore[i];
                index++;
            }
        }
        return minScore;
    }

    // method to get Team Highest Score
    public static int getTeamHighestScore(List<BasketballGame> gameList) {
        int[] gameScore = new int[gameList.size()];
        int highestScore = 0;
        int index = 0;
        for (BasketballGame g : gameList) {
            gameScore[index] = g.getTeam().getGameScore();
        }
        for (int i = 0; i < gameScore.length; i++) {
            if (gameScore[i] > highestScore) {
                highestScore = gameScore[i];
            }
        }
        return highestScore;
    }
}
