package Shared_Resource.ThreadSafeExamples;

import javax.sound.midi.SysexMessage;

public class Example3 {

}

// @Aspect
// @Component
class MyAspect {

    // Not thread safe(AOP in Spring framework)
    private long start = 0L;

    @Before("execution")
    public void before() {
        start = System.nanoTime();
    }

    @After("execution")
    public void after() {
        long end = System.nanoTime();
        System.out.println("Cost time:" + (end - start));
    }
}