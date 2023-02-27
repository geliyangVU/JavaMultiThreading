package Shared_Resource.ThreadSafeExamples;

import java.util.HashMap;
import java.util.Map;

public class Example1 {

}

class Myservlet extends HttpServlet {

    // HashMap is not thread-safe
    Map<String, Object> map = new HashMap<>();

    // String is Immutable thus thread-safe
    String S1 = "...";

    // Thread-safe
    final String S2 = "xxx";

    // Date is not thread-safe, will be shared among multiple threads.
    Date Date1 = new Date();

    // D2 is immutable, but Date object is mutable
    final Date D2 = new Date();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //
    };

}
