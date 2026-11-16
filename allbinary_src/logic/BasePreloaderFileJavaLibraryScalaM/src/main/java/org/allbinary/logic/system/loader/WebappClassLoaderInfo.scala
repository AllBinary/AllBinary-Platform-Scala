/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.loader

import _root_.org.allbinary.logic.NullUtil

class WebappClassLoaderInfo private() {
    import _root_.org.allbinary.logic.system.loader.WebappClassLoaderInfo.{*}

}

object WebappClassLoaderInfo {
    private var classLoader : Object = NullUtil.getInstance().NULL_OBJECT

    def setLoader(classLoader : ClassLoader) : Unit = this.synchronized {
        WebappClassLoaderInfo.classLoader = classLoader
    }

    def getLoader() : ClassLoader = this.synchronized {
        return WebappClassLoaderInfo.classLoader.asInstanceOf[ClassLoader]
    }

}


