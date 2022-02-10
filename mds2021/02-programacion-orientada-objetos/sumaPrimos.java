
class SumaPrimos {

    public static void main(String[ ] arg) {

        System.out.println("Suma de los 50 primeros números primos = " + printPrime());
    }


    // Suma de los 50 primeros números primos


    private static int printPrime(){

        int currentValue = 1;
        int result = 0;

        for(int i=1; i<=50; ++i) {

            do {
                ++currentValue;
                result += currentValue;
            } while (isPrime(currentValue) == false);
            
        }

        return result;
    }


    private static boolean isPrime(int number) {

        for(int i=2; i < number; ++i) {

            if(number % i == 0) { return false; }
        }

        return true;
    }
}
