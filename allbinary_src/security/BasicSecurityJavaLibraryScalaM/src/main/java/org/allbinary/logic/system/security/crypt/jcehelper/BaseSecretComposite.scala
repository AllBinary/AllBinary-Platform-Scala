/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.crypt.jcehelper

import _root_.org.allbinary.logic.NullUtil

/**  *  * @author User  */
class BaseSecretComposite {
    import _root_.org.allbinary.logic.system.security.crypt.jcehelper.BaseSecretComposite.{NULL_SECRET_COMPOSITE as _, *}
    def NULL_SECRET_COMPOSITE : BaseSecretComposite = _root_.org.allbinary.logic.system.security.crypt.jcehelper.BaseSecretComposite.NULL_SECRET_COMPOSITE

    def encrypt(array : Array[Byte]) : Array[Byte] = {
        return NullUtil.getInstance().NULL_BYTE_ARRAY
    }

    def decrypt(array : Array[Byte]) : Array[Byte] = {
        return NullUtil.getInstance().NULL_BYTE_ARRAY
    }

}

object BaseSecretComposite {
    val NULL_SECRET_COMPOSITE : BaseSecretComposite = new BaseSecretComposite()

}


