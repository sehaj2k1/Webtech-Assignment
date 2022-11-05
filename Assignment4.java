import java.util.*;
class Assignment4{
    //User defined vector class - Question 1
    public class MyVector implements Cloneable {

        public Object[] items;
        public int arraySize;
        public int maxCap;
    
        public MyVector (int initialCapacity) {
            super();
            if (initialCapacity < 0) {
                throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
            }
            this.items = new Object[initialCapacity];
            this.arraySize = 0;
            this.maxCap = initialCapacity;
        }
    
        public MyVector() {
            this(10);
        }
    
        public void append(Object element) {
            int newArraySize = this.arraySize + 1;
            if(this.maxCap == newArraySize) {
                this.items = this.increaseCap(newArraySize);
                this.items[this.arraySize] = element;
                this.arraySize += 1;
                //System.out.println(this.items[this.arraySize);
            } else {
                this.items[this.arraySize] = element;
                this.arraySize +=1;
            }
        }
        @Override
        public String toString() {
            String output = "[";
            //output = this.items[0].toString();
            for(int i = 0; i < this.arraySize; i++) {
                output += this.items[i] + ", ";
            }
            output += "]";
            return output;
        }
        public void clear() {
            for(int i = 0; i < this.arraySize; i++) {
                this.items[i] = null;
                this.arraySize = 0;
            }
        }
        public boolean contains(Object element) {
            boolean doesContain = false;
            for(int i = 0; i < this.arraySize; i++) {
                if(element == this.items[i]) {
                    doesContain = true;
                    i = this.arraySize;
                }
            }
            return doesContain;
        }
        public Object elementAt(int index) {
            if(this.arraySize >= index) {
                return this.items[index];
            } else {
                Object temp = null;
                System.out.println("No index of " + index);
                return temp; 
            }
        }
        public Object indexOf(Object element) {
            Object index = "No value found";
            for(int i = 0; i < this.arraySize; i++) {
                if(element == this.items[i]) {
                    index = i;
                    break;        
                } 
            }
            return index;
        }
        public boolean isEmpty() {
            if(this.arraySize == 0) {
                return true;
            }
            return false;
        }
        public void replace(int index, Object element) {
            if(this.arraySize > index) {
                this.items[index] = element;
            } else {
                System.out.println("No element at " + index);
            }
        }
        public int size() {
            return this.arraySize;
        }
        public void reverse() {
            Object[] temp = new Object[this.items.length];
            int j = this.arraySize;
            for(int i = 0; i < this.arraySize; i++) {
                temp[j] = this.items[i];
                j--;
            }
            this.items = temp;
        }
        public void ensureCapacity(int minCapacity) {
            if(minCapacity > this.items.length) {
                this.items = this.increaseCap(minCapacity);
            }
        }
        public Object[] increaseCap(int minCap) {
            Object[] arr1 = new Object[minCap * 2];
            for(int i = 0; i < minCap; i++) {
                arr1[i] = this.items[i];
            }
            this.maxCap = this.maxCap * 2;
            return arr1;
        }
        @Override
        public Object clone() {
            return this.items;
        }
        public boolean checkIndex(int index) {
            boolean check = false;
            if(index < this.arraySize) {
                check = true;
            }
            return check;
        }
        public void removeAt(int index) {
            if(true == this.checkIndex(index)) {
                Object[] temp = new Object[this.arraySize - 1];
                for(int j = 0; j < index; j++) {
                    temp[j] = this.items[j];
                }
                for(int j = index + 1; j < this.arraySize; j++) {
                    temp[j-1] = this.items[j];
                }
                this.items = temp;
                this.arraySize = this.arraySize - 1;
            }
        }
        public void insertAt(int index, Object element) {
            if (this.checkIndex(index) == true) {
                Object[] temp = new Object[this.arraySize];
                for(int i = index; i < this.arraySize; i++) {
                    temp[i+1] = this.items[i];
                }
                this.items[index] = element;
                for (int i = index + 1; i < this.arraySize; i++) {
                    this.items[i] = temp[i - 1];
                }
                this.arraySize = this.arraySize - 1;
            }
        }
        public void remove(Object element) {
            for(int i = 0; i < this.items.length; i++) {
                if(this.items[i] == element) {
                    this.removeAt(i);
                }
            }
        }
        public void removeRange(int fromIndex, int toIndex) {
            for(int i = fromIndex; i < toIndex; i++) {
                this.removeAt(i);
            }
        }
        public void merge(MyVector vector2) {
            this.ensureCapacity(vector2.size() + this.arraySize);
            for(int i = 0; i < vector2.size(); i++) {
                this.append(vector2);
            }
        }
        public void display(){
            for(int i=0; i < this.arraySize; i++) {
                System.out.print(this.items[i] + " ");
            }
            System.out.println();
        }
    }

