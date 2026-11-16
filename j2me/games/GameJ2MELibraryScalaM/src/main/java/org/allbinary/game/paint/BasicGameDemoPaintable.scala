/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.graphics.paint.NullPaintable
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.graphics.paint.StatePaintable

/**  *   * @author Berthelot, Travis  * @version 1.0  */
class BasicGameDemoPaintable(param_mainDemoStatePaintable : Paintable, param_ownershipPaintable : Paintable, param_helpPaintableInterface : Paintable) extends StatePaintable {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    private var mainDemoStatePaintable : Paintable = null

    private var ownershipPaintable : Paintable = null

    private var helpPaintableInterface : Paintable = null

    private var currentStatePaintable : Paintable = NullPaintable.getInstance()

    //Constructor
    {
        val mainDemoStatePaintable : Paintable = param_mainDemoStatePaintable
        val ownershipPaintable : Paintable = param_ownershipPaintable
        val helpPaintableInterface : Paintable = param_helpPaintableInterface
        this.mainDemoStatePaintable = mainDemoStatePaintable
        this.setCurrentStatePaintable(NullPaintable.getInstance())
        this.ownershipPaintable = ownershipPaintable
        this.helpPaintableInterface = helpPaintableInterface
    }

    override def setState(state : Int) : Unit = {
        if (state == 0) {
            //this.logUtil.putF("Setting Main Demo State Paintable", this, "setState");
            this.setCurrentStatePaintable(this.getMainDemoStatePaintable())
        } else if (state == 1) {
            //this.logUtil.putF("Setting Help Paintable", this, "setState");
            this.setCurrentStatePaintable(this.helpPaintableInterface)
        } else {
            //this.currentStatePaintable = NullPaintable.getInstance();
            this.setCurrentStatePaintable(this.ownershipPaintable)
        }
    }

    override def paint(graphics : Graphics) : Unit = {
        this.getCurrentStatePaintable().paint(graphics)
    }

    /**      * @return the helpPaintableInterface      */
    def getHelpPaintableInterface() : Paintable = {
        return this.helpPaintableInterface
    }

    def setCurrentStatePaintable(currentStatePaintable : Paintable) : Unit = {
        this.currentStatePaintable = currentStatePaintable
    }

    def getCurrentStatePaintable() : Paintable = {
        return this.currentStatePaintable
    }

    def getMainDemoStatePaintable() : Paintable = {
        return this.mainDemoStatePaintable
    }

}


