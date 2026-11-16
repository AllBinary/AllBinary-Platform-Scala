/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form


class ItemPaintableFactory extends ItemPaintable {
    import _root_.org.allbinary.graphics.form.ItemPaintableFactory.{*}

    def getInstanceItemPaintable(paintableForm : PaintableForm) : ItemPaintable = {
        return ItemPaintableFactory.instance
    }

}

object ItemPaintableFactory {
    private val instance : ItemPaintableFactory = new ItemPaintableFactory()

    def getInstance() : ItemPaintableFactory = {
        return ItemPaintableFactory.instance
    }

}


