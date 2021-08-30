# [IO框架](https://www.cnblogs.com/coderzjz/p/13670088.html)

### 1.流的概念

内存与存储设备之间传输数据的通道

### 2.流的分类

- 方向：输入和输出流
- 单位：字节和字符流
- 功能：节点和过滤流

![](C:\Users\Menma\Desktop\code\doSomething\JavaL\IO.png)

### 3.字节流

##### 3.1字节流的父类（抽象类）

```java
//InputStream 字节输入流
public int read(){}
public int read(byte[] b){}
public int read(byte[] b, int off, int len){}

// OutputStream 字节输出流
public void write(int n){}
public void write(byte[] b){}
public void write(byte[] b, int off, int len){}
```

##### 3.2文件字节流

- 文件输入流：创建->读取->关闭

```java
public class IO1 {
    public static void main(String[] args) throws Exception{
        //创建输入流
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\aaa.txt");
        FileInputStream fis2 = new FileInputStream("C:\\Users\\Menma\\Desktop\\aaa.txt");
        //单字节读取
        int data = 0;
        while ((data = fis.read()) != -1){
//            System.out.print((char) data);
        }
        fis.close();
        //多字节读取
        int count = 0;
        byte[] buf = new byte[3];  //缓冲大小为3
//        int read = fis2.read(buf);
        while ((count=fis2.read(buf)) != -1){
            System.out.println(new String(buf,0,count));  //把字节数组buf，从0取到count长度
        }
        fis2.close();
    }
}

```

- 文件输出流：创建->写入->关闭

  ```java
  public class IO2 {
      public static void main(String[] args) throws Exception{
          //创建文件输出流
          FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\bbb.txt", true);
          //写入文件
          fos.write(97);
          fos.write('h');
          String s = "hello~~";
          fos.write(s.getBytes());
          fos.close();
          System.out.println("输出完毕！");
  
      }
  }
  ```

- 图片复制案例：

```java
public class PicCopy {
    public static void main(String[] args) throws Exception {
        //创建输入输出流
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\2.jpg");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\3.jpg");
        //边读边写
        byte[] buf = new byte[99999];
        int count = 0;
        while ((count=fis.read(buf)) != -1){
            fos.write(buf,0,count);
        }
        System.out.println("复制成功！");
        //关闭流
        fis.close();
        fos.close();
    }
}
```

##### 3.3字节缓冲流

缓冲流：BufferedInputStream/ BufferedOutputStream

- 提高IO效率，减少访问磁盘次数
- 数据存储在缓冲区中，flush是将缓冲区的内容写入文件中，也可以直接close

```java
public class BufferedIO {
    public static void main(String[] args) throws Exception{
        //使用带缓冲的io
        //先创建基础的io，再创建带缓存的
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\buffer.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //写入数据
        for (int i = 0; i < 100; i++) {
            bos.write("hello~".getBytes(StandardCharsets.UTF_8));  //将数据写入缓冲区，默认8k
            bos.flush(); //刷新缓冲区，将数据写入到硬盘
        }
        //关闭
        bos.close(); //关闭时也自动 flush
        System.out.println("写入完毕！！");
        //读取文件
        //创建输入流
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\buffer.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        //读取文件
        int data = 0;
        while ((data=bis.read()) != -1){   //使用自带缓存读取
            System.out.print((char)data);
        }
        System.out.println("读取完毕");
        bis.close();
    }
}
```

### 4.对象流

```java
ObjectOutputStream / ObjectInputStream
```

- 增强了缓冲区功能
- 增强了读写8种基本数据类型和字符串的功能
- 增强了读写对象的功能
  - `readObject()` 从流中读取一个对象
  - `writeObject(Object obj)` 向流中写入一个对象

使用流传输对象的过程称为序列化、反序列化

- 对于不想进⾏序列化的变量，使⽤ transient 关键字修饰。
  transient 关键字的作⽤是：阻⽌实例中那些⽤此关键字修饰的的变量序列化；当对象被反序列化时，被 transient 修饰的变量值不会被持久化和恢复。transient 只能修饰变量，不能修饰类和⽅法。

##### 4.1序列化

```java
public class SerializableOutput {
    public static void main(String[] args) throws Exception{
        //序列化：将对象通过流进行传输
        //创建流
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\SSS.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //开始序列化，写入操作
        Student s1 = new Student("yyy", 22);
        Student s2 = new Student("lll", 22);
        //写多个对象，使用泛型集合
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
//        oos.writeObject(s1);
        oos.writeObject(students);
        // 关闭
        oos.close(); //自带flush
        System.out.println("序列化结束！");
    }
}
```

##### 4.2反序列化

