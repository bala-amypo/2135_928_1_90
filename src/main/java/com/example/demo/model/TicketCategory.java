@Entity
public class TicketCategory {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String categoryName;
    private String description;
}