import java.util.Scanner;

class Team{
    //create team class and passes two entity a cricket team should have
    int playersToBeBowled = 10;
    //in cricket team there are total 11 player so 10 wickets so playersToBeBowled is our first ref var
    int total_runs = 0;
    //initialize total run before the match is zero
}
class Match{ //match class
    int overs=0;
    int balls=0;
    Team t1; //create new team
    Team t2; //total instance variables are overs balls and team t1 t2

    public Match(int overs, Team t1, Team t2) { //constructor i.e. match (same name as class name and no return type
        this.overs = overs; //value of the parameter 'over' is being assigned to the instance variable 'over' of constructor match
        this.balls = overs*6; //here "this" refers to the current instance value of the object over in class match
        this.t1 = t1;
        this.t2 = t2;
    }
    public int StartMatch(){ // new method
        int a = StartInnings(t1);
        int b = StartInnings(t2);
        if(a>b) return 0;
        else return 1; //"StartMatch" method calls "StartInnings" method twice,
                       // once for each team and returns an integer value based on which team has a higher score.
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
            Team t1 = new Team(); //here new object is being created and constructor code runs or constructor called
            Team t2 = new Team(); //Note that the constructor is called when the object is created.
             //the main class creates two team objects(above and a match object(below),
            Match m = new Match(overs,t1,t2);
            int result = m.StartMatch(); //and then calls the "StartMatch" method to determine the result of the match.

            if(result==0) System.out.println("Team 1 wins");
            else System.out.println("Team 2 wins");

            matches--;
        }


    }
}