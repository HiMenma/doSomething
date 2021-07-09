#include <stdlib.h>
#include <stdio.h>

int main()
{
    /*
    char a = X
    int a = 88
    */
    char a = 88;
    printf("char a = %c\n",a);
    printf("int a = %d\n",a);

    /*
    0x b = 25bc4
    */
    int b = 154564;
    printf("0x b = %x\n",b);

    /*
    string s = absdhjs
    */
    char s[] = "absdhjs";
    printf("string s = %s\n",s);


    /*
    ua = 1111
    sa = -12121
    sa - > usa = 4294955175
    */
    unsigned ua = 1111;
    signed sa = -12121;
    printf("ua = %u\n",ua);
    printf("sa = %d\n",sa);
    printf("sa - > usa = %u\n",sa);

    /*
    fa = 3.121000,da = 3.121000e+00
    */
    float fa = 3.121;
    double da = 3.121;
    printf("fa = %f,da = %e\n",fa,da);

    exit(0);
}