/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.username

import _root_.java.util.HashMap
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings

class UserName private() {
    import _root_.org.allbinary.business.user.username.UserName.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private String className = "UserName";
    private var userName : String = null

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        this.userName = hashMap.get(UserData.USERNAME).asInstanceOf[String]
    }

    /*    public UserName()    {       this.userName = Ab    }    */
    def isValid() : _root_.java.lang.Boolean = {
        try {
            return this.isValid(this.userName)
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate form", this, "isUserNameValid()", e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def get() : String = {
        return this.userName
    }

    def isValid(aUserName : String) : _root_.java.lang.Boolean = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            val booleanFactory : BooleanFactory = BooleanFactory.getInstance()
            var valid : _root_.java.lang.Boolean = booleanFactory.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VALIDATION)) {
                this.logUtil.putF("UserName: " + aUserName, this, commonStrings.IS_VALID)
            }
            if (!StringValidationUtil.getInstance().isValidRequired(aUserName, 5, UserData.MAXLEN)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VALIDATION)) {
                    this.logUtil.putF("UserName is invalid", this, commonStrings.IS_VALID)
                }
                valid = booleanFactory.FALSE
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate form", this, commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

}

object UserName {
    private val instance : UserName = new UserName()

    def getInstance() : UserName = {
        return UserName.instance
    }

    def getValidationInfo(aUserName : String) : String = {
        if (!StringValidationUtil.getInstance().isValidRequired(aUserName, 5, UserData.MAXLEN)) {
            return "Please enter a User Name with more than 5 characters.<br/>"
        }
        return StringUtil.getInstance().EMPTY_STRING
    }

}


