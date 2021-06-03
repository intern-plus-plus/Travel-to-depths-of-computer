import java.util.Date;

public class ThreadTest{

    static boolean checkPrime(int n) {
        int i, m = 0, flag = 0;
        m = n / 2;
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            if (flag == 0) {
                return true;
            }
        } // end of else
        return false;
    }

    static void countPrimes(){
        int count = 0;
        for(int i=0 ; i<1000000 ; i++){
            if(checkPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    static int count = 0;
    static boolean isFirstDone=false;
    static void countPrimesMT(){

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 700000; i++) {
                    if (checkPrime(i)) {
                        count++;
                    }
                }
                if(!isFirstDone){
                    isFirstDone=true;
                }else{
                    System.out.println(count);
                }
            }
        }).start();
        for (int i = 700000; i < 1000000; i++) {
            if (checkPrime(i)) {
                count++;
            }
        }
        if (!isFirstDone) {
            isFirstDone = true;
        } else {
            System.out.println(count);
        }
    }

    public static void main(String[] args) {

        long startTime = new Date().getTime();
        countPrimes();
        long endTime = new Date().getTime();
        System.out.println(endTime-startTime);

        startTime = new Date().getTime();
        countPrimesMT();
        endTime = new Date().getTime();
        System.out.println(endTime-startTime);

    }
}