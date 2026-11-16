/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.loader

import _root_.java.lang.reflect.Constructor
import _root_.java.lang.reflect.Method
import _root_.org.allbinary.string.CommonStrings

class NativeLibraryHelperWrapper(param_libraryName : String) {

    private var libraryName : String = null

    private var loader : ClassLoader = null

    private var anyType : Object = null

    //Constructor
    {
        val libraryName : String = param_libraryName
        this.setLibraryName(libraryName)
    }

    def load() : Unit = {
        var params : Array[Object] = new Array[Object](1)
        params(0) = this.getLibraryName()
        var classes : Array[Class[?]] = new Array[Class[?]](1)
        classes(0) = this.getLibraryName().getClass()
        this.loader = new NativeLibraryClassLoader(this.getClass().getClassLoader())
        var myClass : Class[?] = this.loader.loadClass("dynamic.NativeLibraryHelper").asInstanceOf[Class[?]]
        var constructor : Constructor[?] = myClass.getConstructor(classes*).asInstanceOf[Constructor[?]]
        this.anyType = constructor.newInstance(params*)
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        var method : Method = this.anyType.getClass().getMethod(commonStrings.LOAD, null)
        method.invoke(this.anyType, null)
    }

    def unload() : Unit = {
        this.anyType = null
        this.loader = null
        System.gc()
        System.gc()
    }

    override def toString() : String = {
        return "Library: " + this.getLibraryName()
    }

    def getLibraryName() : String = {
        return this.libraryName
    }

    def setLibraryName(libraryName : String) : Unit = {
        this.libraryName = libraryName
    }

}


