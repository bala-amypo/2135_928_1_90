@Service
public class TicketCategoryService {
    private final TicketCategoryRepository repo;

    public TicketCategoryService(TicketCategoryRepository repo) {
        this.repo = repo;
    }

    public TicketCategory create(TicketCategory c) {
        return repo.save(c);
    }

    public List<TicketCategory> all() {
        return repo.findAll();
    }
}