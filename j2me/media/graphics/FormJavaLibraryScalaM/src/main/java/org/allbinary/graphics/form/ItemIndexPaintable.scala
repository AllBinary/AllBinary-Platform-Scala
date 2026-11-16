/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.form.item.ABCustomItem

/**  *  * @author User  */
class ItemIndexPaintable {
    import _root_.org.allbinary.graphics.form.ItemIndexPaintable.{*}

    def paint(graphics : Graphics, index : Int, item : ABCustomItem, dx : Int, dy : Int) : Int = {
        return 0
    }

}

object ItemIndexPaintable {
    private val instance : ItemIndexPaintable = new ItemIndexPaintable()

    /**      * @return the instance      */
    def getInstance() : ItemIndexPaintable = {
        return ItemIndexPaintable.instance
    }

}


