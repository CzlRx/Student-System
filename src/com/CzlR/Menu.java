package src.com.CzlR;

public class Menu {
    public static void menu() {
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

            String input = StudentManager.scan.next();
            switch (input) {
                case "1":
                    StudentManager.add();
                    break;
                case "2":
                    StudentManager.del();
                    break;
                case "3":
                    StudentManager.set();
                    break;
                case "4":
                    StudentManager.search();
                    break;
                case "5":
                    StudentManager.list();
                    break;
                case "0":
                    System.out.println("感谢使用，再见！");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新选择");
            }
        }
    }

}
