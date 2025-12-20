@Entity
public class DuplicateRule {
    @Id @GeneratedValue
    private Long id;
    private String ruleName;
    private String matchType; // KEYWORD, SIMILARITY, EXACT_MATCH
    private double threshold;
}