#include <stdio.h>
#include <stdlib.h>

int main()
{

    /*
        将某个二进制数的第n位改为1，其他位置不变：num = num | 1 << n
    */

   int i = 0B1100;
   int j;
   j = i | 1 << 1;
   printf("i值=%d\n",i);
   printf("改第一位为1后的i值=%d\n",j);


    /*
        将某个二进制数的第n位改为0，其他位置不变：num = num & ~(1 << n)
    */
   int k;
   k = i & ~(1 << 2);
   printf("改第二位为0后的i值=%d\n",k);

    /*
        测试某个二进制数第n位：if(num & 1 << n)
    */

   if(i & 1 << 3)
        printf("i的第3位为：1\n");
    else
        printf("i的第3位为：0\n");


    /*
        作业：取出指定宽度的值
    */

    exit(0);
}