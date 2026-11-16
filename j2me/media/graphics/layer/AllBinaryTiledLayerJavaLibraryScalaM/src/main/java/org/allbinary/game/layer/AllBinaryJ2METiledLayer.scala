/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.game.TiledLayer
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.logic.string.StringMaker

class AllBinaryJ2METiledLayer(param_dataId : Integer, param_tiledLayer : TiledLayer, param_mapTwoDArray : Array[Array[Int]], param_debugColor : Int) extends AllBinaryTiledLayer(param_dataId, param_tiledLayer.getWidth(), param_tiledLayer.getHeight(), param_tiledLayer.getCellWidth(), param_tiledLayer.getCellHeight()) {

    //private final StringMaker stringMaker = new StringMaker();
    var tiledLayerP : TiledLayer = null

    var debugColor : Int = 0

    val font2 : Font = Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, 4)

    //Constructor
    {
        val dataId : Integer = param_dataId
        val tiledLayer : TiledLayer = param_tiledLayer
        val mapTwoDArray : Array[Array[Int]] = param_mapTwoDArray
        val debugColor : Int = param_debugColor
        this.tiledLayerP = tiledLayer
        this.debugColor = debugColor
        this.setCells(mapTwoDArray)
    }

    /*        public int getHeight()     {     return this.tiledLayer.getHeight();     }      //TWB LayerInterface to Layer     public int getWidth()     {     return this.tiledLayer.getWidth();     }      //TWB LayerInterface to Layer     public int getX()     {     return this.tiledLayer.getXP();     }      //TWB LayerInterface to Layer     public int getY()     {     return this.tiledLayer.getYP();     }      public int getZ()     {     return this.tiledLayer.getZP();     }      //TWB LayerInterface to Layer     public boolean isVisible()     {     return this.tiledLayer.isVisible();     }      */
    override def paint(graphics : Graphics) : Unit = {
        this.tiledLayerP.paint(graphics)
    }

    def paintDebug(graphics : Graphics) : Unit = {
        //this.logUtil.putF(this.commonStrings.START, this, CanvasStrings.getInstance().PAINT);
        val font : Font = graphics.getFont()
        graphics.setFont(this.font2)
        graphics.setColor(this.debugColor)
        //graphics.drawString("TiledLayer: (" + this.getX() + ", " + this.getY() + ")", this.getX(), this.getY(), 0);
        var x : Int = this.tiledLayerP.getX()
        var y : Int = this.tiledLayerP.getY()
        var firstColumn : Int = 0
        var firstRow : Int = 0
        val totalColumns : Int = this.tiledLayerP.getColumns()
        val totalRows : Int = this.tiledLayerP.getRows()
        var x0 : Int = x
        //int imgRows = img.getHeight() / tileHeight;
        var tile : Int = 0
        val tileHeight : Int = this.tiledLayerP.getCellHeight()
        val tileWidth : Int = this.tiledLayerP.getCellWidth()
        val commonSeps : CommonSeps = CommonSeps.getInstance()
        val stringMaker : StringMaker = new StringMaker()

        {
            var rowIndex : Int = firstRow
            while (rowIndex < totalRows) {
                x = x0

                {
                    var columnIndex : Int = firstColumn
                    while (columnIndex < totalColumns) {
                        scala.util.boundary { (continue_N68261 : scala.util.boundary.Label[Unit]) ?=>
                            tile = this.tiledLayerP.getCell(columnIndex, rowIndex)
                            if (tile < 0) {
                                tile = this.tiledLayerP.getAnimatedTile(tile)
                            }
                            if (tile == 0) {
                                scala.util.boundary.break()(using continue_N68261)
                            }
                            tile -= 1
                            stringMaker.delete(0, stringMaker.length())
                            graphics.drawString(stringMaker.appendint(columnIndex).append(commonSeps.COMMA).appendint(rowIndex).append(commonSeps.COLON).appendint(tile).toString(), x + 5, y + 10, 0)
                        }
                        columnIndex += 1
                        x += tileWidth
                    }
                }
                rowIndex += 1
                y += tileHeight
            }
        }
        graphics.setFont(font)
    }

    override def moveDXY(dx : Int, dy : Int) : Unit = {
        //this.logUtil.putF(new StringMaker().append("TiledLayer: ").append(PositionStrings.getInstance().X_LABEL).append(dx).append(PositionStrings.getInstance().Y_LABEL).append(dy).toString(), this, "move");
        this.tiledLayerP.move(dx, dy)
        //TWB LayerInterface to Layer
        super.moveDXY(-dx, -dy)
    }

    override def setPosition(x : Int, y : Int, z : Int) : Unit = {
        //this.logUtil.putF(new StringMaker().append("TiledLayer: x: ").append(x).append(" y: ").append(y).append(" z: ").append(z).toString(), this, "setPosition");
        this.tiledLayerP.setPosition(x, y)
        super.setPosition(-x, -y, z)
    }

    //}
    def getTiledLayer() : TiledLayer = {
        return this.tiledLayerP
    }

    override def getCellWidth() : Int = {
        return this.tiledLayerP.getCellWidth()
    }

    override def getCellHeight() : Int = {
        return this.tiledLayerP.getCellHeight()
    }

    override def getCell(col : Int, row : Int) : Int = {
        return this.tiledLayerP.getCell(col, row)
    }

    override def getColumns() : Int = {
        return this.tiledLayerP.getColumns()
    }

    override def getRows() : Int = {
        return this.tiledLayerP.getRows()
    }

    override def setCell(col : Int, row : Int, index : Int) : Unit = {
        //stringMaker.append(index).append(',');
        this.tiledLayerP.setCell(col, row, index)
    }

    override def getAnimatedTile(animationTileIndex : Int) : Int = {
        return this.tiledLayerP.getAnimatedTile(animationTileIndex)
    }

}


