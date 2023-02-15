package accumulate.stream;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamExample {

    @Data
    static class Person {
        int id;
        String name;
        String sex;
        float height;
        int salary;
        int age;

        public Person(int id, String name, String sex, float height) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.height = height;
        }

        public Person(String name, int age, int salary) {
            this.age = age;
            this.name = name;
            this.salary = salary;
        }
    }

    /**
     * 构造数据
     *
     * @return
     */
    public static List<Person> constructPersons() {

        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 5; i++) {
            Person p = new Person(i, "name" + i, "sex" + i, i);
            persons.add(p);
        }
        return persons;
    }

    /**
     * for
     *
     * @param persons
     */
    public static void doFor(List<Person> persons) {
        long start = System.currentTimeMillis();

        for (Person p : persons) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(p.name);
        }

        long end = System.currentTimeMillis();
        System.out.println("doFor cost:" + (end - start));
    }

    /**
     * 顺序流
     *
     * @param persons
     */
    public static void doStream(List<Person> persons) {
        long start = System.currentTimeMillis();

        persons.stream().forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(x.name);
        });

        long end = System.currentTimeMillis();
        System.out.println("doStream cost:" + (end - start));
    }

    /**
     * 并行流
     *
     * @param persons
     */
    public static void doParallelStream(List<Person> persons) {

        long start = System.currentTimeMillis();

        persons.parallelStream().forEach(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(x.name);
        });

        long end = System.currentTimeMillis();

        System.out.println("doParallelStream cost:" + (end - start));
    }

    public static void main(String[] args) {
//        testParallelStream();
//        streamFasterThanParallel();
//        apiTest();
        example();
    }

    private static void apiTest() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);

        //名字最长的
        List<String> namelist = Arrays.asList("zhangsan", "lisi", "wangwu", "sunliu");
        Comparator<? super String> comparator = Comparator.comparing(String::length);
        Optional<String> max = namelist.stream().max(comparator);
        System.out.println(max);

        //名字转化
        namelist.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        namelist.stream().map(t->t.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
        namelist.stream().forEach(t->t.toUpperCase());


        //规约reduce,归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
        List<Integer> listNum = Arrays.asList(1, 2, 3, 4);
        //求和
        Optional<Integer> reduce = listNum.stream().reduce((x,y) -> x+ y);
        System.out.println("求和:"+reduce);
        //求积
        Optional<Integer> reduce2 = listNum.stream().reduce((x,y) -> x * y);
        System.out.println("求积:"+reduce2);
        //求最大值
        Optional<Integer> reduce3 = listNum.stream().reduce((x,y) -> x>y?x:y);
        System.out.println("求最大值:"+reduce3);

        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        //计算两个list中的差集
        List<Integer> reduce1 = list.stream().filter(item -> !list.contains(item)).collect(Collectors.toList());

    }

    static List<Person> personList = new ArrayList<Person>();
    private static void initPerson() {
        personList.add(new Person("张三", 8, 3000));
        personList.add(new Person("李四", 18, 5000));
        personList.add(new Person("王五", 28, 7000));
        personList.add(new Person("孙六", 38, 9000));
        personList.add(new Person("朱七", 18, 8000));

    }
    private static void example() {
        initPerson();
        //大于18岁的员工
        List<Person> collect = personList.stream().filter(x -> x.getAge()>=18).collect(Collectors.toList());
        collect.stream().forEach(x->{
            System.out.println(x.getAge());
        });

        //大于8000元的员工
        List<Person> collect2 = personList.stream().filter(x -> x.getSalary()>8000).collect(Collectors.toList());
        collect2.stream().forEach(x->{
            System.out.println(x.getSalary());
        });

        //年龄最大的员工
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getAge));
        System.out.println(max);

        //某员工涨工资
        List<Person> salaryUp = personList.stream().map(x -> {
            if(x.name.contains("张")) x.setSalary(x.getSalary()+2000);
            return x;
        }).collect(Collectors.toList());
        System.out.println(salaryUp);

        //工资之和
        Optional<Integer> reduce = personList.stream().map(Person :: getSalary).reduce(Integer::sum);
        System.out.println("工资之和:"+reduce);

        //最高工资
        Optional<Integer> reduce2 = personList.stream().map(Person :: getSalary).reduce(Integer::max);
        System.out.println("最高工资:"+reduce2);

        //年龄大于18的姓名，员工Map数据结构
        Map<String, Person> name2Persion = personList.stream().filter(x -> x.getAge() > 18).collect(Collectors.toMap(Person::getName, y -> y));
        System.out.println(collect);

        //统计员工人数
        Long count = personList.stream().collect(Collectors.counting());
        //求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        //求最高工资
        Optional<Integer> maxSalary= personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        //求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        //一次性统计所有信息
        DoubleSummaryStatistics statistics = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按名字分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getName)));

//        joining可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。
        String names = personList.stream().map(x->x.getName()).collect(Collectors.joining(","));

        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
                .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
    }

    private static void streamFasterThanParallel() {
        Stream<Integer> stream = Stream.generate(() -> new Random().nextInt()).limit(5000000);
        List<Object> list = Arrays.asList(stream.toArray());

        long time2 = System.currentTimeMillis();
        long count2 = list.parallelStream().mapToInt(x -> (Integer) x).map(x -> x / 2).filter(x -> x % 2 == 0).count();
        System.out.println("count: " + count2 + ",parallelStream waste: " + (System.currentTimeMillis() - time2));

        long time = System.currentTimeMillis();
        long count = list.stream().mapToInt(x -> (Integer) x).map(x -> x / 2).filter(x -> x % 2 == 0).count();
        System.out.println("count: " + count + ",stream waste: " + (System.currentTimeMillis() - time));

    }

    private static void testParallelStream() {
        List<Person> persons = constructPersons();
        doFor(persons);
        doStream(persons);
        doParallelStream(persons);
    }
}
