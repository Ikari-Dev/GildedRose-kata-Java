package com.gildedrose;

class GildedRose {
    private transient Item[] items;
    private static final int LIMIT_FOR_TWO_ON_QUALITY = 11;
    private static final int LIMIT_FOR_THREE_ON_QUALITY = 6;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_SELLIN = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            
            updateItem(item);

        }
    }

    private void increaseBackstageQuality(Item item){
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < LIMIT_FOR_TWO_ON_QUALITY) {
                increaseQuality(item);
            }

            if (item.sellIn < LIMIT_FOR_THREE_ON_QUALITY) {
                increaseQuality(item);
            }
        }
    } 

    private void increaseQuality(Item item){
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }  

    private void decreaseQuality(Item item){
        if (item.quality > MIN_QUALITY && !item.name.equals("Sulfuras, Hand of Ragnaros")) { 
            item.quality--;
        }
    }  

    private void decreaseSellIn(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    } 

    private void manageSellInAboveZero(Item item){
        if (item.sellIn < MIN_SELLIN) {
            if (!item.name.equals("Aged Brie")) {
                decreaseQualityOrManageConcert(item);
            } else {
                increaseQuality(item);
            }
        }
    } 

    private void updateItem(Item item){
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQuality(item);
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality++;
                increaseBackstageQuality(item);
                    
            }
        }

        decreaseSellIn(item);

        manageSellInAboveZero(item);
    } 

    private void decreaseConjuredQuality(Item item){
        if(item.name.equals("Conjured")){
            decreaseQuality(item);
            decreaseQuality(item);
        } 
    } 

    private void decreaseQualityOrManageConcert(Item item){
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQuality(item);
            decreaseConjuredQuality(item);
                    
        } else {
            item.quality = 0;
        }
    } 

}
