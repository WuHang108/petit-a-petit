# 算法题中经常用到的Java库函数写法

## java.util.Arrays类
对数组arr排序：
```java
Arrays.sort(arr)
```
查找数组arr中的某个元素obj：
```java
Arrays.binarySearch(arr, obj)
```
将整型数组arr每个元素初始化为-1：
```java
Arrays.fill(arr, -1);
```

## java.util.PriorityQueue类
自定义比较
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;//升序排列
    }
}
```

## Scanner类
读取字符串
```java
sc.next();
```
