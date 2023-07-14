package DiaryTest;

public interface DiaryInterface {
    void addEntry(Entry entry);
    int getNumberOfEntries();

    void editContent(int id, String content);

    void editTopic(int id, String topic);

    Entry viewEntry(int entry);

    void deleteEntry(int id);

}
