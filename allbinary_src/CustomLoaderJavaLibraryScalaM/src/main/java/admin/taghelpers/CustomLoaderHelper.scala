/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.globals.AppUrlGlobals
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings

class CustomLoaderHelper() {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    def this(hashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this()
    }

    def getWebappPath() : String = {
        try {
            return _root_.org.allbinary.globals.URLGLOBALS.getWebappPath()
        } catch {
            case e : Exception => {
                /*          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().TAGHELPERERROR))          {             LogUtil.put(this.commonStrings.EXCEPTION,this,"getWebappPath()",e);          }*/
                return null
            }
        }
        throw new IllegalStateException()
    }

    def setWebappPath(path : String) : Unit = {
        try {
            var urlGlobals : AppUrlGlobals = new AppUrlGlobals()
            urlGlobals.setWebappPath(path)
            URLGLOBALS.init(urlGlobals)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "setWebappPath()", e)
                }
            }
        }
    }

}


