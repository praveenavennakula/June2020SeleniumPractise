package testngsessions;

import org.testng.annotations.Test;

public class DependsonMethodConcept {
    //AAA in unit test
    //Arrange, Act, and Assert

    public void createAUser() {
        System.out.println("creating a user");
    }

    @Test
    public void a_createUser() {
        System.out.println("create user");//100
        createAUser();//100
        //int i = 9/0;
    }
//Case1---using dependsOnMethods(not recommended)

//	@Test(dependsOnMethods = "a_createUser")
//	public void updateUser() {
//		System.out.println("update user");
//
//	}
//
//	@Test(dependsOnMethods = "a_createUser")
//	public void deleteUser() {
//		System.out.println("delete user");
//
//	}

    //if application crashes, when createuser is executing , the dependant methods are ignored and skipped.
    //it's a bad practise to use dependsonMethods ,because each test must be independent.
    //better approach is to call createUser method in the dependant methods as shown below.
    //Case2---calling depends on method
    @Test()
    public void updateUser() {
        createAUser();//101
        System.out.println("update user");//101

    }

    @Test()
    public void deleteUser() {
        createAUser();//201
        System.out.println("delete user");//201

    }


}
