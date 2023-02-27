package Shared_Resource.ThreadSafeExamples;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class Example2 {

}

class MyServlet extends HttpServlet {
    // Not Thread-safe because UserService will be shared among multiple threads in
    // MyServlet class
    private UserServiceImpl userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        userService.update();
    }

}

class UserServiceImpl implements UserService {
    private int count = 0;

    public void update() {
        // not thread safe
        count++;
    }

}