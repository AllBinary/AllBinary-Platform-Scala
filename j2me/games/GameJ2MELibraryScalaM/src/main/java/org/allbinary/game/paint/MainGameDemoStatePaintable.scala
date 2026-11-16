/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.Paintable

class MainGameDemoStatePaintable(param_ownershipPaintableInterface : Paintable, param_menuPaintableInterface : Paintable) extends Paintable {

    private var ownershipPaintableInterface : Paintable = null

    private var menuPaintableInterface : Paintable = null

    //Constructor
    {
        val ownershipPaintableInterface : Paintable = param_ownershipPaintableInterface
        val menuPaintableInterface : Paintable = param_menuPaintableInterface
        this.ownershipPaintableInterface = ownershipPaintableInterface
        // new AllBinaryImageAnimation(new OwnershipScreen().getImage());
        this.menuPaintableInterface = menuPaintableInterface
    }

    override def paint(graphics : Graphics) : Unit = {
        this.menuPaintableInterface.paint(graphics)
        this.ownershipPaintableInterface.paint(graphics)
    }

    /**      * @return the ownershipPaintableInterface      */
    def getOwnershipPaintableInterface() : Paintable = {
        return this.ownershipPaintableInterface
    }

    /**      * @return the menuPaintableInterface      */
    def getMenuPaintableInterface() : Paintable = {
        return this.menuPaintableInterface
    }

}


