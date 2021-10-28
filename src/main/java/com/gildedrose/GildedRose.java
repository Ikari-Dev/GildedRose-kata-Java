package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            
            updateItem(item);

        }
    }

    private void updateBackstageQuality(Item item){
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    } 

    private void increaseQuality(Item item){
        if (item.quality < 50) {
            item.quality++;
        }
    }  

    private void decreaseQuality(Item item){
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) { 
            item.quality--;
        }
    }  

    private void decreaseSellIn(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    } 

    private void manageSellInAboveZero(Item item){
        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                decreaseQualityAndManageConcert(item);
            } else {
                increaseQuality(item);
            }
        }
    } 

    private void updateItem(Item item){
        if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQuality(item);
        } else {
            if (item.quality < 50) {
                item.quality++;
                updateBackstageQuality(item);
                    
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

    private void decreaseQualityAndManageConcert(Item item){
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQuality(item);
            decreaseConjuredQuality(item);
                    
        } else {
            item.quality = 0;
        }
    } 

}
