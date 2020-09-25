package ua.step.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task02Test {

    @Test
    void join() {
        String actual = Task02.join(new String[]{"one", "two", "three"});
        assertEquals("one two three", actual);
    }

    @Test
    void testJoinComma() {
        String actual = Task02.join(new String[]{"one", "two", "three"}, ", ");
        assertEquals("one, two, three", actual);
    }

    @Test
    void testJoinPointer() {
        String actual = Task02.join(new String[]{"one", "two", "three"}, "->");
        assertEquals("one->two->three", actual);
    }

    @Test
    void sortDesc() {
        String[] array = {"aaa", "bbb", "ccc", "ddd", "zzz"};
        Task02.sortDesc(array);
        assertArrayEquals(new String[]{"zzz", "ddd", "ccc", "bbb", "aaa"}, array);
    }

    @Test
    void sortByWordCount() {
        String[] sentences = new String[]{"one two", "java", "I am free"};
        Task02.sortByWordCount(sentences);
        assertArrayEquals(new String[]{"java", "one two",  "I am free"}, sentences);
    }
}