/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.midlet

import _root_.javax.microedition.lcdui.Command
import _root_.javax.microedition.lcdui.CommandListener
import _root_.javax.microedition.lcdui.Display
import _root_.javax.microedition.lcdui.Displayable
import _root_.javax.microedition.lcdui.NullCanvas
import _root_.javax.microedition.midlet.MIDlet
import _root_.javax.microedition.midlet.MIDletStateChangeException
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.log.PreLogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.system.Memory
import _root_.org.allbinary.logic.NullUtil
import _root_.org.allbinary.util.ABHashtable

/*//JSNI Expose so JSNI can access this class *** 
 globalThis.org = globalThis.org || {}; 
 globalThis.org.allbinary = globalThis.org.allbinary || {}; 
 globalThis.org.allbinary.midlet = globalThis.org.allbinary.midlet || {}; 
 globalThis.org.allbinary.midlet.AllBinaryMidlet = AllBinaryMidlet; 
 console.log('Exported AllBinaryMidlet as globalThis'); */
class AllBinaryMidlet() extends MIDlet with CommandListener {
    import _root_.org.allbinary.midlet.AllBinaryMidlet.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val SET_DISPLAY : String = "setDisplay"

    private val SETTING_ : String = "Setting: "

    private val _DISPLAY_ : String = " Display: "

    private val SETTING_NO_TITLE : String = "Setting: No Title, Display: "

    private var hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    private var midletDestroyed : Boolean = false

    //Constructor
    {
        this.logUtil.putF(this.commonStrings.CONSTRUCTOR, this, "AllBinaryMidlet::AllBinaryMidlet")
    }

    def setDisplay(newDisplay : Displayable) : Unit = {
        var title : String = StringUtil.getInstance().EMPTY_STRING
        if (newDisplay ne NullCanvas.NULL_CANVAS) {
            title = newDisplay.getTitle()
            //            {
            this.logUtil.putF(new StringMaker().append(this.SETTING_).append(title).append(this._DISPLAY_).append(StringUtil.getInstance().toString(newDisplay)).toString(), this, this.SET_DISPLAY)
        }
        val display : Display = this.getDisplay()
        display.setCurrent(newDisplay)
    }

    def getDisplay() : Display = {
        return Display.getDisplay(this)
    }

    def getCurrentDisplayable() : Displayable = {
        return Display.getDisplay(this).getCurrent()
    }

    def setDestroyed(destroyed : Boolean) : Unit = {
        this.midletDestroyed = destroyed
    }

    def isDestroyed() : Boolean = {
        return this.midletDestroyed
    }

    override def startApp() : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def pauseApp() : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    def destroyAppInRunnable(unconditional : Boolean, isProgress : Boolean) : Unit = {
    }

    override def destroyApp(unconditional : Boolean) : Unit = {
        val METHOD_NAME : String = "AllBinaryMidlet::destroyApp"
        try {
            this.logUtil.putF(this.commonStrings.START, this, METHOD_NAME)
            PreLogUtil.put(Memory.getInfo(), this, METHOD_NAME)
            this.setDestroyed(true)
        } catch {
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, METHOD_NAME, e)
            }
        }
    }

    def setStartStateHashtable(hashtable : ABHashtable[Object, Object]) : Unit = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(StringUtil.getInstance().toString(hashtable)).toString(), this, "setStartStateHashtable")
        this.hashtable = hashtable
    }

    def getStartStateHashtable() : ABHashtable[Object, Object] = {
        this.logUtil.putF(new StringMaker().append(CommonLabels.getInstance().START_LABEL).append(StringUtil.getInstance().toString(this.hashtable)).toString(), this, "getStartStateHashtable")
        return this.hashtable
    }

    def getCurrentStateHashtable() : ABHashtable[Object, Object] = {
        this.logUtil.putF(this.commonStrings.START, this, "getStateHashtable")
        return StdUtil.getInstance().NULL_TABLE
    }

    override def commandAction(command : Command, displayable : Displayable) : Unit = {
    }

}

object AllBinaryMidlet {
    private var NULL_ALLBINARY_MIDLET : Object = NullUtil.getInstance().NULL_OBJECT

    def getNullInstance() : AllBinaryMidlet = {
        if (AllBinaryMidlet.NULL_ALLBINARY_MIDLET eq NullUtil.getInstance().NULL_OBJECT) {
            AllBinaryMidlet.NULL_ALLBINARY_MIDLET = new AllBinaryMidlet()
        }
        return AllBinaryMidlet.NULL_ALLBINARY_MIDLET.asInstanceOf[AllBinaryMidlet]
    }

}


