public class Factorial {
    //Fibonacci
    public Integer fibonacci(Integer n) {
        if (n <= 1){
            return n;
        }
        return this.fibonacci(n-1) + this.fibonacci(n-2);
    }
    //Factorial
    public int factorial(int n){
        if (n > 1) {
            return n * this.factorialFunc(n-1);
        }
        else {
            return 1;
        }
    }

    //예제. n이하의 숫자들을 조합하여 n이 되는 경우의 수//
    //CASE1. recursive call
    public int factorialFunc (int n) {
        if (n <= 2) {
            return n;
        } else if (n == 3) {
            return 4;
        }
        return this.factorial(n-1) + this.factorial(n-2) + this.factorial(n- 3);
    }
    //CASE2. 동적 계획법(DP)
    public int dynamicFunc (int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }


    public static void main(String[] args){
        Factorial no1 = new Factorial();
        System.out.println(no1.fibonacci(10));
        System.out.println(no1.factorial(5));

        System.out.println("========예제1========");
        System.out.println(no1.factorialFunc(5));
        System.out.println(no1.dynamicFunc(10));
    }
}
