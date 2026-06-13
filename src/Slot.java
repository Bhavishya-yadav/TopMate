import java.time.LocalDateTime;

public class Slot {
    private String slotId;
    private LocalDateTime startTime, endTime;
    private SlotStatus slotStatus;
    private Customer customer;
    public Slot(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotStatus = SlotStatus.AVAILABLE;
        this.customer = null;
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
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    
    
}
