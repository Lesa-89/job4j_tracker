package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.List;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenCompareAscByNameSuccess() {
        Item i1 = new Item("1");
        Item i2 = new Item("3");
        Item i3 = new Item("4");
        Item i4 = new Item("5");
        List<Item> result = asList(i4, i1, i3, i2);
        result.sort(new ItemAscByName());
        List<Item> expect = asList(i1, i2, i3, i4);
        assertThat(expect).isEqualTo(result);
    }

    @Test
    void whenCompareDescByNameSuccess() {
        Item i1 = new Item("1");
        Item i2 = new Item("3");
        Item i3 = new Item("4");
        Item i4 = new Item("5");
        List<Item> result = asList(i4, i1, i3, i2);
        result.sort(new ItemDescByName());
        List<Item> expect = asList(i4, i3, i2, i1);
        assertThat(expect).isEqualTo(result);
    }
}