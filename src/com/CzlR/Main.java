package src.com.CzlR;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            
            System.out.println("""
                    ========== 学生管理系统 ==========
                    1. 添加学生
                    2. 删除学生
                    3. 修改学生
                    4. 查询学生
                    5. 显示所有学生
                    0. 退出系统
                    ===================================
                    请选择操作：
                    """);

            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    StudentManager.add();
                    break;    
                case 2:
                    StudentManager.del();
                    break;
                case 3:
                    StudentManager.set();
                    break;
                case 4:
                    StudentManager.search();
                    break;
                case 5:
                    StudentManager.list();
                    break;
                default:
                    System.exit(0);
            }
        }    
    }

}
