public class Prog2_Calculations {

        // 1. Calculate Depreciation
        public static double depreciation(double initialValue, double rate, int years) {
            return initialValue * Math.pow((1 - rate / 100), years);
        }
    
        // 2. Check if a number is a Perfect Number
        //A Perfect Number is a positive integer that is equal to the sum of its proper divisors (excluding itself).
        //Instead of checking all numbers we optimize by looping only until sqrt(num). So i<=sqrt(num) or i^2<=num
        //If i is a divisor (num % i == 0), we add both i and num / i to sum.
        // Example: If num = 28 and i = 2, we add 2 and 28 / 2 = 14.
        public static boolean isPerfectNumber(int num) {
            int sum=1;
            for(int i=2;i*i<=num;i++) {
                if(num%i==0){
                    sum+=i;
                    if(i!=num/i) sum+=num/i; //4/2=2 so we wont add 2 to the sum twice. But 28/2 is 14 so we add only 14 as we have added 2 just in the prev step
                }
            }
            return num>1 && sum==num;
        }
    
        // 3. Check Leap Year
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    
        // 4. Future Investment Value
        public static double futureInvestment(double principal, double rate, int years) {
            return principal * Math.pow((1 + rate / 100), years);
        }
    
        // 5. HCF (GCD) of Two Numbers
        public static int hcf(int a, int b) {
            return b == 0 ? a : hcf(b, a % b);
        }
    
        // 6. LCM of Two Numbers
        public static int lcm(int a, int b) {
            return (a * b) / hcf(a, b);
        }
    
        // 7. NCR & NPR
        public static int factorial(int n) {
            return (n == 0) ? 1 : n * factorial(n - 1);
        }
    
        public static int nCr(int n, int r) {
            return factorial(n) / (factorial(r) * factorial(n - r));
        }
    
        public static int nPr(int n, int r) {
            return factorial(n) / factorial(n - r);
        }
    
        // 8. Compound Interest
        public static double compoundInterest(double principal, double rate, int years, int timesPerYear) {
            return principal * Math.pow((1 + rate / (100 * timesPerYear)), years * timesPerYear);
        }
    
        // 9. Batting Average
        public static double battingAverage(int runs, int dismissals) {
            return dismissals == 0 ? 0 : (double) runs / dismissals;
        }
    
        // 10. CGPA Calculation
        public static double calculateCGPA(double[] grades) {
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.length;
        }
    
        // 11. Distance Between Two Points
        public static double distanceBetweenPoints(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
    
        // 12. Calculate Commission Percentage
        public static double commissionPercentage(double salesAmount, double commissionRate) {
            return (salesAmount * commissionRate) / 100;
        }
    
        // 13. Power Calculation
        public static double power(double base, int exponent) {
            return Math.pow(base, exponent);
        }
        public static double convertToUSD(double inr) {
            double usdRate = 83.0; // Example exchange rate
            return inr / usdRate;
        }        
        public static void main(String[] args) {
            System.out.println("Depreciation Value: " + depreciation(1000, 10, 5));
            System.out.println("Perfect Number: " + isPerfectNumber(28));
            System.out.println("Leap Year: " + isLeapYear(2024));
            System.out.println("Future Investment: " + futureInvestment(1000, 5, 10));
            System.out.println("HCF: " + hcf(12, 18));
            System.out.println("LCM: " + lcm(12, 18));
            System.out.println("NCR (5,2): " + nCr(5, 2));
            System.out.println("NPR (5,2): " + nPr(5, 2));
            System.out.println("Compound Interest: " + compoundInterest(1000, 5, 10, 4));
            System.out.println("Batting Average: " + battingAverage(5000, 100));
            System.out.println("CGPA: " + calculateCGPA(new double[]{8.5, 9.0, 8.8}));
            System.out.println("Distance Between Points: " + distanceBetweenPoints(2, 3, 5, 7));
            System.out.println("Commission Percentage: " + commissionPercentage(5000, 10));
            System.out.println("Power Calculation: " + power(2, 3));
        }
    }