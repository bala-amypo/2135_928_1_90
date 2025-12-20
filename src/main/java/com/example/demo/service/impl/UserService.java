@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return repo.save(user);
    }

    public List<User> all() {
        return repo.findAll();
    }
}