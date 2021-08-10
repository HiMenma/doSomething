using System;

namespace code
{
    class Data
    {
        public String Name{get;set;}
        public int age{get;set;}
        
    }
    class Program
    {
        static void Main2(string[] args)
        {
            Data d1 = new Data();
            d1.age = 22;
            d1.Name = "杨明雨";
            Console.WriteLine("姓名：{0},年龄：{1}\n",d1.Name,d1.age);
        }
    }
}
