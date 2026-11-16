/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer


/**  *  * @author user  */
class TiledLayerUtil {
    import _root_.org.allbinary.game.layer.TiledLayerUtil.{*}

    /*     public static void keepOnMap(AllBinaryTiledLayer terrainTiledLayer,             AllBinaryLayer layer,             int x, int y,             int mapBorderBufferHeight, int mapBorderBufferWidth)     {         //int x = layer.getX();         //int y = layer.getY();          int newX = x;         int newY = y;          // this.logUtil.putF("pre scrollTerrain X: " +         // terrainTiledLayer.getXP(), this, "keepOnMap");         // this.logUtil.putF("pre scrollTerrain Y: " +         // terrainTiledLayer.getYP(), this, "keepOnMap");          // StringMaker stringBuffer = new StringMaker();          int maxRight = terrainTiledLayer.getWidth() - mapBorderBufferWidth;         if (x > maxRight)         {             // Reached the right border so don't go beyond the map             newX = maxRight;             // this.logUtil.putF("Right: < " + maxRight, this, // "keepOnMap");             // stringBuffer.append("Right: < ");             // stringBuffer.append(maxRight);         }          if (x < mapBorderBufferWidth)         {             // Reached the left boundry so don't go beyond the map             newX = mapBorderBufferWidth;             // this.logUtil.putF("Left: > " +             // mapBorderBufferWidth, this, // "keepOnMap");             // stringBuffer.append(" Left: > ");             // stringBuffer.append(mapBorderBufferWidth);         }          int maxBottom = terrainTiledLayer.getHeight() - mapBorderBufferHeight;         if (y > maxBottom)         {             // Reached the bottom so don't go beyond the map             newY = maxBottom;             // this.logUtil.putF("Bottom: < " + maxBottom, // this, // "keepOnMap");             // stringBuffer.append(" Bottom: < ");             // stringBuffer.append(maxBottom);         }          if (y < mapBorderBufferHeight)         {             // Reached the top so don't go beyond the map             newY = mapBorderBufferHeight;             // this.logUtil.putF("Top: > " +             // mapBorderBufferHeight, this, // "keepOnMap");             // stringBuffer.append(" Top: > ");             // stringBuffer.append(mapBorderBufferHeight);         }          //if (x != newX || y != newY)         //{             // this.logUtil.putF(stringBuffer.toString() +             // " X: " + this.x + " Y: " + this.y, this, "keepOnMap");             layer.setPosition(newX, newY);         //}          // this.logUtil.putF("scrollTerrain X: " +         // terrainTiledLayer.getXP(), // this, "keepOnMap");         // this.logUtil.putF("scrollTerrain Y: " +         // terrainTiledLayer.getYP(), // this, "keepOnMap");     }     */
    def keepOnBorderdMapX(terrainTiledLayer : AllBinaryTiledLayer, x : Int, width : Int, mapBorderBufferWidth : Int) : Int = {
        var newX : Int = x
        // StringMaker stringBuffer = new StringMaker();
        var maxRight : Int = (terrainTiledLayer.getWidth() - width) - mapBorderBufferWidth
        if ((x + width) > maxRight) {
            // Reached the right border so don't go beyond the map
            newX = maxRight
        }
        if (x < mapBorderBufferWidth) {
            // Reached the left boundry so don't go beyond the map
            newX = mapBorderBufferWidth
        }
        return newX
    }

    def keepOnBorderdMapY(terrainTiledLayer : AllBinaryTiledLayer, y : Int, height : Int, mapBorderBufferHeight : Int) : Int = {
        var newY : Int = y
        // StringMaker stringBuffer = new StringMaker();
        var maxBottom : Int = (terrainTiledLayer.getHeight() - height) - mapBorderBufferHeight
        if ((y + height) > maxBottom) {
            // Reached the bottom so don't go beyond the map
            newY = maxBottom
        }
        if (y < mapBorderBufferHeight) {
            // Reached the top so don't go beyond the map
            newY = mapBorderBufferHeight
        }
        return newY
    }

    def keepOnMapX(terrainTiledLayer : AllBinaryTiledLayer, x : Int, width : Int) : Int = {
        var newX : Int = x
        // StringMaker stringBuffer = new StringMaker();
        var maxRight : Int = terrainTiledLayer.getWidth() - width
        if (x >= maxRight) {
            // Reached the right border so don't go beyond the map
            newX = maxRight
        }
        if (x < 0) {
            // Reached the left boundry so don't go beyond the map
            newX = 0
        }
        return newX
    }

    def keepOnMapY(terrainTiledLayer : AllBinaryTiledLayer, y : Int, height : Int) : Int = {
        var newY : Int = y
        // StringMaker stringBuffer = new StringMaker();
        var maxBottom : Int = terrainTiledLayer.getHeight() - height
        if (y >= maxBottom) {
            // Reached the bottom so don't go beyond the map
            newY = maxBottom
        }
        if (y < 0) {
            // Reached the top so don't go beyond the map
            newY = 0
        }
        return newY
    }

}

object TiledLayerUtil {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val instance : TiledLayerUtil = new TiledLayerUtil()

    def getInstance() : TiledLayerUtil = {
        return TiledLayerUtil.instance
    }

}


