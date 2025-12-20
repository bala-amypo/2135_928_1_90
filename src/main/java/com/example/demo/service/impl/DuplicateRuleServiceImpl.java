@Service
public class DuplicateRuleService {
    private final DuplicateRuleRepository repo;

    public DuplicateRuleService(DuplicateRuleRepository repo) {
        this.repo = repo;
    }

    public DuplicateRule create(DuplicateRule r) {
        return repo.save(r);
    }

    public List<DuplicateRule> all() {
        return repo.findAll();
    }
}