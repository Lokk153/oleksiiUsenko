package lesson17;

//тест на логин, должен принимать
// имя пользователя,
// его пароль
// роль.
// Тестовые данные нужно сгенерировать через dataprovider. этот тест нужно добавить в группу

//второй тест, который зависит от группы первого теста. тестовые данные в датапровайдере можно менять вручную так,
//чтобы логин-тест фейлился при определённых условиях. посмотреть, как будет при этом запускаться этот зависимый тест.


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestLogin {

    @DataProvider(name = "users")
    public Object[][] users() {
        String[][] users = {
                {"Oleg", "admin", "superAdmin"},
                {"Ihor", "Qwerty_123", "manager"},
                {"Peter", "Qwerty", "user"}
        };
        return users;
    }

    @Test(groups = {"login"}, dataProvider = "users", priority = 10)
    public void checkEmptyFields(String userName, String userPassword, String userRole) {

        if (userName.equals("") || userPassword.equals("")) {
            throw new NullPointerException("Не введены имя или пароль");
        }
        System.out.println("Выберете роль " + userRole);
    }

    @Test(dependsOnGroups = "login", dataProvider = "users", priority = 20)
    public void checkPassword(String userName, String userPassword, String userRole) {
        if (userRole.equals("superAdmin") && userPassword.equals("admin")) {
            System.out.println("Добро пожаловать, " + userName);
        } else if (userRole.equals("manager") && userPassword.equals("Qwerty_123")) {
            System.out.println("Добро пожаловать, " + userName);
        } else if (userRole.equals("user") && userPassword.equals("Qwerty")) {
            System.out.println("Добро пожаловать, " + userName);
        } else {
            throw new NullPointerException("Неверный логин или пароль");
        }
    }

    @Test(priority = 30)
    @Parameters("value")
    public void printPrams(String value) {
        System.out.println("Parameterized value is : " + value);
    }
}
