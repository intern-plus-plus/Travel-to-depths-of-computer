#include<stdio.h>

double f(double x){
    return x*x + 1;
}

// 2x 

double epsilon = 0.0000001;
double moshtah(double x){

    double x1 = x+epsilon;

    double y = f(x);
    double y1 = f(x1);

    return (y-y1)/(x-x1);
}

double antegral(double minX,double maxX){

    double sum = 0;
    for (double i = minX; i <= maxX; i+=epsilon){
        double s = epsilon * f(i);
        sum+=s;
    }
    return sum;
}


int main(){

    printf("%f",antegral(1,5));

}