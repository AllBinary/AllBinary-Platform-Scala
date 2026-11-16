/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.transform.info

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext

/**  *  * @author user  */
class TransformInfoHttpStoreFactory private() extends TransformInfoFactoryInterface {
    import _root_.org.allbinary.logic.visual.transform.info.TransformInfoHttpStoreFactory.{*}

    def getInstance(databaseHashMap : HashMap[Object, Object], propertiesHashMap : HashMap[Object, Object], pageContext : PageContext) : TransformInfoInterface = {
        return new TransformInfoHttpStore(databaseHashMap, propertiesHashMap, pageContext)
    }

}

object TransformInfoHttpStoreFactory {
    private val instance : TransformInfoHttpStoreFactory = new TransformInfoHttpStoreFactory()

    /**      * @return the instance      */
    def getInstance() : TransformInfoHttpStoreFactory = {
        return TransformInfoHttpStoreFactory.instance
    }

}


