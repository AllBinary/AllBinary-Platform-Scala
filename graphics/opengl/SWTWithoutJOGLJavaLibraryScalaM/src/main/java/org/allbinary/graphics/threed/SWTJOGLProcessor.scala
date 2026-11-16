/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.threed

import _root_.javax.microedition.lcdui.Font
import _root_.javax.microedition.midlet.MIDlet

//SWTWithoutJOGL
class SWTJOGLProcessor extends Runnable {
    import _root_.org.allbinary.graphics.threed.SWTJOGLProcessor.{*}

    var glHolder : GLHolder = new GLHolder {
            override def run(renderer : Object) : Unit = {
            }

        }

    def init(display : Object, comp : Object) : Unit = {
    }

    def isHolderCreated() : Boolean = {
        return glHolder.isCreated
    }

    def setRenderer(renderer : Object) : Unit = {
    }

    def isJOGL() : Boolean = {
        return false
    }

    def createSurface() : Unit = {
    }

    def onSurfaceCreated() : Unit = {
    }

    def onSurfaceChangedForEvent(event : Object) : Unit = {
    }

    def onSurfaceChanged() : Unit = {
    }

    def onSurfaceChangedWH(width : Int, height : Int) : Unit = {
    }

    def addListener() : Unit = {
    }

    def addListeners(midlet : MIDlet) : Unit = {
    }

    override def run() : Unit = {
    }

    def clear() : Unit = {
    }

    def setCustom(width : Int, height : Int, ratio : Float) : Unit = {
    }

    def setRatioProcessor(ratioProcessor : RatioProcessor) : Unit = {
    }

    def charWidth(font : Font, ch : Char) : Int = {
        throw new RuntimeException()
    }

    def charsWidth(font : Font, ch : Array[Char], offset : Int, length : Int) : Int = {
        throw new RuntimeException()
    }

    def stringWidth(font : Font, str : String) : Int = {
        throw new RuntimeException()
    }

    def substringWidth(font : Font, str : String, offset : Int, len : Int) : Int = {
        throw new RuntimeException()
    }

}

object SWTJOGLProcessor {
    private val instance : SWTJOGLProcessor = new SWTJOGLProcessor()

    /**      * @return the instance      */
    def getInstance() : SWTJOGLProcessor = {
        return SWTJOGLProcessor.instance
    }

}


