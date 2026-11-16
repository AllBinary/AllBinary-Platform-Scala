/*  * AllBinary Open License Version 1  * Copyright (c) 2003 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.item

import _root_.javax.microedition.lcdui.Graphics
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.graphics.form.item.ABCustomImageItem
import _root_.org.allbinary.animation.Animation
import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.layer.LayerInterfaceFactoryInterface

/**  *  * @author user  */
class LayerInterfaceFactoryImageItem(param_label : String, param_img : Image, param_layout : Int, param_altText : String, param_basicColor : BasicColor, param_animationArray : Array[Animation], param_layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface) extends ABCustomImageItem(param_label, param_img, param_layout, param_altText, param_basicColor, 0) {

    private var animationArray : Array[Animation] = null

    private var layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface = null

    //Constructor
    {
        val label : String = param_label
        val img : Image = param_img
        val layout : Int = param_layout
        val altText : String = param_altText
        val basicColor : BasicColor = param_basicColor
        val animationArray : Array[Animation] = param_animationArray
        val layerInterfaceFactoryInterface : LayerInterfaceFactoryInterface = param_layerInterfaceFactoryInterface
        this.animationArray = animationArray
        this.layerInterfaceFactoryInterface = layerInterfaceFactoryInterface
    }

    def getLayerInterfaceFactoryInterface() : LayerInterfaceFactoryInterface = {
        return this.layerInterfaceFactoryInterface
    }

    override def paintXY(graphics : Graphics, x : Int, y : Int) : Unit = {
        super.paintXY(graphics, x, y)
        //-yOffset

        {
            var index : Int = this.animationArray.length
            while ({ index -= 1; index } >= 0) {
                this.animationArray(index).paintXY(graphics, x, y)
            }
        }
    }

}


