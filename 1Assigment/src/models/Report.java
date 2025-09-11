package models;

import java.util.List;
import java.util.UUID;

public class Report {

    private UUID uniqueId;

    private String title;
    private List<String> messages;

    private Report(Builder builder) {
        this.uniqueId = UUID.randomUUID();
        this.title = builder.title;
        this.messages = builder.messages;
    }

    @Override
    public String toString() {
        return "Report{" +
                "uniqueId=" + uniqueId +
                ", title='" + title + '\'' +
                ", messages=" + String.join(", ", messages) +
                '}';
    }

    public static class Builder {

        private String title;
        private List<String> messages;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder messages(List<String> messages) {
            this.messages = messages;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getMessages() {
        return messages;
    }

}