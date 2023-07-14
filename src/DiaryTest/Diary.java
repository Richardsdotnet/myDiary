package DiaryTest;

import java.util.ArrayList;
import java.util.List;

public class Diary implements DiaryInterface {
    private final List<Entry> entries = new ArrayList<>();
    @Override
    public void addEntry(Entry entry) {
        int count = 0;
    entry.setId(++count);
    entries.add(entry);
    }

    @Override
    public int getNumberOfEntries() {

        return entries.size();
    }

    @Override
    public void editContent(int id, String content) {
        for (Entry contentEntry : entries) {
            if (contentEntry.getId() == id) {
                entries.remove(contentEntry);
                contentEntry.setContent(content);
                entries.add(contentEntry);
            }
        }

    }

    @Override
    public void editTopic(int id, String topic) {
        for (Entry topicEntry: entries) {
            if(topicEntry.getId() == id){
                entries.remove(topicEntry);
                topicEntry.setTopic(topic);
                entries.add(topicEntry);
            }

        }

    }


    @Override
    public Entry viewEntry(int entry) {
        for (Entry entry1: entries) {
            if (entry1.getId() == entry){
                return entry1;
            }
        }
    return entries.get(entry);
    }

    @Override
    public void deleteEntry(int id) {
    entries.remove(id);
    }

    }


