/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.form


class LockableFormPaintableFactory(param_lockedIndex : Int) extends ItemPaintableFactory {

    private var lockedIndex : Int = 0

    //Constructor
    {
        val lockedIndex : Int = param_lockedIndex
        this.lockedIndex = lockedIndex
    }

    override def getInstanceItemPaintable(paintableForm : PaintableForm) : ItemPaintable = {
        return new LockablePaintable(this.lockedIndex)
    }

}


