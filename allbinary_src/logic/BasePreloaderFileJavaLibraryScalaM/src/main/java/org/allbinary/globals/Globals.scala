/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.globals

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.loader.WebappClassLoaderInfo
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.string.CommonStrings

class Globals private() {
    import _root_.org.allbinary.globals.Globals.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    def init(classLoader : ClassLoader, pathString : String) : Unit = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        val appUrlGlobals : AppUrlGlobals = new AppUrlGlobals()
        appUrlGlobals.setWebappPath(pathString)
        URLGLOBALS.init(appUrlGlobals)
        WebappClassLoaderInfo.setLoader(classLoader)
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append("Setting Up AllBinary System Configuration Args: ")
        stringBuffer.append(pathString)
        stringBuffer.append(" ClassLoader: ")
        stringBuffer.append(classLoader.getClass().getName())
        this.logUtil.putF(stringBuffer.toString(), this, commonStrings.INIT)
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (stringValidationUtil.isEmpty(pathString)) {
            stringBuffer.delete(0, stringBuffer.length())
            stringBuffer.append("No Path Provided. Using Process Path: ")
            stringBuffer.append(pathString)
            stringBuffer.append(CommonSeps.getInstance().SPACE)
            stringBuffer.append(CommonSeps.getInstance().EQUALS)
            stringBuffer.append(CommonSeps.getInstance().SPACE)
            stringBuffer.append(URLGLOBALS.getWebappPath())
            //pathString = WebappPathCmdLineFile.getPath("./");
            this.logUtil.putF(stringBuffer.toString(), this, commonStrings.INIT)
        }
        stringBuffer.delete(0, stringBuffer.length())
        stringBuffer.append("Webapp Path Set To: ")
        stringBuffer.append(URLGLOBALS.getWebappPath())
        this.logUtil.putF(stringBuffer.toString(), this, commonStrings.INIT)
    }

}

object Globals {
    private val instance : Globals = new Globals()

    def getInstance() : Globals = {
        return Globals.instance
    }

}


