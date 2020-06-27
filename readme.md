# 字符串
## String
str.indexOf(String s) 查找字符串s在指定字符串中首次出现的位置

str.lastIndexOf(String s) 查找字符串s在指定字符串中最后一次出现的位置
```Java
String str = "hello world";
int size = str.indexOf("e");
int size = str.lastIndexOf("o");
```
str.charAt(int index) 返回指定索引处的字符
```Java
String str = "hello world";
char mychar = str.charAt(6);
```
str.substring(int beginIndex)

str.substring(int beginIndex, int endIndex)
截取字符串字串
```Java
String str = "hello world";
String substr_1 = str.substring(3);
String substr_2 = str.substring(3, 6);
```
str.trim() 去除左右两端的空格
```Java
String str = "hello world";
String newstr = str.trim();
```
str.replace(char oldChar, char newChar) 字符串替换
```Java
String str = "hello world";
String newstr = str.replace("h", "H");
```
str.startsWith(String prefix) 判断字符串开始是否符合prefix

str.endsWith(String suffix) 判断字符串结尾是否符合suffix
```Java
String str = "hello world";
boolean b = str.startsWith("hel");
boolean b = str.endsWith("d");
```
str.equalsIgnoreCase(String otherstr) 忽略大小写比较字符串
```Java
String str_1 = "hello world";
String str_2 = "Hello World";
boolean b = str.equalsIgnoreCase(str_2);
```
str.toLowerCase() 大写转小写

str.toUpperCase() 小写转大写
```Java
String str = "hello world";
String newstr_1 = str.toLowerCase();
String newstr_2 = str.toUpperCase();
```
str.split(String sign) 将字符串分割成字符串数组

str.split(String sign, int limit) limit：分割次数
```Java
String str = "192.168.0.1";
String newstr_1 = str.split(".");
String newstr_2 = str.split(".", 2);
```
str.matches(String regex) 判断str是否匹配正则表达式regex
```Java
String str = "hello wobrld";
String regex = "[a-zA-Z]";
boolean b = str.matches(regex);
```
str.toCharArray() 字符串转char[]
```Java
String str = "hello wobrld";
char[] ch = str.toCharArray();
```
## StringBuilder
bf.append(Object obj) 向字符串中追加内容

bf.insert(int offset, Object obj) 向指定位置插入内容

bf.delete(int start, int end) 删除指定位置的子串

bf.reverse() 字符串反转
```Java
StringBuilder bf = new StringBuilder("hello");
bf.append("world");
bf.insert(5, " ");
bf.delete(3, 6);
bf.reverse();
```
# 数组
## Arrays
Arrays.sort(obj) 数组升序排序,obj:待排序数组
```Java
int[] arr = {9, 5, 2, 7};
Arrays.sort(arr);
```
Arrays.copyOf(arr, int length) 复制数组，arr：待复制的数组，length：新数组长度

Arrays.copyOfRange(arr, int fromIndex, int toIndex) 复制数组的指定部分
```Java
int[] arr = {9, 5, 2, 7};
int[] newarr1 = Arrays.copyOf(arr, 5);
int[] newarr2 = Arrays.copyOfRange(arr, 1, 3);
```
Arrays.binarySearch(Object[] a, Object key) 在数组a中二分查找key，返回下标,否则返回-1

Arrays.binarySearch(Object[] a, int fromIndex, int toIndex, Object key) 在数组a中指定范围二分查找key，返回下标,否则返回-1
```Java
int[] arr = {9, 5, 2, 7};
int index1 = Arrays.binarySearch(arr, 5);
int index2 = Arrays.binarySearch(arr, 0, 3, 5);
```
# 包装类
## Integer
Integer.parseInt(String str) String转Integer
```Java
String str = "96";
int myint = Integer.parseInt(str);
```
## Character
Character.toUpperCase(char ch) 小写转大写

Character.toLowerCase(char ch) 大写转小写

Character.isUpperCase(char ch) 判断是否为大写

Character.isLowerCase(char ch) 判断是否为小写
```Java
char ch = 'c';
char ch1 = Character.toUpperCase(ch);
char ch2 = Character.toLowerCase(ch);
boolean isUpper = Character.isUpperCase(ch);
boolean isLower = Character.isLowerCase(ch);
```
Character.isLetter(char ch) 判断是否为字母

Character.isDigit(char ch) 判断是否为数字

Character.isLetterOrDigit(char ch) 判断是否为字母或数字
```Java
char ch1 = 'c';
char ch2 = '1';
boolean isLetter = Character.isLetter(ch1);
boolean isDigit = Character.isDigit(ch2);
boolean letter_digit = Character.isLetterOrDigit(ch2);
```
# 数字处理类
## Math
Math.sin(double a) 返回角a的正弦值

Math.cos(double a) 返回角a的余弦值

Math.tan(double a) 返回角a的正切值
```Java
Double a = Math.sin(Math.PI/2);
Double b = Math.cos(Math.PI/2);
Double c = Math.tan(Math.PI/3);
```
Math.exp(double a) 返回e的a次方

Math.log(double a) 取a的自然对数，即lna

Math.log10(double a) 取底数为10的对数

Math.sqrt(double a) 返回a的平方根

Math.pow(double a, double b) 取a的b次方
```Java
Double a = Math.exp(2);
Double b = Math.log(2);
Double c = Math.log10(2);
Double d = Math.sqrt(2);
Double e = Math.pow(2, 2);
```
Math.random() 返回一个0.0-1.0之间的double型数字
```Java
Double a = Math.random();
```
## Random
r.nextInt() 返回一个随机整数

