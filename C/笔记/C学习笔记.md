C中return 0；表示子进程结束，给父进程返回一直值；使用echo $? 可以得到上一个程序的返回值。

注释

```c
`#if 0` 

`{代码块} //此代码块不执行。被注释了`

`#endif
```

二进制：B345；八进制：0345；十六进制：0x345

整型都是用补码表示，正数的补码就是本身，负数的补码是其绝对值的补码取反加一。

float型占32位，用科学计数法表示，最高1位是符号位；接下8位是指数位；剩下23位表示0后面的小数值。

float型与0进行比较时，可以规定｜f - 0｜<>= 1e^-6,6表示小数位数。绝对值用fabs（）方法表示。

bool类型false默认值是整型输出0 ture为1；

字符常量：用单引号引起来的（转义）字符，'a', 'b', '\t','\n',\014'表示八进制数， '\x1f'表示十六进制数。'\018'是错误的。

字符串常量用数组表示：char a[123]; ""表示字符串，"" = "\0"。

宏定义常量或者方法：#define，在编译时执行，可以减少运行时间，对实时性要求高的场景可以用。缺点：不进行语法检查，只是单纯的宏体与宏名之间的替换。

```c
\`#define PI 3.14`

`\#define MAX(a,b) (a)>(b)?(a):(b)`

`\#define MAX2(a,b) \`

​    `({typeof(a) A = a,B = b;(A)>(B)?(A):(B)})
```

变量的定义： [存储类型] 数据类型 标识符 = 值；  	TYPE NAME = VALUE；存储类型：auto（默认），register（建议型，与寄存器有关），static（静态型），extern（说明型）；存储类型中的static感觉有点像java中的private，限制多个源文件变量和所修饰的方法发升冲突。extern可以扩展变量作用域。

变量的使用：就近原则。

自增与自减：int a = i++； a得到的是i的初始值，i再自增；int b = ++i；b得到的是i自增之后整个表达式的值。自减同。

逻辑与&&和逻辑或||具有短路特性。

求字节数运算符：sizeof，例如sizeof(int)返回值为4。

位运算符（二进制运算）：<<(左移)， >>（右移）， ~（取反） ，|（按位或，有1则1，全0则0） ，&（按位与，全1才1，有0则0） ，^（按位异或，相同为1，不同为0）。

将某个二进制数的第n位改为1，其他位置不变：num = num | 1 << n

将某个二进制数的第n位改为0，其他位置不变：num = num & ~(1 << n)

测试某个二进制数第n位：if(num & 1 << n)
