@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {
    private final DuplicateDetectionLogRepository repo;

    public DuplicateDetectionController(DuplicateDetectionLogRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/logs")
    public List<DuplicateDetectionLog> logs() {
        return repo.findAll();
    }
}