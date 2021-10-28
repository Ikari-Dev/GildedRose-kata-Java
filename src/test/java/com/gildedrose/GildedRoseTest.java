package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

	Item[] list = {
		new Item("Aged Brie", 0, 1),
		new Item("Backstage passes to a TAFKAL80ETC concert", 0, 3),
		new Item("Sulfuras, Hand of Ragnaros", 0, 3),
		new Item("Some Item", 0, 50),
		new Item("Aged Brie", 0, 50),
		new Item("Sulfuras, Hand of Ragnaros", -1, 50),
		new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3),
		new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49),
		new Item("Conjured", 10, 20),
		new Item("Conjured", 0, 20)
	};

	@Test
	@DisplayName("Test that the name is unchanged")
	void testName() {
		Item element = new Item("foo", 0, 0);
		GildedRose app = new GildedRose(new Item[] {element});
		app.updateQuality();
		assertThat(element.name, is("foo"));
	}

	@Test
	@DisplayName("Test quality update")
	void testValue(){

		list[0].toString();

		GildedRose app = new GildedRose(list);
		app.updateQuality();

		assertEquals(3, list[0].quality);
		assertEquals(0, list[1].quality);
		assertEquals(3, list[2].quality);
		assertEquals(48, list[3].quality);
		assertEquals(50, list[4].quality);
		assertEquals(50, list[5].quality);
		assertEquals(4, list[6].quality);
		assertEquals(0, list[7].quality);
		assertEquals(19, list[8].quality);
		assertEquals(16, list[9].quality);
	}

	@Test
	@DisplayName("Test Sell update")
	void testSell(){


		GildedRose app = new GildedRose(list);
		app.updateQuality();

		assertEquals(-1, list[0].sellIn);
		assertEquals(-1, list[1].sellIn);
		assertEquals(0, list[2].sellIn);
		assertEquals(-1, list[3].sellIn);
		assertEquals(-1, list[4].sellIn);
		assertEquals(-1, list[5].sellIn);
		assertEquals(10, list[6].sellIn);
		assertEquals(-1, list[7].sellIn);
		assertEquals(9, list[8].sellIn);
		assertEquals(-1, list[9].sellIn);
	}   
}