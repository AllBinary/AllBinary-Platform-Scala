/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.media.image

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil

class InputImageType private(param_name : String, param_index : Int) {
    import _root_.org.allbinary.input.media.image.InputImageType.{*}

    private var name : String = null

    private var index : Int = 0

    //Constructor
    {
        val name : String = param_name
        val index : Int = param_index
        this.name = name
        this.index = index
        InputImageType.TYPE_VECTOR.add(this)
        InputImageType.hashMap.put(this.getName(), this)
    }

    override def toString() : String = {
        return "ImageType: " + this.getName()
    }

    def getName() : String = {
        return this.name
    }

    def getIndex() : Int = {
        return this.index
    }

}

object InputImageType {
    private var hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]

    private val TYPE_VECTOR : BasicArrayList = new BasicArrayListD()

    var CAPTURE : InputImageType = new InputImageType("Capture", 0)

    var COMPARISON : InputImageType = new InputImageType("Comparison", 1)

    var MOTION : InputImageType = new InputImageType("Motion", 2)

    def getInstance(imageTypeString : String) : InputImageType = {
        return InputImageType.hashMap.get(imageTypeString).asInstanceOf[InputImageType]
    }

    def getAllAsVector() : BasicArrayList = {
        return InputImageType.TYPE_VECTOR
    }

}


