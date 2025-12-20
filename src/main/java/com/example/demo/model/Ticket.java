@Entity
public class Ticket {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private TicketCategory category;

    private String subject;
    private String description;
    private String status = "OPEN";
    private LocalDateTime createdAt;
}