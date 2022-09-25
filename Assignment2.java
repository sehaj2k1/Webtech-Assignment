import java.io.*;
import java.util.*;
class Assignment2 {
    public static void out(Object o) {
        System.out.println(o);
    }

    public static void q1() {
        Scanner s = new Scanner(System.in);
        double score = s.nextDouble();
        if (score <= 90 && score >= 80)
            score += 5;

        out(score);
    }

    public static void q2() {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        out("The Minimum number is: "+Math.min(a, Math.min(b, c)));
    }

    public static void q3() {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        switch (m) {
            case 1:
                out("January - 31 days"); break;
            case 2:
                out("February - 28 days"); break;
            case 3:
                out("March - 31 days"); break;
            case 4:
                out("April - 30 days"); break;
            case 5:
                out("May - 31 days"); break;
            case 6:
                out("June - 30 days"); break;
            case 7:
                out("July - 31 days"); break;
            case 8:
                out("August - 31 days"); break;
            case 9:
                out("September - 30 days"); break;
            case 10:
                out("October - 31 days"); break;
            case 11:
                out("November - 30 days"); break;
            case 12:
                out("December - 31 days"); break;
        }

    }

    public static void q4() {
        int pop = 80000;
        double rate = 0.05;
        int years = 0;
        while (pop <= 150000) {
            pop += (pop * rate);
            years++;
        }
        out("Number of years to cross 1,50,000 population is " + years);
    }

    public static void q5() {
        Scanner s = new Scanner(System.in);
        int j = s.nextInt();
        for(int i=0; i<=j; i++){
            if(i==0)
                out("n      n^2      n^3       n^4");
            else
                out(i+"     "+Math.pow(i,2)+"      "+Math.pow(i,3)+"        "+Math.pow(i,4));        
        }

    }

    public static void q6() {
        int i=3;
        do{
            out(i+" ");
            i+=3;
        }while(i<=36);
    }

    public static void main(String[] args){
        System.out.print("Enter corresponding question number for the function to run:");
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        switch(k){
            case 1: q1(); break;
            case 2: q2(); break;
            case 3: q3(); break;
            case 4: q4(); break;
            case 5: q5(); break;
            case 6: q6(); break;
        }
    }
}