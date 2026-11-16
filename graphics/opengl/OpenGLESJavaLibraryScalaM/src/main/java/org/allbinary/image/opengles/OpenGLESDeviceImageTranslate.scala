/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.image.opengles

import _root_.javax.microedition.khronos.opengles.GL10

/**  *  * @author User  */
class OpenGLESDeviceImageTranslate extends OpenGLESImageTranslate {

    var translateX : Float = 0

    var translateY : Float = 0

    var translateX2 : Float = 0

    var translateY2 : Float = 0

    override def translate(gl : GL10, openGLESImage : OpenGLESImage, x : Float, y : Float) : Unit = {
        openGLESImage.imageProcessor.translate(gl, this.translateX + (openGLESImage.openGLESImageProperties.scaleX * x), this.translateY + (openGLESImage.openGLESImageProperties.scaleY * y))
    }

    override def translate2(gl : GL10, openGLESImage : OpenGLESImage) : Unit = {
        openGLESImage.imageProcessor.translate(gl, this.translateX2, this.translateY2)
    }

}


