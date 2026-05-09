# CLAUDE.md

## 项目简介
控制台学生管理系统，纯 Java，数据存内存（ArrayList），程序退出即丢失。

## 技术约束
- JDK 8+
- 不依赖第三方库
- `Scanner` 全局只用一个实例（`StudentManager.scan`），不要在别处再 new Scanner(System.in)
- 字符串比较必须用 `.equals()`，不要用 `==` 或 `!=`

## 项目结构
```
src/com/CzlR/
├── Main.java           ← 入口 + 菜单交互
├── Student.java        ← 学生实体类
├── StudentManager.java ← 核心业务逻辑（增删改查）
```

## 实体类 Student 字段
| 字段 | 类型 | 说明 |
|------|------|------|
| id | String | 学号 |
| name | String | 姓名 |
| age | int | 年龄 |
| gender | String | 性别 |
| major | String | 专业 |

## 关键约定
- 年龄校验范围：1 ~ 150
- 性别只能填 "男" 或 "女"
- 学号、姓名、专业不能为空
- 修改学生时，用 `scan.nextLine()` 读取以实现回车跳过
- 从 `nextInt()` 切换到 `nextLine()` 前，需要多调用一次 `nextLine()` 清理换行符

## 验证命令
```
javac -d out src/com/CzlR/*.java && java -cp out src.com.CzlR.Main
```
