@RestController
@RequestMapping("/api/rules")
public class DuplicateRuleController {
    private final DuplicateRuleService service;

    public DuplicateRuleController(DuplicateRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DuplicateRule create(@RequestBody DuplicateRule r) {
        return service.create(r);
    }

    @GetMapping
    public List<DuplicateRule> all() {
        return service.all();
    }
}