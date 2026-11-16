/* * AllBinary Open License Version 1 * Copyright (c) 2026 AllBinary * * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. * * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. * * Created By: Travis Berthelot * */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.java.io.IOException
import _root_.java.io.InputStream
import _root_.javax.microedition.lcdui.Form
import _root_.javax.microedition.lcdui.Image
import _root_.javax.microedition.lcdui.Item
import _root_.javax.microedition.media.Manager
import _root_.javax.microedition.media.MediaException
import _root_.javax.microedition.media.Player

//like microemu-playn, so the languages without overloading can be generated. J2ME uses the MIDP overloads.
class MIDPUtil {
    import _root_.org.allbinary.MIDPUtil.{*}

    def createImageWH(width : Int, height : Int) : Image = {
        return Image.createImage(width, height)
    }

    def createImageFromByteArray(imageData : Array[Byte], imageOffset : Int, imageLength : Int) : Image = {
        return Image.createImage(imageData, imageOffset, imageLength)
    }

    def createImageFromInputStream(inputStream : InputStream) : Image = {
        return Image.createImage(inputStream)
    }

    def createPlayerFromInputStream(inputStream : InputStream, `type` : String) : Player = {
        return Manager.createPlayer(inputStream, `type`)
    }

    def appendItem(form : Form, item : Item) : Int = {
        return form.append(item)
    }

}

object MIDPUtil {
    private val instance : MIDPUtil = new MIDPUtil()

    /**      * @return the instance      */
    def getInstance() : MIDPUtil = {
        return MIDPUtil.instance
    }

}


