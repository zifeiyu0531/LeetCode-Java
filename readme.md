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
collection.iterator() 返回用于遍历对象的迭代器
```Java
Collection<String> list = new ArrayList<>();
list.add("a");
list.add("b");
list.add("c");
Iterator<String> it = list.iterator();
while(it.hasNext()){
    String str = (String) it.next();
    System.out.println(str);
}
```