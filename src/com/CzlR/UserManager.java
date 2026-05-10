package src.com.CzlR;

import java.util.*;

public class UserManager {
    // 用来存储用户信息
    static List<User> UserList = new ArrayList<>();

    // 登陆
    public static int login() {

        int index = -1;
        int cnt = 0;
        boolean flag = true;
        loop: while (flag) {
            if (cnt != 3) {
                // 判断用户名是否存在
                System.out.println("请输入用户名：");
                String username = StudentManager.scan.next();
                System.out.println("请输入密码：");
                String inputpasswords = StudentManager.scan.next();
                for (int i = 0; i < UserList.size(); i++) {
                    index = -1;
                    if (UserList.get(i).getUsername().equals(username)) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("没有此用户！");
                    continue;
                }

                // 判断密码是否正确

                String rightpasswords = UserList.get(index).getPasswords();
                // 判断密码正确首先要正确输入验证码
                while (true) {
                    String code = getCode(); // 获取验证码
                    System.out.println("您的验证码是：" + code);
                    System.out.println("请输入验证码:");
                    String inputcode = StudentManager.scan.next();
                    if (inputcode.equalsIgnoreCase(code)) {
                        if (!inputpasswords.equals(rightpasswords)) {
                            if (cnt != 2) {
                                System.out.println("用户名或密码错误,你还有" + (2 - cnt) + "次机会");
                            } else {
                                System.out.println("密码错误");
                            }
                            cnt++;
                            continue loop;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("验证码错误");
                    }
                }
            } else {
                System.out.println("你输入错误密码次数过多，已被冻结");
                return -1;
            }
            flag = false;
        }

        return 1;
    }

    // 注册
    public static void register() {

        // 创建对象
        User user = new User();

        boolean flag = true;
        // 读取用户名
        String username = new String();
        loop: while (flag) {
            System.out.println("用户名:");
            username = StudentManager.scan.next();
            // 检验用户名是否存在
            for (int i = 0; i < UserList.size(); i++) {
                if (UserList.get(i).getUsername().equals(username)) {
                    System.out.println("用户名已存在");
                    continue loop;
                }
            }
            // 检验用户名长度是否大于3小于15
            if (username.length() <= 3 || username.length() >= 15) {
                System.out.println("用户名长度有误");
                continue loop;
            }
            // 检验用户名可以是数字加字符，但不能纯数字
            int cnt = 0;
            for (int i = 0; i < username.length(); i++) {
                char c = username.charAt(i);
                // 检验username是否在字母和数字里
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                } else {
                    System.out.println("请使用字母加数字");
                    continue loop;
                }
                // 检验username不能为纯数字
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                    cnt++;
                }
            }
            if (cnt == 0) {
                System.out.println("请勿使用纯数字");
                flag = true;
                continue loop;
            }
            flag = false;
        }

        // 读取密码
        String passwords1 = new String();
        String passwords2 = new String();
        boolean flag1 = true;
        while (flag1) {
            flag1 = false;
            System.out.println("密码：");
            passwords1 = StudentManager.scan.next();
            System.out.println("再次输入密码：");
            passwords2 = StudentManager.scan.next();
            if (!passwords1.equals(passwords2)) {
                System.out.println("两次密码不一致");
                flag1 = true;
            }
        }

        // 读取身份证
        boolean flag2 = true;
        String id = new String();
        loop1: while (flag2) {
            System.out.println("身份证：");
            id = StudentManager.scan.next();
            // 验证身份证长度是否合法
            if (id.length() > 18 || id.length() < 18) {
                System.out.println("身份证长度有误");
                continue;
            }
            // 身份证只有最后一位可以为X其他必须纯数字
            for (int i = 0; i < 17; i++) {
                if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
                    System.out.println("身份证格式有误");
                    continue loop1;
                }
            }
            if (id.charAt(17) != 'X' && !(id.charAt(17) >= '0' && id.charAt(17) <= '9')) {
                System.out.println("身份证格式有误");
                continue loop1;
            }
            flag2 = false;
        }

        // 读取手机号
        String phonenumber = new String();
        boolean flag3 = true;
        loop2: while (flag3) {
            System.out.println("手机号：");
            phonenumber = StudentManager.scan.next();
            // 判断手机号为u数字
            for (int i = 0; i < phonenumber.length(); i++) {
                if (!(phonenumber.charAt(i) >= '0' && phonenumber.charAt(i) <= '9')) {
                    System.out.println("格式有误");
                    continue loop2;
                }
            }
            // 判断手机号长度合法
            if (phonenumber.length() < 11 || phonenumber.length() > 11) {
                System.out.println("长度有误");
                continue;
            }
            flag3 = false;
        }

        // 将创建好的对象存入集合
        user.setId(id);
        user.setUsername(username);
        user.setPasswords(passwords1);
        user.setPhonenumber(phonenumber);
        UserList.add(user);
        System.out.println("注册成功！");
    }

    public static void forgetPasswords() {
        //先读入你要查找的用户名，如果不存在重新输入
        String username = new String();
        while (true) {
            System.out.println("输入你的账户名："); 
            username = StudentManager.scan.next();
            if (!contains( username)) {
                System.out.println("暂无此账户");
            } else {
                break;
            }
        }
        int index = findIndex(username);  

        //输入绑定的身份证和手机号
        while(true){
        System.out.println("请输入账号所绑定的身份证：");
        String id = StudentManager.scan.next();
        System.out.println("请输入账户所绑定的手机号：");
        String phonenumber = StudentManager.scan.next();
          
        if(!(UserList.get(index).getId().equals(id) && UserList.get(index).getPhonenumber().equals(phonenumber))){
            System.out.println("身份证或手机号与用户名所绑定不一致");
        }else{
            break;
        }}


        //两项都要匹配才可以修改密码

        
        String newpasswords1 = new String();
        
        String newpasswords2 = new String();
        while(true){
            System.out.println("请输入新密码：");
            newpasswords1 = StudentManager.scan.next();
            System.out.println("请确认密码：");
            newpasswords2 = StudentManager.scan.next();
            if(newpasswords1.equals(newpasswords2)){
                UserList.get(index).setPasswords(newpasswords1);
                System.out.println("新密码设置成功！");
                break;
            }else{
                System.out.println("两次输入密码不一致");
            }
        }
        


        //修改密码同样输入两次，一致后提示修改成功

    }
    
    public static String getCode() {

        List<Character> chartable = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            chartable.add((char) ('a' + i));
            chartable.add((char) ('A' + i));
        }
        Random r = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < 4; ++i) {
            index = r.nextInt(chartable.size());
            stringBuilder.append(chartable.get(index));
        }
        index = r.nextInt(5);
        int num = r.nextInt(10);
        stringBuilder.insert(index, String.valueOf(num));
        return stringBuilder.toString();
    }

    public static boolean contains(String username){
        for(int i = 0; i < UserList.size(); i++){
            if(UserList.get(i).getUsername().equals(username)){
                return true;
            }
        }

        return false;
    }


    public static int findIndex(String username){
        for(int i = 0; i < UserList.size(); i++){
            if(UserList.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    } 


}



