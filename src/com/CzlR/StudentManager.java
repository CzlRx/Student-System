package src.com.CzlR;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    static ArrayList<Student> StudentList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void add() {
        Student student = new Student();
        boolean flag = true;
        while (flag) {
            System.out.println("学号：");
            student.setId(scan.next());
            flag = false;
            if (!StudentList.isEmpty()) {
                for (int i = 0; i < StudentList.size(); i++) {
                    if (StudentList.get(i).getId().equals(student.getId())) {
                        System.out.println("学号已存在，添加失败");
                        flag = true;
                        break;
                    }
                }
            }
        }

        flag = true;
        while (flag) {
            System.out.println("姓名：");
            student.setName(scan.next());
            flag = false;
            if (student.getName().equals("")) {
                System.out.println("姓名不能为空");
                flag = true;
            }
        }

        flag = true;
        while (flag) {
            System.out.println("年龄：");
            student.setAge(scan.nextInt());
            flag = false;
            if (student.getAge() < 1 || student.getAge() > 150) {
                System.out.println("年龄不合法");
                flag = true;
            }
        }

        flag = true;
        while (flag) {
            System.out.println("性别：");
            student.setGender(scan.next());
            flag = false;
            if (!student.getGender().equals("男") && !student.getGender().equals("女")) {
                System.out.println("性别不合法");
                flag = true;
            }
        }

        flag = true;
        while (flag) {
            System.out.println("专业：");
            student.setMajor(scan.next());
            flag = false;
            if (student.getMajor().equals("")) {
                System.out.println("专业不能为空");
                flag = true;
            }
        }

        StudentList.add(student);
        System.out.println("添加成功");
    }

    public static void del() {
        System.out.println("请输入学生学号：");
        boolean flag = false;
        int index = 0;
        String id = scan.next();
        if (!StudentList.isEmpty()) {
            for (int i = 0; i < StudentList.size(); i++) {
                if (StudentList.get(i).getId().equals(id)) {
                    System.out.println("查询到的学生数据如下：");
                    System.out.println(StudentList.get(i).toString());
                    index = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("未找到该学生");
            }
        } else {
            System.err.println("暂无学生数据");
        }
        if (flag) {
            System.out.println("您确定要删除吗？（Y/N）：");
            String ensure = scan.next();
            switch (ensure) {
                case "Y", "y" -> {
                    StudentList.remove(index);
                    System.out.println("删除成功！");
                }
                case "N", "n" -> {
                    System.out.println("已取消删除");
                }
                default -> {
                    System.out.println("请正确输入Y/N！！");
                }
            }

        }

    }

    public static void set() {
        if (!StudentList.isEmpty()) {
            System.out.println("请输入学号");
            int index = 0;
            boolean flag = false;
            String id = scan.next();
            for (int i = 0; i < StudentList.size(); i++) {
                if (StudentList.get(i).getId().equals(id)) {
                    System.out.println("查询到的学生数据如下：");
                    System.out.println(StudentList.get(i).toString());
                    index = i;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("未找到该学生");
            }
            if (flag) {

                System.out.println("请输入新的名：");
                scan.nextLine();
                String newname = scan.nextLine();
                if (!newname.equals("")) {
                    StudentList.get(index).setName(newname);
                }

                boolean flag1 = true;
                while (flag1) {
                    System.out.println("请输入新的年龄：");
                    String input = scan.nextLine();
                    if (!input.equals("")) {
                        int newage = Integer.parseInt(input);
                        if (newage < 1 || newage > 150) {
                            System.out.println("新年龄不合法！");
                        } else {
                            StudentList.get(index).setAge(newage);
                            flag1 = false;
                        }
                    } else {
                        flag1 = false;
                    }
                }

                boolean flag2 = true;
                while (flag2) {
                    System.out.println("请输入新的性别：");
                    String newgender = scan.nextLine();
                    if (!newgender.equals("")) {
                        if (!newgender.equals("男") && !newgender.equals("女")) {
                            System.out.println("新性别不合法！");
                        } else {
                            StudentList.get(index).setGender(newgender);
                            flag2 = false;
                        }
                    } else {
                        flag2 = false;
                    }
                }

                System.out.println("请输入新的专业：");
                String newmajor = scan.nextLine();
                if (!newmajor.equals("")) {
                    StudentList.get(index).setMajor(newmajor);
                }

                System.out.println("修改完成");

            }

        } else {
            System.out.println("暂无数据");
        }
    }

    public static void search() {
        if (!StudentList.isEmpty()) {
            System.out.println("""
                    ---------- 查询学生 ----------
                    1. 按学号查询
                    2. 按姓名查询
                    3. 返回主菜单
                    -------------------------------
                    请选择：
                    """);
            String choose = scan.next();
            switch (choose) {
                case "1" -> {
                    System.out.println("请输入学生学号：");
                    boolean flag = false;
                    String id = scan.next();
                    if (!StudentList.isEmpty()) {
                        for (int i = 0; i < StudentList.size(); i++) {
                            if (StudentList.get(i).getId().equals(id)) {
                                System.out.println("查询成功，您查找到的学生数据如下：");
                                System.out.println(StudentList.get(i).toString());
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            System.out.println("未找到该学生");
                        }
                    } else {
                        System.err.println("暂无学生数据");
                    }
                }
                case "2" -> {
                    System.out.println("请输入学生姓名：");
                    boolean flag = false;
                    int cnt = 0;
                    scan.nextLine();
                    String name = scan.nextLine();
                    if (!StudentList.isEmpty()) {
                        for (int i = 0; i < StudentList.size(); i++) {
                            if (StudentList.get(i).getName().contains(name)) {
                                if (cnt == 0)
                                    System.out.println("查询成功，找到匹配的学生如下：");
                                System.out.println(StudentList.get(i).toString());
                                flag = true;
                                cnt++;
                            }
                        }
                        if (!flag) {
                            System.out.println("未找到任何匹配学生");
                        }
                    } else {
                        System.err.println("暂无学生数据");
                    }
                }

                case "3" -> {
                }

            }

        } else {
            System.err.println("暂无学生数据");
        }

    }

    public static void list() {
        if (StudentList.isEmpty()) {
            System.out.println("暂无学生数据");
        } else {
            System.out.println("""
                    学号      姓名      年龄      性别      专业
                    --------------------------------------------------
                    """);
            for (int i = 0; i < StudentList.size(); i++) {
                System.out.println(StudentList.get(i).toString());
            }
        }
    }

}