r.nextInt(int n) 返回一个大于等于0小于n的随机整数
```Java
Random r = new Random();
int a = r.nextInt();
int b = r.nextInt(10);
```
# 集合类
## Collection接口
collection.add(Object o) 将指定对象添加到该集合中

collection.remove(Object o) 将指定对象从集合中删除

collection.iterator() 返回用于遍历对象的迭代器

collection.size() 返回该集合中元素的个数
```Java
Collection<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");
list.remove("a");
int size = list.size();
Iterator<String> it = list.iterator();
while(it.hasNext()){
    String str = (String) it.next();
    System.out.println(str);
}
```
## Set集合
set.first() 返回集合中第一个元素

set.last() 返回集合中最后一个元素
```Java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
String first = set.first();
String last = set.last();
}
```
## Map集合
map.put(K key, V value) 向集合中添加指定的key-value键值对

map.containsKey(K key) 集合中是否包含键key，若包含返回true

map.containsValue(V value) 集合中是否包含值value，若包含返回true

map.get(K key) 返回集合中键key对应的值value

map.keySet() 返回集合中所有key组成的Set集合

map.values() 返回集合中所有value组成的Collection集合
```Java
Map<String, Integer> map = new HashMap<>();
map.put("Chinese", 80);
map.put("Math", 90);
map.put("English", 70);
boolean hasKey = map.containsKey("Math");   //true
boolean hasValue = map.containsValue(100);  //false
int math = map.get("Math");                 //90
Set<String> set = map.keySet();
Collection<Integer> list = map.values();
```
# 异常
## 自定义异常
```Java
public class MyException extends Exception {
    String message;

    public MyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class Captor {
    static int divide(int x, int y) {
        if(y == 0) {
            throw new MyException("除数不能为0");
        }
        return x / y;
    }

    public static void main(String[] args) {
        try {
            int result = divide(2, 0);
        } catch(MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
```
# 多线程
## Thread
继承Thread类并重写run()方法，通过start()方法启动线程
```Java
public class ThreadTest extends Thread {
    private int count = 10;

    public void run() {
        while (true) {
            System.out.println(count + " ");
            if(--count == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        new ThreadTest().start();
    }
}
```
## 线程休眠
调用sleep()方法使线程休眠，由于sleep()方法的执行可能抛出InterruptedException异常，所以将slee()方法的调用放在try-catch块中
```Java
try {
    Thread.sleep(2000); //休眠2秒
} catch(InterruptedException) {
    e.printStackTrace();
}
```
## 线程加入
调用join()方法在线程执行过程中加入另一个线程，原线程需等待加入线程执行完毕之后继续执行
```Java
public class JoinTest {
    private Thread threadA;
    private Thread threadB;

    public static void main(String[] args) {
        new JoinTest();
    }

    public JoinTest() {
        //使用匿名内部类形式初始化Thread对象
        threadA = new Thread(new Runnable() {
            int count = 0;

            public void run() {
                while(true) {
                    System.out.println(++count);
                    try {
                        Thread.sleep(100);
                        threadB.join();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    if(count == 100) {
                        break;
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count = 0;

            public void run() {
                while(true) {
                    System.out.println(++count);
                    try {
                        Thread.sleep(100);
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    if(count == 100) {
                        break;
                    }
                }
            }
        });
    }
}
```
## 线程中断
使用stop()方法停止线程已被废除，提倡在run()方法中使用无限循环，添加一个布尔值控制循环终止。

当线程使用sleep()或wait()方法进入就绪状态时，使用Thread类中的interrupt()方法结束线程，此时程序会抛出InterruptedException异常。可以在处理该异常的同时完成线程中断业务处理，如关闭数据库连接，关闭Socket等。
```Java
public class InterruptTest {
    Thread thread;

    public class void main(String[] args) {
        new InterruptTest();
    }

    public InterruptTest() {
        thread = new Thread(new Runnable() {
            int count = 0;

            public void run() {
                while(true) {
                    System.out.println(++count);
                    try {
                        thread.sleep(100);
                    } catch(InterruptedException e) {
                        System.out.println("线程中断");
                        break;
                    }
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
}
```
## 线程优先级
使用setPriority()方法调整线程优先级，优先级1~10取整数，数字越大优先级越高，若设置的优先级不在该范围内，将产生IllegalArgumentException
```Java
public class PriorityTest {
    public PriorityTest() {
        Thread threadA = new Thread(new MyThread());
        Thread threadB = new Thread(new MyThread());
        Thread threadC = new Thread(new MyThread());
        setPriority("threadA", 5, threadA);
        setPriority("threadB", 4, threadB);
        setPriority("threadC", 3, threadC);
    }

    public static void setPriority(String name, int priority, Thread thread) {
        thread.setPriority(priority);   //设置优先级
        thread.setName(name);           //设置线程名
        thread.start();
    }

    public static void main(String[] args) {
        new PriorityTest();
    }

    //定义一个实现Runnable接口的类用于创建线程
    private final class MyThread implements Runnable {
        int count = 0;

        public void run() {
            while(true) {
                System.out.println(++count);
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    System.out.println("线程中断");
                }
                if(count == 100){
                    break;
                }
            }
        }
    }
}
```
## 线程同步
