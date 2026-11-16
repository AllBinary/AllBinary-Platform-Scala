/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.password

import _root_.java.util.HashMap
import _root_.java.util.Random
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings

class Password(param_password : String) {

    val logUtil : LogUtil = LogUtil.getInstance()

    //private static String className = "Password";
    private var password : String = null

    //Constructor
    {
        val password : String = param_password
        this.password = password
    }

    def set(value : String) : Unit = {
        this.password = value
    }

    def get() : String = {
        return this.password
    }

    def isValid() : _root_.java.lang.Boolean = {
        val commonStrings : CommonStrings = CommonStrings.getInstance()
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VALIDATION)) {
                this.logUtil.putF("Password: " + this.password, this, commonStrings.IS_VALID)
            }
            if (!StringValidationUtil.getInstance().isValidRequired(this.password, 6, UserData.MAXLEN)) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VALIDATION)) {
                    this.logUtil.putF("Password is invalid", this, commonStrings.IS_VALID)
                }
                valid = _root_.java.lang.Boolean.FALSE
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VALIDATIONERROR)) {
                    this.logUtil.put("Failed to validate form", "Password", commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def getValidationInfo() : String = {
        if (!StringValidationUtil.getInstance().isValidRequired(this.password, 6, UserData.MAXLEN)) {
            return "Please enter a Password with more than 6 characters.<br />"
        }
        val stringUtil : StringUtil = StringUtil.getInstance()
        return stringUtil.EMPTY_STRING
    }

    def toVector(secret : String) : BasicArrayList = {
        this.password = StringUtil.getInstance().getNonNull(this.password)
        var random : Int = new Random().nextInt(SuperCrypt.KEYMAX)
        var vector : BasicArrayList = new BasicArrayListD()
        vector.add(new Integer(random).toString())
        vector.add(secret)
        vector.add(new SuperCrypt(random).encrypt(this.password))
        return vector
    }

    def toHashMap(secret : String) : HashMap[Object, Object] = {
        this.password = StringUtil.getInstance().getNonNull(this.password)
        var values : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var random : Int = new Random().nextInt(SuperCrypt.KEYMAX)
        values.put(EntryData.getInstance().ENCRYPTION, new Integer(random).toString())
        values.put(UserData.SECRET, secret)
        values.put(UserData.PASSWORD, new SuperCrypt(random).encrypt(this.password))
        return values
    }

}


