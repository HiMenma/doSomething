package com.menma.collection;

import java.util.*;

public class TestCollection1 {
    public static void main(String[] args) {
//        //创建集合
//        Collection c = new ArrayList();
//        ArrayList arrayList = new ArrayList();
//        //添加元素
//        c.add("西瓜");
//        c.add("橘子");
//        c.add("葡萄");
//        c.add("香蕉");
//        arrayList.add("这是arrayList");
//        //打印
//        System.out.println(c);
//        System.out.println(arrayList);
//        //删除元素
//        c.remove("香蕉");
//        System.out.println("删除之后的C的大小："+c.size());
//
//        //使用增强for遍历
//        for (Object i :
//                c) {
//            System.out.println("c集合中的元素："+i);
//        }
//
//        System.out.println("----------------");
//        //使用Iterator 迭代器遍历
//        //hasnext();next();remove();
//        Iterator iterator = c.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//            iterator.remove(); //删除
//        }
//        System.out.println("删除元素后："+c);
//
//        System.out.println("----------------");
//        //判断isEmpty（），contains（Obj）
//        System.out.println("是否为空"+c.isEmpty());
//        System.out.println("是否包含西瓜"+c.contains("西瓜"));
//
//
//        ArrayList<Object> objects = new ArrayList<>();
//        LinkedList<Object> objects1 = new LinkedList<>();
//        Vector<Object> objects2 = new Vector<>();
//
//        HashSet<Object> objects3 = new HashSet<>(); //创建
//        for (Object obj :               //增强for遍历
//                objects3) {
//            obj.toString();
//        }
//        Iterator<Object> iterator1 = objects3.iterator(); //迭代器遍历
//        while (iterator1.hasNext()){
//            iterator1.next();
//        }


//        Student s1 = new Student("11", 11);
//        Set<Student> objects5 = new TreeSet<>();
//        objects5.add(s1);
//        System.out.println(objects5);

//        TreeSet<String>  ss = new TreeSet<>();
//        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                int n1 = o1.getAge() - o2.getAge();
//                int n2 = o1.getName().compareTo(o2.getName());
//                return n1 == 0 ? n2 : n1;
//            }
//        });
//        students.add(s1);
//
//        ss.add("123");
//        ss.add("hello");
//        System.out.println(ss);

//        //创建
//        HashMap<String, String> map = new HashMap<>();
//        //添加元素
//        map.put("cn","china");
//        map.put("uk","shit");
//        map.put("us","usa");
//        //删除
//        map.remove("uk");
//        //keySet遍历 + 增强for
//        for (String key:
//             map.keySet()) {
//            System.out.println(key + "---"+ map.get(key));
//        }
//        //entrySet遍历 + 增强for;性能强于keySet
//        for (Map.Entry<String,String> entry:
//             map.entrySet()) {
//            System.out.println(entry.getKey() + "----" + entry.getValue());
//        }
        ArrayList<String> list = new ArrayList<>();
        Collections.binarySearch(list,"11");  //二分查找
        Collections.copy(list,list);  //复制
        Collections.reverse(list);     //反转
        Collections.shuffle(list);  //打乱


    }
}
