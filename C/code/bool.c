#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#define PI 3.14
#define MAX(a,b) (a)>(b)?(a):(b)
#define MAX2(a,b) \
    ({typeof(a) A = a,B = b;(A)>(B)?(A):(B)})

int MAX1(a, b)
{
    return a>b ? a:b;
}

void func(void)
{
    // auto int i = 1;
    static int i = 1;
    i++;
    printf("[%s]%p->%d\n",__FUNCTION__,&i,i);

}

int main()
{   


    // auto int i ;
    // static int j;
    // printf("%d\n",i);
    // printf("%d\n",j);
    func();
    func();
    func();

    exit(0);
}