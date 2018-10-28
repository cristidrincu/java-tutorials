package Generics;

/**
 *
 * @author cristiandrincu
 */
public class GenericsMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("joe");
        BaseballPlayer pat = new BaseballPlayer("pat");
        SoccerPlayer beckham = new SoccerPlayer("beckham");
        
        Team<FootballPlayer> adelaideCrows = new Team("Adelaide Crows");
        adelaideCrows.addPlayer(joe);                
        System.out.println(adelaideCrows.numPlayers());
        
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);
        
        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham);
        
    }
    
}
