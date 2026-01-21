import java.time.LocalDateTime;

public class Event extends Task {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Event(String description, LocalDateTime startDate, LocalDateTime endDate) {
        super(description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        String startDateOutput = this.startDate.format(this.FORMATTER);
        String endDateOutput = this.endDate.format(this.FORMATTER);
        return String.format("[E]%s (from: %s to: %s)", super.toString(), startDateOutput, endDateOutput);
    }
}
