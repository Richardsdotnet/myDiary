package DiaryTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DiaryTest {
    private DiaryInterface diary;
    private Entry entry;

    @BeforeEach

    public void setUp(){

        diary = new Diary();
    }
    @Test
    public void testThatDiaryExists(){

        assertNotNull(diary);
    }
    @Test
    public void testThatDiaryIsEmpty(){
        int numberOfEntries = diary.getNumberOfEntries();
        assertEquals(0, numberOfEntries);
    }
    @Test
    public  void testThatEntryCanBeAddedToDiaryAndEntrySizeIncrease(){
      Entry entry = new Entry();
      entry.setContent("A native has a laptop");
      diary.addEntry(entry);
      int numberOfEntries = diary.getNumberOfEntries();
      assertEquals(1, numberOfEntries);
    }
    @Test
    public void testThatEntryCanBeDeleted(){
        Entry entry = new Entry();
        entry.setContent("Hello");
        entry.setContent("hi");
        diary.addEntry(entry);
        diary.addEntry(entry);
       diary.deleteEntry(0);
        assertEquals(1,diary.getNumberOfEntries());
    }
}
