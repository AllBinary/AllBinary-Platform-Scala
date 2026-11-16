/*  * AllBinary Open License Version 1  * Copyright (c) 2025 AllBinary  *   * By agreeing to this license you and any business entity you represent are  * legally bound to the AllBinary Open License Version 1 legal agreement.  *   * You may obtain the AllBinary Open License Version 1 legal agreement from  * AllBinary or the root directory of AllBinary's AllBinary Platform repository.  *   * Created By: Travis Berthelot  *   */
/* Generated Code Do Not Modify */
package org.osgi.framework


/**  *  * @author User  */
class NullServiceReferenceFactory {
    import _root_.org.osgi.framework.NullServiceReferenceFactory.{*}

    var NULL_SERVICE_REFERENCE : NullServiceReference = new NullServiceReference()

}

object NullServiceReferenceFactory {
    private val instance : NullServiceReferenceFactory = new NullServiceReferenceFactory()

    /**      * @return the instance      */
    def getInstance() : NullServiceReferenceFactory = {
        return NullServiceReferenceFactory.instance
    }

}


