package studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Score> list = new ArrayList<>();
        while (true) {
            System.out.println("----------------欢迎来到学生管理系统--------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出");
            System.out.println("请输入您的选择:");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch(choose){
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deletsStudent(list);
                    break;
                case "3":
                    updateStudent(list);
                    break;
                case "4":
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("退出");
                    System.exit(0);
                default:
                    System.out.println("没有这个选项");
            }
        }

    }
    //添加学生
    public static void addStudent(ArrayList<Score> list) {
        Score s = new Score();

        Scanner sc = new Scanner(System.in);
        while (true) {
            while (true) {
                String id = null;
                System.out.println("请输入学生的id");
                id = sc.nextLine();
                boolean flag = contains(list, id);
                if (flag) {
                    System.out.println("id已存在，请重新输入");
                } else {
                    s.setId(id);
                    break;
                    }
                }
                try {
                    System.out.println("请输入学生的姓名");
                    String name = sc.nextLine();
                    s.setName(name);

                    System.out.println("请输入学生的年龄");
                    String ageStr = sc.nextLine();
                    int age = Integer.parseInt(ageStr);
                    s.setAge(age);

                    System.out.println("请输入学生课程");
                    String major = sc.nextLine();
                    s.setMajor(major);

                    System.out.println("请输入学生课程分数");
                    String scoreStr = sc.nextLine();
                    int score = Integer.parseInt(scoreStr);
                    s.setScore(score);

                    break;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (NameFormatException e) {
                    e.printStackTrace();
                } catch (NumberOutException e) {
                    e.printStackTrace();
                }

            }
            list.add(s);
            System.out.println("学生信息添加成功");
        }
    //删除学生
    public static void deletsStudent(ArrayList<Score> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id = sc.next();
        int index = getIndex(list, id);
        if(index >= 0){
            list.remove(index);
            System.out.println("id为" + id + "的学生删除成功");
        }else{
            System.out.println("id不存在，删除失败");
        }
    }
    //修改学生
    public static void updateStudent(ArrayList<Score> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改学生的id");
        String id = sc.next();

        int index = getIndex(list,id);
        if(index == -1){
            System.out.println("要修改的id" + "不存在，请重新输入");
            return;
        }

        Score stu = list.get(index);

        System.out.println("请输入要修改的学生姓名");
        String newName = sc.next();
        stu.setName(newName);

        System.out.println("请输入要修改的学生年龄");
        int newAge = sc.nextInt();
        stu.setAge(newAge);

        System.out.println("请输入要修改的学生课程");
        String newMajor = sc.nextLine();
        stu.setMajor(newMajor);

        System.out.println("请输入要修改的课程分数");
        int newScore = sc.nextInt();
        stu.setScore(newScore);

        System.out.println("学生信息修改成功");
    }
    //查询学生
    public static void queryStudent(ArrayList<Score> list){
        if(list.size() == 0){
            System.out.println("当前无学生信息，请添加后查询");
            return;
        }
        System.out.println("id\t\t\t姓名\t年龄\t课程\t分数");
        for (int i = 0; i < list.size(); i++) {
            Score stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getMajor() + "\t"
                                + stu.getScore());
        }
    }
    //判断id唯一性
    public static boolean contains(ArrayList<Score> list,String id){
        for (int i = 0; i < list.size(); i++) {

            if(list.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    //通过id获取索引
    public static int getIndex(ArrayList<Score> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)){
                return i;
            }

        }
        return -1;
    }

}
