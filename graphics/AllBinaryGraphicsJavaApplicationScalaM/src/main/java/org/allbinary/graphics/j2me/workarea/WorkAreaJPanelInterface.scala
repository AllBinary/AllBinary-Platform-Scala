/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.j2me.workarea

import _root_.org.w3c.dom.Document

trait WorkAreaJPanelInterface extends _root_.java.awt.event.KeyListener {

    def getName() : String

    def deselect() : Unit

    def select() : Unit

    def changeZoom(factor : Int) : Unit

    def explodeAll() : Unit

    def autoRotate(increments : Int, totalAngle : Int) : Unit

    def autoExplode(numberOfFrames : Int, explodeType : Int) : Unit

    def autoMirror() : Unit

    def play() : Unit

    def stop() : Unit

    def isPlaying() : Boolean

    def toDocument() : Document

}


