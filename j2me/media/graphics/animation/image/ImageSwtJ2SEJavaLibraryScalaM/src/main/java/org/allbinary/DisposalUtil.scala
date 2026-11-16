/*  * AllBinary Open License Version 1  * Copyright (c) 2022 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary

import _root_.javax.microedition.lcdui.Image
import _root_.org.allbinary.string.CommonStrings
import _root_.org.eclipse.swt.graphics.Resource
import _root_.org.microemu.device.swt.SwtMutableImage

/**  *  * @author User  */
class DisposalUtil {
    import _root_.org.allbinary.DisposalUtil.{*}

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    def disposeImage(image : Image) : Unit = {
        if (image == null) {
            return
        }
        if (image.isMutable()) {
            val mutableImage : SwtMutableImage = image.asInstanceOf[SwtMutableImage]
            this.disposeResource(mutableImage.getImage().asInstanceOf[Resource])
        } else {
        }
    }

    def disposeResource(resource : Resource) : Unit = {
        if (!resource.isDisposed()) {
            System.out.println(this.commonStrings.CLOSE)
            resource.dispose()
        }
    }

}

object DisposalUtil {
    private val instance : DisposalUtil = new DisposalUtil()

    /**      * @return the instance      */
    def getInstance() : DisposalUtil = {
        return DisposalUtil.instance
    }

}


