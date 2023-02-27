package Shared_Resource.ThreadSafeExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example5 {

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

    // Note: Make connection a private variable in method to make it thread safe.

    // Not thread safe: Correct implementation shown in Example 4
    private Connection conn = null;

    // Dao thread safe: no member variable to share
    public void update() throws SQLException {
        String sql = "";
        try (Connection conn = DriverManager.getConnection(sql)) {

        } catch (Exception e) {
        }
    }
}