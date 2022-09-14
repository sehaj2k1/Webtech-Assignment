
import java.io.*;

class Assignment {
    public static void add(int a, int b){
        System.out.println((a+b));
    }

    
    public static void subtract(double a, double b){
        System.out.println((a-b));
    }

    
    public static void multiply(double a, double b){
        System.out.println((a*b));
    }

    
    public static void divide(double a, double b){
        System.out.println("Quotient: "+(a/b) + " Remainder: "+(a%b));
    }

    
    public static void swap(double a, double b){
        double t=a;
        a=b;
        b=t;
        System.out.println("The numbers have been swapped. Now, First number is "+a+" and second number is "+b);
    }
    public static void main(String[] args) throws IOException, NumberFormatException  {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter first number: ");
        int i = Integer.parseInt(bfr.readLine());
        System.out.print("\nEnter second number: ");
        int j = Integer.parseInt(bfr.readLine());

        System.out.print("User Menu:\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Swap\nEnter preffered option:");
        int k = Integer.parseInt(bfr.readLine());
        

        switch(k){
            case 1: add(i,j); break;
            case 2: subtract(i,j); break;
            case 3: multiply(i,j); break;
            case 4: divide(i,j); break;
            case 5: swap(i,j); break;
            default: System.out.println("Enter a valid value.");
        }
    }
}

