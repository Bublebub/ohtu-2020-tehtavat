package ohtu;

public class TennisGame {
    
    private final static int NUMBER_OF_PLAYERS = 2;
    
    private int score_player_one = 0;
    private int score_player_two = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            score_player_one += 1;
        else
            score_player_two += 1;
    }

    public String getScore() {
        String output;
        
        if (score_player_one == score_player_two) output = getEqualScoreSituationOutput();
        else if (score_player_one >= 4 || score_player_two >= 4) output = getAdvantageSituationOutput();
        else output = getUnevenSituationOutput();
        
        return output;
    }
    
    private String getEqualScoreSituationOutput() {
        String output;
        
        switch (score_player_one)
        {
            case 0:
                output = "Love-All";
                break;
            case 1:
                output = "Fifteen-All";
                break;
            case 2:
                output = "Thirty-All";
                break;
            case 3:
                output = "Forty-All";
                break;
            default:
                output = "Deuce";
                break;
        }
        
        return output;
    }
    
    private String getAdvantageSituationOutput() {
        String output;
        int scoreDifference = score_player_one - score_player_two;
        
        if (scoreDifference == 1) output = "Advantage player1";
        else if (scoreDifference == -1) output = "Advantage player2";
        else if (scoreDifference >= 2) output = "Win for player1";
        else output = "Win for player2";
        
        return output;
    }
    
    private String getUnevenSituationOutput() {
        String output = "";
        int score_checker = 0;
        
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            if (i == 0) score_checker = score_player_one;
            else { output += "-"; score_checker = score_player_two;}
            
            switch(score_checker)
            {
                case 0:
                    output += "Love";
                    break;
                case 1:
                    output += "Fifteen";
                    break;
                case 2:
                    output += "Thirty";
                    break;
                case 3:
                    output += "Forty";
                    break;
            }
        }
        return output;
    }
}