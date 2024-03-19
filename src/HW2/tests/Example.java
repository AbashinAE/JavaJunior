package HW2.tests;

import HW2.annotations.AfterAll;
import HW2.annotations.AfterEach;
import HW2.annotations.BeforeAll;
import HW2.annotations.Test;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.BeforeEach;

@NoArgsConstructor
public class Example {
    @BeforeAll
    public void beforeAll() {
        System.out.println("before all methods");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("after all methods");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before method");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after methods");
    }

    @org.junit.Test
    @Test(order = 1)
    public void testOne() {
        System.out.println("test1");
    }


    @org.junit.Test
    @Test(order = 2)
    public void testThree() {
        System.out.println("test3");
    }

    @org.junit.Test
    @Test(order = 3)
    public void testTwo() {
        System.out.println("test2");
    }

}