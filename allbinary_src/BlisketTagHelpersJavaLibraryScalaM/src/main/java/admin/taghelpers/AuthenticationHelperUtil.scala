/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.user.role.BasicUserRole
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.globals.URLGLOBALS
import _root_.org.allbinary.logic.communication.http.file.upload.HttpFilePermissions
import _root_.org.allbinary.logic.communication.http.request.HttpRequestUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.path.AbPath
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonLabels

class AuthenticationHelperUtil {
    import _root_.admin.taghelpers.AuthenticationHelperUtil.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    final def isAuthorized(authenticationHelper : AuthenticationHelper, filePath : String) : Boolean = {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEWERROR)) {
            this.logUtil.putF(CommonLabels.getInstance().START + filePath, this, "isAuthorized()")
        }
        var endIndex : Int = HttpRequestUtil.getInstance().getLastSeparatorIndex(filePath)
        var fullPath : AbPath = new AbPath(URLGLOBALS.getWebappPath() + filePath.substring(0, endIndex), StringUtil.getInstance().EMPTY_STRING)
        var downloadFilePermissions : HttpFilePermissions = new HttpFilePermissions(fullPath)
        var userRoles : BasicArrayList = downloadFilePermissions.getUserRoles()
        var userRole : UserRole = authenticationHelper.getRole()
        var basicUserRole : BasicUserRole = userRole.getBasicUserRole()
        if (userRoles.contains(basicUserRole)) {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Authorized", this, "isAuthorized()")
            }
            return true
        } else {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VIEW)) {
                this.logUtil.putF("Not Authorized: " + basicUserRole.toString(), this, "isAuthorized()")
            }
            return false
        }
        throw new IllegalStateException()
    }

}

object AuthenticationHelperUtil {
    private val instance : AuthenticationHelperUtil = new AuthenticationHelperUtil()

    def getInstance() : AuthenticationHelperUtil = {
        return AuthenticationHelperUtil.instance
    }

}


