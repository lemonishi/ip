package yeetman.task;

import java.time.LocalDateTime;

public class Event extends Task {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    /**
     * Instantiates a new Event instance.
     *
     * @param description Description of the event.
     * @param startDate Start date of the event.
     * @param endDate End date of the event.
     */
    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        String startDateOutput = this.startDate.format(FORMATTER);
        String endDateOutput = this.endDate.format(FORMATTER);
        return String.format("[E]%s (from: %s to: %s)", super.toString(), startDateOutput, endDateOutput);
    }
}
