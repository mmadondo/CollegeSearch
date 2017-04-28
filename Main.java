import java.util.*;

/**
 * This program assists high school students thinking of applying to college to start on the college seacrh process.
 * Students first choose when they want to enrol in college and then depending with their intended enrol date, suggestions are made by the program
 * 
 * @author (Malvern Madondo) 
 * @version (12/14/2015)
 */

public class CollegeSearch                             
{
    // main method  

    Scanner scnr = new Scanner(System.in);  //console for input
    int enrolDate;                          // intended college start time                      
    String stanTest = "";

    public void enrolTime() {                                         //first method to initiate the program
        System.out.println("When do you intend to enrol in college? 1. Fall 2016, 2. Fall 2017, 3. Fall 2018");
        enrolDate = scnr.nextInt();
        //switch statements for when student wants to start college
        switch( enrolDate) {                                         

            case 1:
            searchProgress();                                          //method called
            break;

            case 2:
            searchProgress();
            break;

            case 3:                                                                            // switch statement with nested if-else statement
            System.out.println("Have you taken the SAT/ACT standardized tests? Enter yes/no: ");
            String stanTest = scnr.next();

            if (stanTest.equals("yes")) {
                System.out.println("You are one organized person!! Start your college search now!" );
                searchProgress();                                      //method called
            } else {

                System.out.println("You still have a little bit of time. You can make the most of high school and engage yourself in extracurriculars and work hard in academics."); 
                eachStep();                                           //method called
            }
            break;

            default:                                                 //default statement for when the above statements are not accessed
            System.out.println("Go and do your homework.");
            break;
        }
        return;                                                     //ends method
    }

    public void searchProgress() {                                                            // method to check on student's progress with the college application process
        int usrTxt;
        System.out.println("How far are you through with your college search process? N.B ENTER A NUMBER!");
        System.out.println("   1: Haven't started");
        System.out.println("   2: Started but still need help.");
        System.out.println("   3: Finished. What should I do next?");

        usrTxt = scnr.nextInt();                                  //student enters integer corresponding with their status                  

        if (usrTxt == 1) {
            System.out.println("");
            System.out.println("College application process can be tough but with a little help, you can find your right fit. There are some factors to consider when selecting schools.");

            learnMore();                                     // a method to learn more about the application process is called
        } else if (usrTxt == 2) {
            System.out.println(" Some important things to consider when selecting colleges are: ");
            System.out.println(" " + "College size, location, average financial aid awarded, type of school, Academic Rigor, selectivity, and so forth" + " ");

            eachStep();                                     //method that asks if students wants to learn about each of the above steps
        } else if (usrTxt == 3) {
            System.out.println("Relax and wait for the decisions! Make sure you visit the colleges you applied to to make sure they are the right fit! #JustSaying...");

        } else {
            System.out.println("Sorry, an error occured. Better stay in high school.");
        } 
        System.out.println("");

        return;
    }

    public void eachStep() {                                      //method that asks if students wants to learn about each of the above steps and calls the learnMore() method

        String aboutSteps = "";
        System.out.println("");

        System.out.println("Do you want to learn about each step in the application process? (Yes/No) ");
        aboutSteps = scnr.next();                                     //user enters response

        if (aboutSteps.equalsIgnoreCase("no")) {

            System.out.println("Thank you for stopping by. All the best.");

        } else{
            System.out.println("");
            learnMore();                                           //learnMore() method called
        } 

    }