    //Class Employee
    public class Employee{
        public String name;
        public String address;
        public String yoj; //Year of Joining        

        public Employee(String name, String address, String yoj) {
            this.name = name;
            this.address = address;
            this.yoj = yoj;
        }

        public void displayRecord() {            
            System.out.println(this.name + "             " + this.yoj + "              " + this.address);            
        }
    }

    public static void q1(){
        Assignment4 a = new Assignment4();
        Assignment4.MyVector vector1 = a.new MyVector(6);                
        vector1.append(1);
        vector1.append(2);
        vector1.append(3);
        vector1.append(4);
        vector1.append(5);
        vector1.append(6);
        vector1.display();
    }                               
    public static void q2(){     
        Assignment4 a = new Assignment4(); 
        Assignment4.Employee e = a.new Employee("Robert", "64C-Wall Street", "1994");             
        Assignment4.Employee e1 = a.new Employee("Sam", "68D-Wall Street", "2000"); 
        Assignment4.Employee e2 = a.new Employee("John", "26B-Wall Street", "1999");

        // e.name = "Robert";
        // e.address = "64C-Wall Street";
        // e.yoj = "1994";
        // e1.name = "Sam";
        // e1.yoj = "2000";
        // e1.address = "68D - Wall Street";
        // e2.name = "John";
        // e2.yoj = "1999";
        // e2.address = "26B-Wall Street";

        System.out.println("Name          Year of Joining          Address");
        System.out.println("---------  ------------------  ------------------");
        e.displayRecord();
        e1.displayRecord();
        e2.displayRecord();    
    }

    //Class Number - Question 3
    public class Number {
        private double value;
        
        public Number(double value) {
            this.value = value;
        }

        public double getValue() {
            return this.value;
        }

        public boolean isZero(){
            if(this.value==0)
                return true;
            return false;
        }

        public boolean isPositive(){
            if(this.value>0)
                return true;
            return false;
        }

        public boolean isNegative(){
            if(this.value<0)
                return true;
            return false;
        }

        public boolean isEven(){
            if(this.value%2==0)
                return true;
            return false;
        }

        public boolean isOdd(){
            if(this.value%2!=0)
                return true;
            return false;
        }

        public boolean isPrime(){
            double n = this.value;
            if (n <= 1)
                return false;
            if (n <= 3)
                return true;

            // This is checked so that we can skip
            // middle five numbers in below loop
            if (n % 2 == 0 || n % 3 == 0)
                return false;

            for (int i = 5; i * i <= n; i = i + 6)
                if (n % i == 0 || n % (i + 2) == 0)
                    return false;

            return true;
        }

        public boolean isArmStrong(){
            double n = this.value;
            double originalNumber, remainder, result = 0;          
            originalNumber = n;
            
            while(originalNumber != 0){
                remainder = originalNumber % 10;
                result += (remainder * remainder * remainder);
                originalNumber /= 10;                             
            }
            if(result == n)
                return true;
            return false;
        }

        //return double type
        public double getFactorial(){

        }

        public double getSqrt(){
            return Math.sqrt(this.value);
        }

        public double getSqr(){
            return (this.value*this.value);
        }
    }
    public static void q3(){    

    }

    public static void main(String[] args) throws Exception {
        System.out.print("Enter corresponding question number for the function to run:");
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        switch(k){
            case 1: q1(); break;
            case 2: q2(); break;
            case 3: q3(); break;
        }
    }
}
