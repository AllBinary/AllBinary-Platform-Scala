/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.paint

import _root_.org.allbinary.graphics.color.BasicColor
import _root_.org.allbinary.graphics.color.ColorChangeEventHandler
import _root_.org.allbinary.graphics.color.ColorChangeListener
import _root_.org.allbinary.graphics.form.FormPaintable
import _root_.org.allbinary.graphics.form.ScrollSelectionForm
import _root_.org.allbinary.graphics.form.item.ABStringComponent
import _root_.org.allbinary.graphics.form.item.ABTextItem
import _root_.org.allbinary.graphics.paint.Paintable
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject

class GameScrollMenuPaintable(param_mainDemoStatePaintable : Paintable, param_ownershipPaintable : Paintable, param_helpPaintableInterface : Paintable, param_basicColor : BasicColor) extends BasicGameDemoPaintable(param_mainDemoStatePaintable, param_ownershipPaintable, param_helpPaintableInterface) with ColorChangeListener {

    //protected final LogUtil logUtil = LogUtil.getInstance();
    //Constructor
    {
        val mainDemoStatePaintable : Paintable = param_mainDemoStatePaintable
        val ownershipPaintable : Paintable = param_ownershipPaintable
        val helpPaintableInterface : Paintable = param_helpPaintableInterface
        val basicColor : BasicColor = param_basicColor
        this.setColor(basicColor)
        ColorChangeEventHandler.getInstance().addListenerInterface(this)
    }

    override def setState(state : Int) : Unit = {
        //this.logUtil.putF("Setting Main Demo State Paintable", this, "setState");
        this.setCurrentStatePaintable(this.getMainDemoStatePaintable())
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
    }

    def setColor(basicColor : BasicColor) : Unit = {
        val mainGameDemoStatePaintable : MainGameDemoStatePaintable = this.getMainDemoStatePaintable().asInstanceOf[MainGameDemoStatePaintable]
        val formPaintable : FormPaintable = mainGameDemoStatePaintable.getMenuPaintableInterface().asInstanceOf[FormPaintable]
        val scrollSelectionForm : ScrollSelectionForm = formPaintable.getForm().asInstanceOf[ScrollSelectionForm]
        mainGameDemoStatePaintable.getOwnershipPaintableInterface().setBasicColorP(basicColor)
        scrollSelectionForm.setButtonBasicColor(basicColor)
        var item : ABTextItem = null
        var stringComponent : ABStringComponent = null

        {
            var index : Int = scrollSelectionForm.size() - 1
            while (index >= 0) {
                item = scrollSelectionForm.get(index).asInstanceOf[ABTextItem]
                stringComponent = item.getLabelStringComponent()
                if (stringComponent != null) {
                    stringComponent.setForegroundBasicColor(basicColor)
                }
                index -= 1
            }
        }
    }

}


