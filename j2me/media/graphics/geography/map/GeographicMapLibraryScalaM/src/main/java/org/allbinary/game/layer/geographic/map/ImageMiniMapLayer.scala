/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.geographic.map

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.NullImage
import _root_.org.allbinary.graphics.Anchor
import _root_.org.allbinary.image.PaintableToImageUtil
import _root_.org.allbinary.media.graphics.geography.map.BasicGeographicMap
import _root_.org.allbinary.view.ViewPositionBase

class ImageMiniMapLayer(param_geographicMapInterface : BasicGeographicMap, param_viewPosition : ViewPositionBase) extends MiniMapLayer(param_geographicMapInterface, param_viewPosition) {

    private var image : Image = NullImage.NULL_IMAGE

    private var anchor : Int = Anchor.TOP_LEFT

    // private
    //Constructor
    {
        val geographicMapInterface : BasicGeographicMap = param_geographicMapInterface
        val viewPosition : ViewPositionBase = param_viewPosition
    }

    override def init() : Unit = {
        var aWidth : Int = this.allBinaryTiledLayer.getWidth()
        var aHeight : Int = this.allBinaryTiledLayer.getHeight()
        this.image = PaintableToImageUtil.getImage(this.allBinaryTiledLayer, aWidth, aHeight)
    }

    override def paint(graphics : Graphics) : Unit = {
        graphics.drawImage(this.image, this.x, this.y, this.anchor)
        this.paintDots(graphics)
    }

}


