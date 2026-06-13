import java.time.LocalDateTime;

public class Slot {
    private String slotId;
    private LocalDateTime startTime, endTime;
    private SlotStatus slotStatus;

    public Slot(LocalDateTime startTime, LocalDateTime endTime, String slotId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotStatus = SlotStatus.CREATED;
        this.slotId = slotId;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public SlotStatus getSlotStatus() {
        return slotStatus;
    }
    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }
    public String getSlotId() {
        return slotId;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", slotStatus=" + slotStatus +
                '}';
    }
    
}
