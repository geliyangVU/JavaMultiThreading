package Shared_Resource.ThreadSafeExamples;

import java.sql.Connection;
import java.sql.DriverManager;

public class Example4 {

}

class MyServlet extends HttpServlet {
    // Thread safe

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        userService.update();
    }
}

class UserServiceImpl implements UserService {
    // no state change: thread safe

    private UserDao userDao = new UserDaoImpl();

    public void update() {
        userDao.update();
    }

}

class UserDaoImpl implements UserDao {

    // Dao thread safe: no member variable to share
    public void update() {
        String sql = "";
        try (Connection conn = DriverManager.getConnection(sql)) {

        } catch (Exception e) {
        }
    }
}