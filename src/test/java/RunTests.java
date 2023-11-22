public class RunTests {
    private UserServiceTest test = new UserServiceTest();
    public void runTests()
    {
        test.dropUsersTable();
        test.createUsersTable();
        test.cleanUsersTable();
        test.saveUser();
        test.getAllUsers();
        test.removeUserById();
    }
}
