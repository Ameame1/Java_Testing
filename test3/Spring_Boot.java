//Main Application Class
@SpringBootApplication
public class SocialMediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialMediaApplication.class, args);
    }

}

//Controller Class for User Profile
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}

//Service Class for User Profile
@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(Long userId) {
        return userList.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }

    public User createUser(User user) {
        user.setId(System.currentTimeMillis());
        userList.add(user);
        return user;
    }

    public User updateUser(Long userId, User user) {
        User existingUser = getUserById(userId);
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        return existingUser;
    }

    public void deleteUser(Long userId) {
        User existingUser = getUserById(userId);
        userList.remove(existingUser);
    }

}

//Model Class for User Profile
@Data
public class User {
    private Long id;
    private String name;
    private int age;
}
