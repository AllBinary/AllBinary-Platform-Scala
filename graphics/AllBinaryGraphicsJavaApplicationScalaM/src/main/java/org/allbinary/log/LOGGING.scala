/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.log

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil

class LOGGING private(param_value : String) {
    import _root_.org.allbinary.log.LOGGING.{GRAPHICSPAINT as _, GRAPHICSCREATION as _, GRAPHICSDELETION as _, LOADINGERROR as _, MENUEVENT as _, MOUSEEVENT as _, KEYEVENT as _, ACTIONEVENT as _, ADJUSTMENTEVENT as _, COMPONENTEVENT as _, CONTAINEREVENT as _, FOCUSEVENT as _, HIERARCHYEVENT as _, INPUTEVENT as _, INVOCATIONEVENT as _, ITEMEVENT as _, PAINTEVENT as _, TEXTEVENT as _, WINDOWEVENT as _, *}
    def GRAPHICSPAINT : LOGGING = _root_.org.allbinary.log.LOGGING.GRAPHICSPAINT
    def GRAPHICSCREATION : LOGGING = _root_.org.allbinary.log.LOGGING.GRAPHICSCREATION
    def GRAPHICSDELETION : LOGGING = _root_.org.allbinary.log.LOGGING.GRAPHICSDELETION
    def LOADINGERROR : LOGGING = _root_.org.allbinary.log.LOGGING.LOADINGERROR
    def MENUEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.MENUEVENT
    def MOUSEEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.MOUSEEVENT
    def KEYEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.KEYEVENT
    def ACTIONEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.ACTIONEVENT
    def ADJUSTMENTEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.ADJUSTMENTEVENT
    def COMPONENTEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.COMPONENTEVENT
    def CONTAINEREVENT : LOGGING = _root_.org.allbinary.log.LOGGING.CONTAINEREVENT
    def FOCUSEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.FOCUSEVENT
    def HIERARCHYEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.HIERARCHYEVENT
    def INPUTEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.INPUTEVENT
    def INVOCATIONEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.INVOCATIONEVENT
    def ITEMEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.ITEMEVENT
    def PAINTEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.PAINTEVENT
    def TEXTEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.TEXTEVENT
    def WINDOWEVENT : LOGGING = _root_.org.allbinary.log.LOGGING.WINDOWEVENT

    private var name : String = null

    //Constructor
    {
        val value : String = param_value
        this.name = value
        LOGGING.logging.add(value)
    }

    override def toString() : String = {
        return this.name
    }

}

object LOGGING {
    private var logging : BasicArrayList = new BasicArrayListD()

    def contains(logType : LOGGING) : Boolean = {
        return LOGGING.logging.contains(logType.toString())
    }

    //graphics
    val GRAPHICSPAINT : LOGGING = new LOGGING("Graphics Paint")

    val GRAPHICSCREATION : LOGGING = new LOGGING("Graphics Creation")

    val GRAPHICSDELETION : LOGGING = new LOGGING("Graphics Deletion")

    val LOADINGERROR : LOGGING = new LOGGING("Loading Error")

    //events
    val MENUEVENT : LOGGING = new LOGGING("Menu Action Event")

    val MOUSEEVENT : LOGGING = new LOGGING("Mouse Action Event")

    val KEYEVENT : LOGGING = new LOGGING("Keyboard Action Event")

    val ACTIONEVENT : LOGGING = new LOGGING("Action Event")

    val ADJUSTMENTEVENT : LOGGING = new LOGGING("Adjustment Action Event")

    val COMPONENTEVENT : LOGGING = new LOGGING("Component Action Event")

    val CONTAINEREVENT : LOGGING = new LOGGING("Container Action Event")

    val FOCUSEVENT : LOGGING = new LOGGING("Focus Action Event")

    val HIERARCHYEVENT : LOGGING = new LOGGING("Hierarchy Action Event")

    val INPUTEVENT : LOGGING = new LOGGING("Input Action Event")

    val INVOCATIONEVENT : LOGGING = new LOGGING("Invocation Action Event")

    val ITEMEVENT : LOGGING = new LOGGING("Item Action Event")

    val PAINTEVENT : LOGGING = new LOGGING("Paint Action Event")

    val TEXTEVENT : LOGGING = new LOGGING("Text Action Event")

    val WINDOWEVENT : LOGGING = new LOGGING("Window Action Event")

}


