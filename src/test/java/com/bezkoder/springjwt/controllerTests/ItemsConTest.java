package com.bezkoder.springjwt.controllerTests;

import com.bezkoder.springjwt.models.Item;
import com.bezkoder.springjwt.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemsConTest {


    @Autowired
    ItemRepository itemRepository;


    @Test
    public void testCreateReadDelete() {
        Item item = new Item("TestItem", "Standard light","www.bulb.com");

        Item itemResult = itemRepository.save(item);

        Iterable<Item> items = itemRepository.findAll();
        Assertions.assertThat(items).last().hasFieldOrPropertyWithValue("name", "TestItem");

        itemRepository.delete(itemResult);
        Assertions.assertThat(items).doesNotContain(item);
    }
}
