package com.example.demo.service;

import com.example.demo.model.Ticket;
import java.util.List;

public interface DuplicateDetectionService {

    boolean isDuplicateTicket(Ticket ticket);

    void detectDuplicates(Long ticketId);

    List<String> getLogsForTicket(Long ticketId);

    String getLog(Long logId);
}
