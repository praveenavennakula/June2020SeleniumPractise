package testngsessions;

import org.testng.annotations.Test;

public class InvocationCount {
    @Test(invocationCount = 10)//used for creating number of users in performance testing
    public void a_createUser() {
        System.out.println("create user");

    }
}
