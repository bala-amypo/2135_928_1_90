@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketRepository ticketRepo;
    private final DuplicateDetectionService detectionService;

    public TicketController(TicketRepository t, DuplicateDetectionService d) {
        this.ticketRepo = t;
        this.detectionService = d;
    }

    @PostMapping
    public Ticket create(@RequestBody Ticket ticket) {
        ticket.setCreatedAt(LocalDateTime.now());
        Ticket saved = ticketRepo.save(ticket);
        detectionService.detectDuplicates(saved);
        return saved;
    }

    @GetMapping
    public List<Ticket> all() {
        return ticketRepo.findAll();
    }
}