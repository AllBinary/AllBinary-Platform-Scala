/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation

import _root_.java.util.Map
import _root_.org.osgi.framework.BundleContext

trait RemoteFramework {

    def connect(host : String) : BundleContext

    def disconnect(bc : BundleContext) : Unit

    def getSystemProperties(bc : BundleContext) : Map[Object, Object]

}


