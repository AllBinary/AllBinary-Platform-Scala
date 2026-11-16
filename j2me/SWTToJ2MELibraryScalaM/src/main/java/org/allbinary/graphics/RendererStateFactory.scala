/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics


class RendererStateFactory {
    import _root_.org.allbinary.graphics.RendererStateFactory.{*}

    private var loaded : Boolean = false

    private var surfaceChanged : Boolean = false

    def setLoaded(loaded : Boolean) : Unit = {
        this.loaded = loaded
    }

    def isLoaded() : Boolean = {
        return this.loaded
    }

    def setSurfaceChanged(initialized : Boolean) : Unit = {
        this.surfaceChanged = initialized
    }

    def isSurfaceChanged() : Boolean = {
        return this.surfaceChanged
    }

}

object RendererStateFactory {
    private val instance : RendererStateFactory = new RendererStateFactory()

    def getInstance() : RendererStateFactory = {
        return RendererStateFactory.instance
    }

}


