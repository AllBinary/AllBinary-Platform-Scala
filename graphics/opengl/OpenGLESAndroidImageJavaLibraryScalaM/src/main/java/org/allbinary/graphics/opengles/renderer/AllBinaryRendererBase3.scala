/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.graphics.opengles.renderer

import _root_.javax.microedition.khronos.opengles.GL10
import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.image.opengles.OpenGLESImage
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

/**  *  * @author User  */
class AllBinaryRendererBase3 {

    val list : BasicArrayList = new BasicArrayListD()

    def update(gl : GL10) : Unit = {
        //this.logUtil.putF(CommonLabels.getInstance().START_LABEL + list, this, this.commonStrings.UPDATE);

        {
            while (this.list.size() > 0) {
                val openGLESImage : OpenGLESImage = this.list.removeAt(0).asInstanceOf[OpenGLESImage]
                if (openGLESImage != null) {
                    openGLESImage.set(gl)
                }
            }
        }
    }

    def add(image : Image) : Unit = {
        this.list.add(image)
    }

}


