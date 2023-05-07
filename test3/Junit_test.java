public class UserServiceTests {

    @Test
    public void testCreateUser() {
        UserService userService = new UserService();
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);
        User createdUser = userService.createUser(user);
        Assert.assertNotNull(createdUser.getId());
        Assert.assertEquals(user.getName(), createdUser.getName());
        Assert.assertEquals(user.getAge(), createdUser.getAge());
    }

    @Test(expected = UserNotFoundException.class)
    public void testGetNonexistentUserById() {
        UserService userService = new UserService();
        userService.getUserById(1L);
    }

    @Test
    public void testUpdateUser() {
        UserService userService = new UserService();
        User user = new User();
        user.setName("John Doe");
        user.setAge(30);
        User createdUser = userService.createUser(user);
        User updatedUser = new User();
        updatedUser.setName("Jane Doe");
        updatedUser.setAge(25);
        User savedUser = userService.updateUser(createdUser.getId(), updatedUser);
        Assert.assertEquals(updatedUser.getName(), savedUser.getName());
        Assert.assertEquals(updatedUser.getAge(), savedUser.getAge());
    }

    @Test(expected = UserNotFoundException.class)
    public void testDeleteNonexistentUser() {
        UserService userService = new UserService();
        userService.deleteUser(1L);
    }

}
