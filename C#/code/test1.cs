using System;
namespace code
{
    class Test
    {
        private String name;
        private int age;
        public String getName
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }
        public int getAge
        {
            get{return age;} 
            set{age = value;}
        }
        static void Main22()
        {
            Test t1 =  new Test();
            t1.getAge = 22;
            t1.getName = "杨明雨";
            Console.WriteLine("{0},{1}岁\n",t1.getName,t1.getAge);
        }

    }

}