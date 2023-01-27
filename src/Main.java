import java.util.Scanner;

class Team{
    //create team class and passes two entity a cricket team should have
    int playersToBeBowled = 10;
    //in cricket team there are total 11 player so 10 wickets
    int total_runs = 0;
    //initialize total run before the match is zero
}
class Match{
    int overs=0;
    int balls=0;
    Team t1; //create
    Team t2;

    public Match(int overs, Team t1, Team t2) {
        this.overs = overs;
        this.balls = overs*6;
        this.t1 = t1;
        this.t2 = t2;
    }
    public int StartMatch(){
        int a = StartInnings(t1);
        int b = StartInnings(t2);
        if(a>b) return 0;
        else return 1;
    }

    private int StartInnings(Team team){
        while(team.playersToBeBowled>0 && balls>0){
            int shot = (int)Math.floor(8*Math.random());
            if(shot<7) team.total_runs += shot;
            else team.playersToBeBowled--;
            balls --;
        }
        return team.total_runs;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matches = sc.nextInt();
        while(matches>0){
            System.out.println("Please enter number of overs: ");
            int overs = sc.nextInt();
            Team t1 = new Team();
            Team t2 = new Team();


            Match m = new Match(overs,t1,t2);
            int result = m.StartMatch();
            if(result==0) System.out.println("Team 1 wins");
            else System.out.println("Team 2 wins");

            matches--;
        }


    }
}