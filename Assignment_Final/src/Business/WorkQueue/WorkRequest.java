/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private String Location;
    private UserAccount sender;
    private Organization receiver;
    private UserAccount assignee;
    private NewsRequest event;
    private Date requestDate;
    private Date assignDate;
    private Date resolveDate;
    private String feedback;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public enum Status {
        Ordered("Ordered"),
        Accepted("Accepted"),
        Cancelled("Cancelled"),
        Completed("Completed");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private Status status;

    public WorkRequest() {
        requestDate = new Date();
        status = Status.Ordered;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        setRequestDate(new Date());
        if (this.sender != null) {
            this.sender.getEmployee().getWorkQueue().getWorkRequestList().remove(this);
        }
        this.sender = sender;
        sender.getEmployee().getWorkQueue().getWorkRequestList().add(this);
    }

    public Organization getReceiver() {
        return receiver;
    }

    public void setReceiver(Organization receiver) {
        if (this.receiver != null) {
            this.receiver.getWorkQueue().getWorkRequestList().remove(this);
        }
        this.receiver = receiver;
        receiver.getWorkQueue().getWorkRequestList().add(this);
    }

    public void setResidentReceiver(Organization receiver) {
        if (this.receiver != null) {
            this.receiver.getWorkQueue().getWorkRequestList().remove(this);
        }
        this.receiver = receiver;
        receiver.getWorkQueue().getWorkRequestList().add(this);
    }

    public Status getStatus() {
        return status;
    }

    public String getStatusString() {
        return status.getValue();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public String getRequestDateString() {
        return requestDate == null ? "N/A" : dateFormat.format(requestDate);
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getResolveDateString() {
        return resolveDate == null ? "N/A" : dateFormat.format(resolveDate);
    }

    public UserAccount getAssignee() {
        return assignee;
    }

    public String getAssigneeString() {
        return assignee == null ? "N/A" : assignee.getEmployee().getName();
    }

    public void setAssignee(UserAccount assignee) {
        setAssignDate(new Date());
        setStatus(Status.Accepted);
        if (this.assignee != null) {
            this.assignee.getEmployee().setIsAvailable(true);
            this.assignee.getEmployee().getWorkQueue().getWorkRequestList().remove(this);
        }
        this.assignee = assignee;
        assignee.getEmployee().setIsAvailable(false);
        assignee.getEmployee().getWorkQueue().getWorkRequestList().add(this);
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public String getAssignDateString() {
        return assignDate == null ? "N/A" : dateFormat.format(assignDate);
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public NewsRequest getEvent() {
        return event;
    }

    public void setEvent(NewsRequest event) {
        this.event = event;
    }

    public boolean isAssigned() {
        return status == Status.Accepted;
    }

    public boolean isDone() {
        return status == Status.Completed;
    }

    public void cancel() {
        if (assignee != null) {
            assignee.getEmployee().setIsAvailable(true);
        }
        assignee = null;
        assignDate = null;
        resolveDate = new Date();
        setStatus(Status.Cancelled);
    }

    public void done() {
        assignee.getEmployee().setIsAvailable(true);
        resolveDate = new Date();
        setStatus(Status.Completed);
    }

    @Override
    public String toString() {
        return getRequestDateString();
    }

    public String getFeedback() {
        return feedback;
    }

    public String getFeedbackString() {
        return feedback == null ? "N/A" : feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public static String getType(WorkRequest request) {
        if (request instanceof CarInsuranceRequest) {
            return "Car Insurance";
        } else if (request instanceof HouseInsuranceRequest) {
            return "House Insurance";
        } else if (request instanceof HospitalRequest) {
            return "Hospital";
        } else if (request instanceof RescueRequest) {
            return "Rescue";
        } else if (request instanceof NewsRequest) {
            return "News";
        } else if (request instanceof ElectricityRequest) {
            return "Power Supply";
        } else if (request instanceof WaterRequest) {
            return "Water Supply";
        } else if (request instanceof FoodRequest) {
            return "Food Supply";
        }
        return "Unknown";
    }

}