```java
public class SerializableInput {
    public static void main(String[] args) throws Exception{
        //反序列化，读取对象
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\sss.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //读取，反序列化
//        Student s1 =(Student)ois.readObject();
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject(); //读取多个对象
        //关闭
        ois.close();
//        System.out.println(s1.toString());
        System.out.println(list.toString());

        System.out.println("反序列化结束！");
    }
}
```

##### 4.3注意事项

- 某个类要想序列化必须实现Serializable接口
- 序列化类中对象属性要求实现Serializable接口
- 序列化版本号ID，保证序列化的类和反序列化的类是同一个类
- 使用transient修饰属性，这个属性就不能序列化
- 静态属性不能序列化
- 序列化多个对象，可以借助集合来实现

```java
public class Student implements Serializable {  //标记可以序列化implements Serializable
    private String name;
    private int age;
    private static transient int i = 0; //使用transient(瞬时的)修饰属性，这个属性就不能序列化
                                        //静态属性不能序列化
    private static final long  serialVersionUID=1L; // 序列化版本号，保证序列化的类和反序列化的类是同一个类
```

### 5.字符流

##### 5.1字符流的父类（抽象类）

`reader` 字符输入流

- `public int read(){}`
- `public int read(char[] c){}`
- `public int read(char[] b, int off, int len){}`

`Writer` 字符输出流

- `public void write(int n){}`
- `public void write(String str){}`
- `public void write(char[] c){}`

##### 5.2使用字符流进行字符文件的复制

```java
public class CharStream {
    public static void main(String[] args) throws Exception{
        //普通的字符流
        //字符流：对字符进行操作；不能复制图片或二进制文件，使用字节流可以复制任意文件
        //新建写入流 和 读取流
        FileWriter fw = new FileWriter("C:\\Users\\Menma\\Desktop\\CharS.txt");
        FileReader fr = new FileReader("C:\\Users\\Menma\\Desktop\\CharS.txt");
        //写和读
        for (int i = 0; i < 10; i++) {
            fw.write("Hello World!\r\n");
        }
       fw.close();
        System.out.println("写完毕！");
        int read =0;
        char[] buf = new char[1024];
        while ((read=fr.read(buf))!=-1){
            System.out.println(new String(buf,0,read));
        }
        fr.close();
    }
}
```

##### 5.3字符缓冲流

```java
BufferedReader / BufferedWriter
```

- 高效读写、支持输入换行符、可一次写一行读一行

```java
public class BufferedCharStream {
    public static void main(String[] args) throws Exception{
        //带缓存的字符流：高效读写，支持输入换行符，可一次读写一行
        //创建写流
        FileWriter fw = new FileWriter("C:\\Users\\Menma\\Desktop\\BufferedCharS.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        //创建读流
        FileReader fr = new FileReader("C:\\Users\\Menma\\Desktop\\BufferedCharS.txt");
        BufferedReader br = new BufferedReader(fr);
        //开始写
        for (int i = 0; i < 10; i++) {
            bw.write("好好学习！");
            bw.newLine(); //换行
        }
        bw.close();
        System.out.println("写入完毕！");
        //开始读
        //1.自定缓存大小
//        char[] buf = new char[1024];
//        int count = 0;
//        while ((count=br.read(buf)) != -1){
//            System.out.println(new String(buf,0,count));
//        }
        //2.使用readLine,一行一行读取
        String line = null;
        while ((line = br.readLine()) != null){  //br.readLine()为null 读取结束
            System.out.println(line);
        }
        br.close();
        System.out.println("读取完毕！");
    }
```

### 6.打印流

- 封装了`print() / println()` 方法 支持写入后换行
- 支持数据原样打印

```java
public class PrintStream {
    public static void main(String[] args) throws Exception{
        //打印流:支持数据原样打印;封装了print() / println() 方法 支持写入后换行
        //创建
        PrintWriter pw = new PrintWriter("C:\\Users\\Menma\\Desktop\\print.txt");
        //打印
        pw.println(123);
        pw.println(true);
        pw.println("hi~");
        pw.println(3.15);
        pw.println('u');
        //关闭
        pw.close();
    }
}
```

### 7.转换流

- 桥转换流 `InputStreamReader / OutputStreamWriter`
- 可将字节流转换为字符流
- 可设置字符的编码方式

```java
public class TransferStream {
    public static void main(String[] args) throws Exception{
        //桥转换流：Input
        //转换流：可以将 字节流 转换为 字符流，并设置编码格式；
        //先写，创建输出流
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\trans.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");//写时指定字符格式
        //写
        for (int i = 0; i < 10; i++) {
            osw.write("我来自中国CN\r\n");
            osw.flush();
        }
        osw.close();
        System.out.println("写完毕");
        //再读
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\trans.txt");
        InputStreamReader isr = new InputStreamReader(fis, "gbk");//读时指定对应编码格式
        int data = 0;
        char[] buf = new char[1024];
        while ((data = isr.read(buf)) != -1){
            System.out.println(new String(buf,0,data));
        }
        isr.close();
        System.out.println("读取完毕！");
    }
}
```

