/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.device


/**  *  * @author User  */
class OpenGLESGraphicsCompositeFactory {
    import _root_.org.allbinary.device.OpenGLESGraphicsCompositeFactory.{*}

    private var openGLESGraphicsFactory : OpenGLESGraphicsFactory = new OpenGLESGraphicsFactory()

    def set(openGLESGraphicsFactory : OpenGLESGraphicsFactory) : Unit = {
        this.openGLESGraphicsFactory = openGLESGraphicsFactory
    }

    def get() : OpenGLESGraphicsFactory = {
        return this.openGLESGraphicsFactory
    }

}

object OpenGLESGraphicsCompositeFactory {
    private val instance : OpenGLESGraphicsCompositeFactory = new OpenGLESGraphicsCompositeFactory()

    /**      * @return the instance      */
    def getInstance() : OpenGLESGraphicsCompositeFactory = {
        return OpenGLESGraphicsCompositeFactory.instance
    }

}