    public void learnMore() {                                     // method that describes some of the common factors that are mostly considered when applying to colleges
        int factorToConsider = 0;

        System.out.println("Which factor do you want to consider?");
        System.out.println(" 1. College Size, 2. Location, 3. Financial Aid, 4. Type of School 5. Academic Rigor 6. Selectivity 7. Total cost of attendance/year ");
        factorToConsider = scnr.nextInt();                       //user selects factor they want to learn more about
        System.out.println("");
        int i;
        for (i = 1; i <= 7; i = factorToConsider){

            //switch statements for each of the factors. Only one is called and corresponds to user's input
            switch (factorToConsider) {

                case 1:
                System.out.println("Some schools are small (<2000), some are medium size (2000 - 15 000), and others are large (>15 000) ");
                System.out.println(" General advice is figure out the environment which works best for you");
                break;

                case 2:
                System.out.println("Your ultimate college can be a few blocks from your home, in another state or even outside the U.S.");
                break;

                case 3:
                System.out.println("Financial aid can be merit-based or need-based.");
                System.out.println("Some colleges have scholarships that you can be eligible for e.g. state-affiliated scholarships, religion-based scholarships or even nationality-based scholasrships.");
                break;

                case 4:
                System.out.println("There are many types of schools in the U.S.");
                System.out.println("Some schools are 2-yr/community college and others are 4-yr/college and university.");
                System.out.print(" Some are public and others are private or for profit; and some are Co-Ed while others are single sex.");
                break;

                case 5:
                System.out.println("Some schools are very competitive to get into because they have intense academic programs. If you are up to the challenge..apply!!");
                break;

                case 6:                                                 // calls the selectiveGPA method which suggests possible college types to consider when applying based on expected final GPA
                System.out.println("Some schools are very selective. Here are some suggestions based on your GPA: ");
                selectiveGPA();
                break;

                case 7:                                     //calls the collegeCost() method which suggests college types based on what the student can contribute each year towards college education
                System.out.println("College is now expensive these days.");
                System.out.println("Find out which college type is best for you based on what you can afford..");
                collegeCost();
                break;

                default:
                break;
            }
            return;
        }

        System.out.println("");

        return;
    }

    public void collegeCost() {                                      // method that suggests type of schools to apply to based on student's expected financial contribution 
        int amount;
        System.out.println("Enter the total amount you can afford to pay per year for college: ");
        amount = scnr.nextInt();
        //nested if statements under a for loop. Assumption is maximum college cost is $90 000 and statements are categorized into those who afford $0, <$20 000, <$40 000 and >$40 000

        if (amount == 0) {

            System.out.println("You need a scholarship");
            System.out.println(" " + "Financial aid can be merit-based or need-based.");
            System.out.println(" " + "Some colleges have scholarships that you can be eligible for e.g. state-affiliated scholarships, religion-based scholarships or even nationality-based scholasrships.");

        } else if( amount < 20000) {

            System.out.println("Apply to state schools or for scholarships as well.. Whoever said college was not expensive?");

        } else if (amount >= 20000 && amount <= 40000) {

            System.out.println("Colleges are willing to add a few more dollars to this if you have some good grades..");
            selectiveGPA();

        } else if (amount > 40000) {
            System.out.print("Colleges are dying to have people like you on their campuses. Especially if you pay your bills on time.");
        } 
        return;
    }

    public void selectiveGPA() { 
        //method suggests type of schools a student can consider applying to based on attained or expected GPA
        System.out.println("Enter your expected final GPA");
        double expGPA = scnr.nextDouble();                        //GPA is a decimal

        while (!(expGPA < 0.0 && expGPA > 4.0)){
            if(expGPA <= 2.0) {

                System.out.println("Your chances of getting accepted are higher at schools with open admission (all or most are admitted)");
                System.out.print(" or at less selective schools (>75% admitted).");

            } 
            else if (expGPA > 2.0 && expGPA <= 2.5) {
                System.out.println(" Apply to somewhat selective schools(50–75% admitted)");

            } else if (expGPA>2.5 && expGPA <3.5) {
                System.out.println(" Apply to a few very selective schools(25–50% admitted)");

            } else if (expGPA >= 3.5 && expGPA <= 4.0){
                System.out.println(" Apply to a few most selective schools(<25% admitted) and remember to have backup schools.");

            } else {
                System.out.println("***ERROR 404***");
                System.out.print("+++ Trying to get in college through the back door? +++ ");
            }
            return;
        }
        System.out.println("");

    }
}