### 8.File类

- 概念：代表物理盘符中的一个文件或者文件夹

##### 8.1操作文件和文件夹

```java
public class FileTest {
    public static void main(String[] args) throws Exception{
//        seperator();
//        fileOpen();
        dirOpe();
    }
    //文件路径的分割符
    public static void seperator(){
        System.out.println("路径分隔符："+ File.pathSeparator);
        System.out.println("名称分隔符："+File.separator);
    }
    //文件操作
    public static void fileOpen() throws Exception {
        //1.创建文件
        File file = new File("C:\\Users\\Menma\\Desktop\\file.txt");
        if(!file.exists()){  //若文件不存在
            boolean b = file.createNewFile(); //创建文件
            System.out.println("创建文件成功！");
        }
        //2.删除文件
        if(false){
            //2.1 直接删除
        file.delete();
            //2.2 jvm退出时删除
        file.deleteOnExit();
        Thread.sleep(5000);
        System.out.println("删除成功！");
        }
        //3.获取文件信息
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("路径："+file.getPath());
        System.out.println("文件名："+file.getName());
        System.out.println("文件父级目录："+file.getParent());
        System.out.println("文件长度："+file.length());
        System.out.println("文件创建时间："+new Date(file.lastModified()));
        System.out.println("-------------------------------");
        //4.判断
        System.out.println("文件是否可写："+file.canWrite());
        System.out.println("是否是文件："+file.isFile());
        System.out.println("是否是隐藏的："+file.isHidden());
    }
    //文件夹操作
    public static void dirOpe() throws Exception{
        //1.创建文件夹
        File dir = new File("C:\\Users\\Menma\\Desktop\\DDD\\GGG");
        System.out.println("文件夹名字："+dir.toString());
        if(!dir.exists()) {  //若文件夹不存在
//        dir.mkdir();  //创建单级文件夹
            dir.mkdirs(); //创建多级目录
            System.out.println("多级文件夹创建成功~");
        }
        //2.删除文件夹 ： 文件夹必须为空才能删除
        if(false){
            //        2.1直接删除
            dir.delete(); //只能删除最底层文件夹
//        2.2 jvms删除
            dir.deleteOnExit();
            Thread.sleep(3000); //线程退出三秒后删除
            System.out.println("删除成功！");
        }
        System.out.println("--------------------");
        //3.获取文件夹信息
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.getPath());
        System.out.println(dir.getParent());
        System.out.println(dir.getName());
        System.out.println(dir.length());
        System.out.println(new Date(dir.lastModified()));
        System.out.println("--------------------");
        //判断
        System.out.println("是不是文件"+dir.isFile());
        System.out.println("是不是文件夹"+dir.isDirectory());
        System.out.println(dir.isHidden());
        System.out.println("--------------------");
        //5.遍历文件夹:只是当前文件夹
        File dir2 = new File("C:\\Users\\Menma\\Desktop\\H");
        String[] dirList = dir2.list();
        System.out.println("H文件夹中有:");
        for (String l :
                dirList) {
            System.out.println(l);
        }
        System.out.println("--------------------");
        //FileFilter接口的使用
        File[] files = dir2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".ppt"))  //只返回以.ppt后缀的文件
                    return true;
                return false;
            }
        });
        System.out.println("以.ppt后缀的文件有：");
        for (File file:
             files) {
            System.out.println(file.getName());
        }
    }
}
```

##### 8.2递归遍历和删除文件夹

```java
public class FileTest2 {
    public static void main(String[] args) {
        //文件夹的递归使用
//        listDir(new File("C:\\Users\\Menma\\Desktop\\H"));
        deleteDir(new File("C:\\Users\\Menma\\Desktop\\H"));
    }
    //递归遍历文件夹
    public static void listDir(File dir){
        File[] files = dir.listFiles();
        System.out.println("此文件夹的绝对路径："+dir.getAbsolutePath());
        if(files != null && files.length>0){
            for (File f :
                    files) {
                if (f.isDirectory()) {
                    listDir(f);  //若是文件夹继续调用，递归
                }else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
    //递归删除文件夹及文件
    public static void deleteDir(File dir){
        File[] files = dir.listFiles();  //拿到当前目录的内容
        if(files != null && files.length>0){
            for (File f :
                    files) {  //遍历当前目录
                if(f.isDirectory()){  //是文件夹继续递归
                    deleteDir(f);
                }else{   //不是文件夹就删除
                    System.out.println( f.getAbsolutePath()+"删除"+f.delete());
                }
            }
        }
        dir.delete();   //最后删除空的文件夹
        System.out.println("删除成功！");
    }
}
```

