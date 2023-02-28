import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!"); //用户名及密码
        String username = "123456798";
        String passward = "123456";
        //键盘输入
        for (int i=0;i<3;i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String s1 = scanner.nextLine();
            System.out.println("请输入密码:");
            String s2 = scanner.nextLine();
            if (s1.equals(username) && s2.equals(passward)){
                //&&:逻辑与运算符,将两个表达式连接成一个。两个表达式必须都为 true，整个表达式才为 true
                System.out.println("登录成功");
                break;
            }else if (2-i == 0){
                System.out.println("输入次数已达上限，请五分钟后再试");
            }else {    //2,1,0   i:0,1,2
                System.out.println("登录失败，你还有"+(2-i)+"次机会");
            }
        }

    }
}