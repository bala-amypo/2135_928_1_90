@Entity
public class DuplicateDetectionLog {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Ticket matchedTicket;

    private double matchScore;
    private LocalDateTime detectedAt;
}