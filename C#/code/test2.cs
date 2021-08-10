using System;

delegate int NumberChanger(int n);
namespace DelegateAppl
{
    public class Data
    {
        public int Num{get;set;} = 10;
    }
   class TestDelegate
   {
      public static int AddNum(int p)
      {
        Data d1 = new Data();
        
         d1.Num += p;
         return d1.Num;
      }

      public static int MultNum(int q)
      {
          Data d1 = new Data();
          Console.WriteLine("dadada:{0}",d1.Num); //私有字段只能局部修改，此时num的值还是10
          d1.Num *= q;
         return d1.Num;
      }
      public static int getNum()
      {
          Data d3 = new Data();
         return d3.Num;   //私有字段只能局部修改，返回的都是10
      }

      static void Main(string[] args)
      {
         // 创建委托实例
         NumberChanger nc1 = new NumberChanger(AddNum);
         NumberChanger nc2 = new NumberChanger(MultNum);
         // 使用委托对象调用方法
         int a = nc1(25);
         Console.WriteLine("Value of Num: {0}", a);

         Data d = new Data();
         d.Num = a;
         Console.WriteLine("hahah:{0}",d.Num);    //私有字段只能局部修改
         
         int b = nc2(5);
         Console.WriteLine("Value of Num: {0}", b);
        //  Console.ReadKey();
      }
   }
}