- [字符串](#字符串)
  - [String](#string)
  - [StringBuilder](#stringbuilder)
- [数组](#数组)
  - [Arrays](#arrays)
- [包装类](#包装类)
  - [Integer](#integer)
  - [Character](#character)
- [数字处理类](#数字处理类)
  - [Math](#math)
  - [Random](#random)
- [集合类](#集合类)
  - [Collection接口](#collection接口)
  - [Set集合](#set集合)
  - [Map集合](#map集合)
- [异常](#异常)
  - [自定义异常](#自定义异常)
- [多线程](#多线程)
  - [Thread](#thread)
  - [线程休眠](#线程休眠)
  - [线程加入](#线程加入)
  - [线程中断](#线程中断)
  - [线程优先级](#线程优先级)
  - [线程同步](#线程同步)
    - [同步块](#同步块)
    - [同步方法](#同步方法)
- [网络通信](#网络通信)
  - [InetAddress](#inetaddress)
  - [实例](#实例)
    - [客户端](#客户端)
    - [服务器端](#服务器端)
- [文件I/O](#文件io)
  - [FileInputStream&FileOutputStream](#fileinputstreamfileoutputstream)
  - [FileReader&FileWriter](#filereaderfilewriter)
  - [BufferedReader&BufferedWriter](#bufferedreaderbufferedwriter)
  - [DataInputStream&DataOutputStream](#datainputstreamdataoutputstream)
# 字符串
## String
`str.indexOf(String s)` 查找字符串s在指定字符串中首次出现的位置

`str.lastIndexOf(String s)` 查找字符串s在指定字符串中最后一次出现的位置
```java
String str = "hello world";
int size = str.indexOf("e");
int size = str.lastIndexOf("o");
```
`str.charAt(int index)` 返回指定索引处的字符
```java
String str = "hello world";
char mychar = str.charAt(6);
```
`str.substring(int beginIndex)`

`str.substring(int beginIndex, int endIndex)`

截取字符串子串
```java
String str = "hello world";
String substr_1 = str.substring(3);
String substr_2 = str.substring(3, 6);
```
`str.trim()` 去除左右两端的空格
```java
String str = "hello world";
String newstr = str.trim();
```
`str.replace(char oldChar, char newChar)` 字符串替换
```java
String str = "hello world";
String newstr = str.replace("h", "H");
```
`str.startsWith(String prefix)` 判断字符串开始是否符合prefix

`str.endsWith(String suffix)` 判断字符串结尾是否符合suffix
```java
String str = "hello world";
boolean b = str.startsWith("hel");
boolean b = str.endsWith("d");
```
`str.equalsIgnoreCase(String otherstr)` 忽略大小写比较字符串
```java
String str_1 = "hello world";
String str_2 = "Hello World";
boolean b = str.equalsIgnoreCase(str_2);
```
`str.toLowerCase()` 大写转小写

`str.toUpperCase()` 小写转大写
```java
String str = "hello world";
String newstr_1 = str.toLowerCase();
String newstr_2 = str.toUpperCase();
```
`str.split(String sign)` 将字符串分割成字符串数组

`str.split(String sign, int limit)` limit：分割次数
```java
String str = "192.168.0.1";
String newstr_1 = str.split(".");
String newstr_2 = str.split(".", 2);
```
`str.matches(String regex)` 判断str是否匹配正则表达式regex
```java
String str = "hello wobrld";
String regex = "[a-zA-Z]";
boolean b = str.matches(regex);
```
`str.toCharArray()` 字符串转char[]
```java
String str = "hello wobrld";
char[] ch = str.toCharArray();
```
## StringBuilder
`bf.append(Object obj)` 向字符串中追加内容

`bf.insert(int offset, Object obj)` 向指定位置插入内容

`bf.delete(int start, int end)` 删除指定位置的子串

`bf.reverse()` 字符串反转
```java
StringBuilder bf = new StringBuilder("hello");
bf.append("world");
bf.insert(5, " ");
bf.delete(3, 6);
bf.reverse();
```
# 数组
## Arrays
`Arrays.sort(obj)` 数组升序排序,obj:待排序数组
```java
int[] arr = {9, 5, 2, 7};
Arrays.sort(arr);
```
`Arrays.copyOf(arr, int length)` 复制数组，arr：待复制的数组，length：新数组长度

`Arrays.copyOfRange(arr, int fromIndex, int toIndex)` 复制数组的指定部分
```java
int[] arr = {9, 5, 2, 7};
int[] newarr1 = Arrays.copyOf(arr, 5);
int[] newarr2 = Arrays.copyOfRange(arr, 1, 3);
```
`Arrays.binarySearch(Object[] a, Object key)` 在数组a中二分查找key，返回下标,否则返回-1

`Arrays.binarySearch(Object[] a, int fromIndex, int toIndex, Object key)` 在数组a中指定范围二分查找key，返回下标,否则返回-1
```java
int[] arr = {9, 5, 2, 7};
int index1 = Arrays.binarySearch(arr, 5);
int index2 = Arrays.binarySearch(arr, 0, 3, 5);
```
# 包装类
## Integer
`Integer.parseInt(String str)` String转Integer
```java
String str = "96";
int myint = Integer.parseInt(str);
```
## Character
`Character.toUpperCase(char ch)` 小写转大写

`Character.toLowerCase(char ch)` 大写转小写

`Character.isUpperCase(char ch)` 判断是否为大写

`Character.isLowerCase(char ch)` 判断是否为小写
```java
char ch = 'c';
char ch1 = Character.toUpperCase(ch);
char ch2 = Character.toLowerCase(ch);
boolean isUpper = Character.isUpperCase(ch);
boolean isLower = Character.isLowerCase(ch);
```
`Character.isLetter(char ch)` 判断是否为字母

`Character.isDigit(char ch)` 判断是否为数字

`Character.isLetterOrDigit(char ch)` 判断是否为字母或数字
```java
char ch1 = 'c';
char ch2 = '1';
boolean isLetter = Character.isLetter(ch1);
boolean isDigit = Character.isDigit(ch2);
boolean letter_digit = Character.isLetterOrDigit(ch2);
```
# 数字处理类
## Math
`Math.sin(double a)` 返回角a的正弦值

`Math.cos(double a)` 返回角a的余弦值

`Math.tan(double a)` 返回角a的正切值
```java
Double a = Math.sin(Math.PI/2);
Double b = Math.cos(Math.PI/2);
Double c = Math.tan(Math.PI/3);
```
`Math.exp(double a)` 返回e的a次方

`Math.log(double a)` 取a的自然对数，即lna

`Math.log10(double a)` 取底数为10的对数

`Math.sqrt(double a)` 返回a的平方根

`Math.pow(double a, double b)` 取a的b次方
```java
Double a = Math.exp(2);
Double b = Math.log(2);
Double c = Math.log10(2);
Double d = Math.sqrt(2);
Double e = Math.pow(2, 2);
```
`Math.random()` 返回一个0.0-1.0之间的double型数字
```java
Double a = Math.random();
```
## Random
`r.nextInt()` 返回一个随机整数

`r.nextInt(int n)` 返回一个大于等于0小于n的随机整数
```java
Random r = new Random();
int a = r.nextInt();
int b = r.nextInt(10);
```
# 集合类
## Collection接口
`collection.add(Object o)` 将指定对象添加到该集合中

`collection.remove(Object o)` 将指定对象从集合中删除

`collection.iterator()` 返回用于遍历对象的迭代器

`collection.size()` 返回该集合中元素的个数
```java
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
`set.first()` 返回集合中第一个元素

`set.last()` 返回集合中最后一个元素
```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
String first = set.first();
String last = set.last();
```
## Map集合
`map.put(K key, V value)` 向集合中添加指定的key-value键值对

`map.containsKey(K key)` 集合中是否包含键key，若包含返回true

`map.containsValue(V value)` 集合中是否包含值value，若包含返回true

`map.get(K key)` 返回集合中键key对应的值value

`map.keySet()` 返回集合中所有key组成的Set集合

`map.values()` 返回集合中所有value组成的Collection集合
```java
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
```java
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
继承`Thread`类并重写`run()`方法，通过`start()`方法启动线程
```java
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
调用`sleep()`方法使线程休眠，由于sleep()方法的执行可能抛出`InterruptedException`异常，所以将slee()方法的调用放在`try-catch`块中
```java
try {
    Thread.sleep(2000); //休眠2秒
} catch(InterruptedException) {
    e.printStackTrace();
}
```
## 线程加入
调用`join()`方法在线程执行过程中加入另一个线程，原线程需等待加入线程执行完毕之后继续执行
```java
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

当线程使用sleep()或wait()方法进入就绪状态时，使用Thread类中的`interrupt()`方法结束线程，此时程序会抛出`InterruptedException`异常。可以在处理该异常的同时完成线程中断业务处理，如关闭数据库连接，关闭Socket等。
```java
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
使用`setPriority()`方法调整线程优先级，优先级1~10取整数，数字越大优先级越高，若设置的优先级不在该范围内，将产生`IllegalArgumentException`
```java
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
### 同步块
使用关键字`synchronized`建立同步块，在同步块中对共享资源进行操作
```java
public class ThreadSafeTest implements Runnable {
    int num = 10;

    public void run() {
        while(true) {
            //同步块
            synchronized("") {
                if(num > 0) {
                    try {
                        Thread.sleep(100);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(--num);
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest test = new ThreadSafeTest();
        Thread threadA = new Thread(test);
        Thread threadB = new Thread(test);
        Thread threadC = new Thread(test);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
```
### 同步方法
在方法之前使用关键字`synchronized`进行修饰，将共享资源的操作写在同步方法中
```java
public class ThreadSafeTest implements Runnable {
    int num = 10;

    public void run() {
        while(true) {
            safe();
        }
    }

    //同步方法
    public synchronized void safe() {
        if(num > 0) {
            try {
                Thread.sleep(100);
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println(--num);
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest test = new ThreadSafeTest();
        Thread threadA = new Thread(test);
        Thread threadB = new Thread(test);
        Thread threadC = new Thread(test);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
```
# 网络通信
## InetAddress
`InetAddress.getLocalHost()` 返回本地主机的InetAddress对象

`host.getHostName()` 获取主机名

`host.getHostAddress()` 获取主机ip地址

使用以上方法可能会抛出`UnknownHostException`异常,表示主机不存在
```java
InetAddress host;
try {
    host = InetAddress.getLocalHost();
    String hostname = host.getHostName();
    String ip = host.getHostAddress();
} catch(UnknownHostException e) {
    e.printStackTrace();
}
```
## 实例
下面的实例实现了客户端与服务器端的通信,客户端接收用户输入的字符串传递给服务器端,服务器端读取字符串,显示在终端上并返回给客户端,客户端接收到服务器端发来的字符串同样显示在终端上,双方接收到".QUIT"时结束通信
### 客户端
```java
import java.net.*;
import java.io.*;

public class ClientTest {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 8001); // 建立连接,ip地址127.0.0.1,端口号8001
            System.out.println("连接已建立");
            DataInputStream in = new DataInputStream(client.getInputStream()); // 建立输入流
            DataOutputStream out = new DataOutputStream(client.getOutputStream()); // 建立输出流
            String line = "";
            while (!line.equalsIgnoreCase(".QUIT")) {
                System.out.println("输入消息:");
                line = readLine();
                System.out.println("正在向服务器发送数据");
                out.writeUTF(line);
                System.out.println("正在等待服务器响应数据");
                line = in.readUTF();
                System.out.println("接收数据:" + line);
            }
            in.close(); // 关闭输入流
            out.close(); // 关闭输出流
            client.close(); // 关闭连接
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readLine() {
        String str = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = in.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return str;
    }
}
```
### 服务器端
```java
import java.net.*;
import java.io.*;

public class ServerTest {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8001); // 建立服务,监听端口号8001
            System.out.println("服务已建立于端口" + server.getLocalPort());
            while (true) {
                Socket connection = server.accept(); // 此时接收到客户端的连接请求,建立连接
                System.out.println("连接已建立");
                DataInputStream in = new DataInputStream(connection.getInputStream()); // 建立输入流
                DataOutputStream out = new DataOutputStream(connection.getOutputStream()); // 建立输出流
                String line = "";
                while (!line.equalsIgnoreCase(".QUIT")) {
                    line = in.readUTF();
                    System.out.println("服务器接收数据:" + line);
                    out.writeUTF(line);
                }
                in.close(); // 关闭输入流
                out.close(); // 关闭输出流
                connection.close(); // 关闭连接
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
```
# 文件I/O
## FileInputStream&FileOutputStream
使用`FileInputStream`类读取文件内容，使用`FileOutputStream`类写入文件
```java
import java.io.*;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("test.txt"); // 建立文件
        try {
            FileOutputStream out = new FileOutputStream(file);// 通过文件创建FileOutputStream对象
            byte[] text = "这是一段测试内容".getBytes();
            out.write(text); // 写入文件
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(file);// 通过文件创建FileInputStream对象
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);// 读取文件内容
            System.out.println(new String(bytes, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
## FileReader&FileWriter
使用上面的文件I/O类只能读写字节型数据，而FileReader类和FileWriter类可以直接对字符进行读写。其中，`FileReader`用于从文件中读取数据，`FileWriter`用于写入文件
```java
import java.io.*;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("test.txt"); // 建立文件
        try {
            FileWriter out = new FileWriter(file);// 通过文件创建FileWriter对象
            String text = "这是一段测试内容";
            out.write(text); // 写入文件
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileReader in = new FileReader(file);// 通过文件创建FileReader对象
            char[] bytes = new char[1024];
            int len = in.read(bytes);// 读取文件内容
            System.out.println(new String(bytes, 0, len));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
## BufferedReader&BufferedWriter
带缓存的文件I/O
```java
import java.io.*;

public class BufferTest {
    public static void main(String[] args) {
        String[] texts = { "第一行数据", "第二行数据", "第三行数据" };
        File file = new File("test.txt"); // 建立文件
        try {
            FileWriter out = new FileWriter(file);// 通过文件创建FileWriter对象
            BufferedWriter buf_out = new BufferedWriter(out);// 通过FileWriter对象创建BufferedWriter对象
            for (int i = 0; i < texts.length; i++) {
                buf_out.write(texts[i]); // 写入文件
                buf_out.newLine(); // 换行
            }
            buf_out.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileReader in = new FileReader(file);// 通过文件创建FileReader对象
            BufferedReader buf_in = new BufferedReader(in);// 通过FileReader对象创建BufferedReader对象
            String s = buf_in.readLine(); // 按行读取文件内容
            while (s != null) {
                System.out.println(s);
                s = buf_in.readLine();
            }
            buf_in.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
## DataInputStream&DataOutputStream
支持多种数据类型的读写方法

包括但不限于：

读：

`readBoolean()`

`readInt()`

`readChar()`

`readByte()`

`readUTF()`

写：

`writeBoolean(boolean b)`

`writeInt(int i)`

`writeChars(String s)`

`writeBytes(String s)`

`writeUTF(String s)`
```java
import java.io.*;

public class DataTest {
    public static void main(String[] args) {
        File file = new File("test.txt"); // 建立文件
        try {
            FileOutputStream out = new FileOutputStream(file);// 通过文件创建FileOutputStream对象
            DataOutputStream data_out = new DataOutputStream(out);// 通过FileOutputStream对象创建DataOutputStream对象
            data_out.writeBoolean(true);
            data_out.writeInt(2);
            data_out.writeChars("测试数据");
            data_out.writeBytes("测试数据");
            data_out.writeUTF("测试数据");
            data_out.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(file);// 通过文件创建FileInputStream对象
            DataInputStream data_in = new DataInputStream(in);// 通过FileInputStream对象创建DataInputStream对象
            System.out.println(data_in.readBoolean());
            System.out.println(data_in.readInt());
            System.out.println(data_in.readChar());
            System.out.println(data_in.readByte());
            System.out.println(data_in.readUTF());
            data_in.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```