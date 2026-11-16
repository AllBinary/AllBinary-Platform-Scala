/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.file.upload

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.role.BasicUserRoleFactory
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.AbFile
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.string.CommonStrings

class HttpFilePermissions(param_fullPath : AbPath) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var file : AbFile = null

    private val userRoles : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val fullPath : AbPath = param_fullPath
        this.file = AbFile.createAbFileFromAbPath(new AbPath(fullPath.toFileSystemString(), FileUploadData.getInstance().FILE))
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
            this.logUtil.putF("Loading Privileges: " + fullPath.toFileSystemString(), this, this.commonStrings.CONSTRUCTOR)
        }
        if (this.isFile()) {
            //load file and add user roles
            this.userRoles.add(BasicUserRoleFactory.getInstance().ADMINISTRATOR)
        }
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
            this.logUtil.putF("User Roles: " + this.userRoles, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def isFile() : Boolean = {
        return this.file.isFile()
    }

    /**      * @return the userRoles      */
    def getUserRoles() : BasicArrayList = {
        return this.userRoles
    }

}


