@RestController
@RequestMapping("/api/categories")
public class TicketCategoryController {
    private final TicketCategoryService service;

    public TicketCategoryController(TicketCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public TicketCategory create(@RequestBody TicketCategory c) {
        return service.create(c);
    }

    @GetMapping
    public List<TicketCategory> all() {
        return service.all();
    }
}