package DiaryTest;

import java.time.LocalDateTime;


public class Entry {
    private int id;
    private String topic;
    private String content;
    private  final LocalDateTime localDateTime = LocalDateTime.now();

    public Entry() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {

        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
