public class TestLogin {

    public static void main(String[] args) {

        boolean result = LoginService.login("admin", "12345");

        if(result) {

            System.out.println("Login Success");

        }
        else {

            System.out.println("Login Failed");

        }

    }

}