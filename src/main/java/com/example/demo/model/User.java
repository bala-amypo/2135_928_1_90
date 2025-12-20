@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;
}