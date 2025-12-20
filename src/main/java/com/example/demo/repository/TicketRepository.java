public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCategoryId(Long id);
}