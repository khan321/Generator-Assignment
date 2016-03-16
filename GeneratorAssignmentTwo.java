import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.FileInputStream;

/**
 * Simple example of a class which reads lines from a file and outputs each to
 * the console.
 * 
 * @author Mark Dixon
 *
 */
public class GeneratorAssignmentTwo{
	
	/**
	 * @param args
	 * @throws FileNotFoundException
	 *             when the file cannot be loaded
	 */


 



    public static class Table //table 

    {
    String team_name;   // table string name for team name

    int team_goals_for, //integer team goals for

    team_goals_against, //integer team goals against

    team_points; //integer team points

    Table(String n, int gf, int ga, int points) { //strings

         

        team_name = n;

        team_goals_for = gf;

        team_goals_against = ga;

        team_points = points;

    }

    }

    public static void main(String[] args)

    {

        //Declare and initialise variables

        int  

        totalgoals = 0,

        match_count = 0,

        invalid_count = 0,

        games_played = 0,

        games_won = 0,

        games_lost = 0,

        games_drawn = 0,

        goals_for = 0,

        goals_against = 0,

        home_score = 0,

        away_score = 0,

        count = 0,

        away_points = 0,

        home_points = 0;

         

        String //strings

        nextLine = null,

        teamstats ="",

        home_team,

        away_team,

        match,

        answer,

        answer2,

        yes = "yes";   

        Scanner team = new Scanner(System.in);

        Scanner yes_no = new Scanner(System.in);

        Scanner html = new Scanner(System.in);


        //line counter to see how many lines the text document has

         

        LineNumberReader lineCounter = null; //line counter

        try

        {

            lineCounter = new LineNumberReader( new InputStreamReader(new FileInputStream("results2.txt"))); //text file

        } catch (FileNotFoundException e2)

         

        {

            e2.printStackTrace();

        }

         

 

        try {

            while ((nextLine = lineCounter.readLine()) != null) { //check to see if line is null

                if (nextLine == null)
                	
                    break;

            }}

            catch (Exception done) {

                done.printStackTrace();

            }

 

        Table [] teams = new Table[(lineCounter.getLineNumber()*2)]; //get next line

         

        System.out.println("would you like to view statistics for a specfic team (please answer yes or no)"); //ask user if they would like to view stats for a specific team

     

        answer = yes_no.nextLine();


    if (answer .equalsIgnoreCase(yes)) //if answer is yes

    {

    System.out.println("which team would you like to view statistics on?");

     

    //Get user input for selected team statistics

     

    teamstats = team.nextLine();

    } 

    File file = new File("results2.txt");

     

    //create html page
    System.out.println("Results");
    
    Writer output = null;{

     

            try {

                output = new BufferedWriter(new FileWriter("results.html"));  //html page

 

                   output.write("<table border = 2 cellspacing=2  cellpadding=5>");  //table

                   output.write("<br>");

                   output.write("<br>");

                   output.write("<table border = 3 cellspacing=2  cellpadding=5>");
                   

            } catch (IOException e1) {

                // TODO Auto-generated catch block

                e1.printStackTrace();

            }

            
            
         

    try {

        Scanner scanner = new Scanner(file);
        
        String result;

            while (scanner.hasNext())

            {

             result = scanner.nextLine();

            

             String [] next = result.split(":");            //split up result by a ':'

            if (next.length == 4)							// if length is 4

                    {

                 

                    match_count++;							//adds to match count

                    home_team = next[0].trim();				//trim home team

                    away_team = next[1].trim();				//trim away team
                    
                    

                    try{

                    home_score = (Integer.parseInt(next[2].trim())); //parsing home score

                    away_score = (Integer.parseInt(next[3].trim())); //parsing away team score

                    if (home_score > away_score)		//formula to calculate win points

                    {

                        home_points = 3;								

                        away_points = 0;

                    }

                    else if (home_score == away_score)        //formula to calculate draw points

                    {

                        home_points = 1;

                        away_points = 1;

                    }

                    else									//formula to calculate away points

                    {

                        home_points = 0;

                        away_points = 3;

                    }

                    totalgoals = totalgoals +(home_score+away_score);	//total goals

                     

                    match =  home_team +" ["+home_score+ "] | "+away_team+" ["+away_score+"]";	//match results

 

                    try {

                     

                         

                     

                    teams[count] = new Table(home_team,home_score,away_score,home_points );		//table for home teams

                     

                    teams[count+1] = new Table(away_team,away_score,home_score,away_points );	//table for away teams

                     
                    
                    System.out.println(match);													//print out table results

                    count=count+2;

                    }catch (java.lang.ArrayIndexOutOfBoundsException e) {

                        e.printStackTrace();

                    }

                        if (teamstats.equalsIgnoreCase(home_team)) {

                           games_played++;														//formula to work out games played for home team

                           goals_against = goals_against + away_score;							//formula to work out goals against for home team

                           goals_for = goals_for + home_score;									//formula to work out goals scored for home team

                           if (away_score > home_score)

                            games_lost++;														//formula to work out games lost for home team

                           else if (away_score < home_score)

                            games_won++;														//formula to work out games won for home team

                           else if (away_score == home_score)								

                            games_drawn++;														//formula to work out games drawn for home team

                          }

                          if (teamstats.equalsIgnoreCase(away_team)) {

                           games_played++;														//formula to work out games played for away team

                           goals_against = goals_against + home_score;							//formula to work out goals against for away team

                           goals_for = goals_for + away_score;									//formula to work out goals scored for away team

                           if (home_score > away_score)

                            games_lost++;														//formula to work out games lost for away team

                           else if (home_score < away_score)

                            games_won++;														//formula to work out games won for away team

                           else if (home_score == away_score)

                            games_drawn++;														//formula to work out games drawn for away team

                          }

                    try {  

                    String newline = System.getProperty("line.separator");



                    output.write("<tr><td ALIGN = center>"

                             

                            + home_team.toUpperCase() + "<td>" + home_score + "<td>"			//home team to upper case and add home score

                            + away_team.toUpperCase() + "<td>" + away_score						//away team to upper case and add away score

                            + "</td></tr>");

                     

                            output.write(newline);

                     

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                }

                    catch (NumberFormatException nfe)

                      {

                        System.err.println("NumberFormatException: " + nfe.getMessage());

                      }

 

                    }

                else 

                {

                    invalid_count++;						//invalid count total

                }

             

           

            }

             

    }

    catch (FileNotFoundException e)

        {

        e.printStackTrace();

        }

    Arrays.sort(teams, new Comparator<Table>() { public int compare(Table t1, Table t2) { return new Integer(t1.team_points).compareTo(t2.team_points);  } } ); //add two tables (home and away teams)

    System.out.println(" ");

    System.out.println("League table   GF   GA   Points"); //table headings

     

    for (int index = 0; index < teams.length; index++ )

    {

        System.out.println(teams[index].team_name + " : " + teams[index].team_goals_for+ " : " + teams[index].team_goals_against + " : " + teams[index].team_points); //print team name followed by goals for, goals against and team points

    }

    System.out.println("");

    System.out.println("Todays Statistics;");  //Statistics on team games

    System.out.println("");

    System.out.println("Total Goals scored were "+totalgoals);// total goals count

    System.out.println("Valid Match count was "+match_count);// match count

    System.out.println("Invalid Match count was "+invalid_count);// invalid match count//

    // if answered yes to specific team output

    if (answer .equalsIgnoreCase(yes))

    {

        System.out.println("");

        System.out.println("Statistics for "+teamstats); // statistics for a specific team

        System.out.println("");

        System.out.println("Games Played : "+ games_played); //stats for the chosen team

        System.out.println("Games won : "  + games_won);

        System.out.println("Games lost : " + games_lost);

        System.out.println("Games drawn : " + games_drawn);

        System.out.println("Goals For : " + goals_for);

        System.out.println("Goals Against : " + goals_against);

        

    };

  

    try {

    output.write("<table border = 4 cellspacing=2  cellpadding=5>"); //table for the statistics

       output.write("<br>");

       output.write("<tr><td ALIGN = center>" + "Summary" + "<td>"

         + "Totals");

       output.write("<tr><td ALIGN = center>"

         + "Total Goals scored were: " + "<td>" + totalgoals

         + "</br>");

       output.write("<tr><td ALIGN = center>"

         + "Valid Match count was: " + "<td>" + match_count 
         + "</br>");

       output.write("<tr><td ALIGN = center>"

         + "Invalid Match Count was:" + "<td>"

         + invalid_count + "</br>");

        

        if (answer .equalsIgnoreCase(yes))  //table on stats for the chosen team

        {

        output.write("</table>");

         output.write("<table border = 4 cellspacing=2  cellpadding=5>");

           output.write("<br>");

           output.write("<tr><td ALIGN = center>"+"Statistics for: <td>" + teamstats );

           output.write("<tr><td ALIGN = center>"

             + "Games Played : " + "<td>" + games_played

             + "</br>");

           output.write("<tr><td ALIGN = center>"

             + "Games Won : " + "<td>" + games_won

             + "</br>");

           output.write("<tr><td ALIGN = center>"

             + "Games Drawn : " + "<td>" + games_drawn

             + "</br>");
           
           output.write("<tr><td ALIGN = center>"

             + "Games Lost : " + "<td>" + games_lost

             + "</br>");

           output.write("<tr><td ALIGN = center>"

             + "Goals For : " + "<td>" + goals_for

             + "</br>");

           output.write("<tr><td ALIGN = center>"

             + "Goals Against : " + "<td>" + goals_against

             + "</br>");

        }

        output.close    ();

         

    } catch (IOException e) {


        e.printStackTrace();

    }

    }

    System.out

    .println("would you like to generate your results in html? (please answer yes or no)"); //ask user for choice of html

    answer2 = html.nextLine(); // /// Scans the user input //////

    if (answer2 .equalsIgnoreCase(yes)){

                 

                String fileName = "results.html";   // name of the file to be opened

                 

                // Exec a command to the OS.

                try {

                    Runtime.getRuntime().exec("cmd.exe /C start " + fileName);

                } catch (IOException e) {

                    // Could not open the file, show message to use

                    System.err.println("Error: Unable to open " + fileName);

                }

            }

        }

 }
