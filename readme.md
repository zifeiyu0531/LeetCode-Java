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
## StringBuilder
bf.append(Object obj) 向字符串中追加内容
bf.insert(int offset, Object obj) 向指定位置插入内容
bf.delete(int start, int end) 删除指定位置的子串
```Java
StringBuilder bf = new StringBuilder("hello");
bf.append("world");
bf.insert(5, " ");
bf.delete(3, 6);
System.out.println(bf.toString());
```