/*  * AllBinary Open License Version 1  * Copyright (c) 2006 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Screen
import _root_.org.allbinary.graphics.form.item.ABCustomItem
import _root_.org.allbinary.graphics.form.item.ABCustomItemInterface
import _root_.org.allbinary.graphics.color.BasicColor

/**  *  * @author user  */
class TileLayerItem(param_label : String, param_tiledLayer : AllBinaryTiledLayer, param_layout : Int, param_altText : String, param_backgroundBasicColor : BasicColor, param_foregroundBasicColor : BasicColor) extends ABCustomItem(param_label, param_backgroundBasicColor, param_foregroundBasicColor) with ABCustomItemInterface {

    //private Screen owner;
    private var tiledLayer : AllBinaryTiledLayer = null

    //Constructor
    {
        val label : String = param_label
        val tiledLayer : AllBinaryTiledLayer = param_tiledLayer
        val layout : Int = param_layout
        val altText : String = param_altText
        val backgroundBasicColor : BasicColor = param_backgroundBasicColor
        val foregroundBasicColor : BasicColor = param_foregroundBasicColor
        this.tiledLayer = tiledLayer
    }

    override def setOwner(owner : Screen) : Unit = {
    }

    override def getMinimumWidth() : Int = {
        return this.tiledLayer.getWidth()
    }

    override def getMinimumHeight() : Int = {
        return this.tiledLayer.getHeight()
    }

    def getMinContentHeight() : Int = {
        return this.tiledLayer.getHeight()
    }

    def getMinContentWidth() : Int = {
        return this.tiledLayer.getWidth()
    }

    def getPrefContentHeight(width : Int) : Int = {
        return this.tiledLayer.getHeight()
    }

    def getPrefContentWidth(height : Int) : Int = {
        return this.tiledLayer.getWidth()
    }

    //protected void paint(Graphics g, int w, int h);
    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        //int layout = this.getLayout();
        this.tiledLayer.setPosition(x, y, this.tiledLayer.getZP())
        this.tiledLayer.paint(graphics)
    }

    override def paintUnselected(graphics : Graphics, x : Int, y : Int) : Unit = {
    }

    //Needed for polyglot do not remove
    override def getLabel() : String = {
        return super.getLabel()
    }

}


