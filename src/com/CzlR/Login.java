package src.com.CzlR;

public class Login {
    public static void login() {
        while (true) {
            System.out.println("""

                    ========== 学生管理系统 ==========
                    1. 登录
                    2. 注册
                    3. 忘记密码
                    0. 退出系统
                    ==================================
                    请选择操作：""");

            String choose = StudentManager.scan.next();
            switch (choose) {
                case "1" -> {
                    int loginstatus = UserManager.login();
                    switch (loginstatus){
                        case 1->{
                            System.out.println("登陆成功！");
                            Menu.menu();
                        }

                        case -1 ->{
                            System.out.println("您已被冻结");
                        }
                    }
                }

                case "2" -> {
                    UserManager.register();
                }

                case "3" -> {
                    UserManager.forgetPasswords();
                }

                case "0" -> {
                    System.exit(0);
                }

                default -> {
                    System.out.println("没有此操作");
                }
            }
        }

    }
}
