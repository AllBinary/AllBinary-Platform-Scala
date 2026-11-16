/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.modules

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.modules.configuration.UserConfigurationDomDocumentMapping
import _root_.org.allbinary.business.user.modules.configuration.UserConfigurationInterface
import _root_.org.allbinary.business.user.modules.configuration.UserConfigurationInterfaceFactory
import _root_.org.allbinary.business.user.password.Password
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.business.user.role.UserRoleB
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.business.user.username.UserName
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.http.request.RequestParams
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionData
import _root_.org.allbinary.logic.communication.http.request.session.WeblisketSessionInterface
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class User() extends UserInterface {

    val logUtil : LogUtil = LogUtil.getInstance()

    private var userName : String = null

    private var prefixName : String = null

    private var firstName : String = null

    private var lastName : String = null

    private var middleName : String = null

    private var suffixName : String = null

    private var company : String = null

    private var positionAtCompany : String = null

    private var mainEmail : String = null

    private var secondaryEmail : String = null

    private var homePhone : String = null

    private var cellPhone : String = null

    private var workPhone : String = null

    private var otherContact : String = null

    private var electronicDevice : String = null

    private var fax : String = null

    private var role : UserRole = null

    private var encryption : String = null

    private var secret : String = null

    private var password : Password = null

    private var enable_User : String = null

    private var permissions : String = null

    private var userConfigurationInterface : UserConfigurationInterface = null

    /*   protected final String[] HEADING = {USERNAME,PREFIXNAME,FIRSTNAME,LASTNAME,       MIDDLENAME,SUFFIXNAME,COMPANY,POSITIONATCOMPANY,MAINEMAIL,SECONDARYEMAIL,       HOMEPHONE,CELLPHONE,WORKPHONE,OTHERCONTACT,ELECTRONICDEVICE,FAX,ROLE,       ENCRYPTION,SECRET,PASSWORD,DEFAULTSHIPPINGADDRESS,DEFAULTBILLINGADDRESS};  */
    //Constructor
    {
        //Use Default for role - future Imp will allow adjusting config with request - then move this default code to when user is new in view (same for storefront)
        this.userConfigurationInterface = UserConfigurationInterfaceFactory.getInstance()
        this.password = new Password(StringUtil.getInstance().EMPTY_STRING)
    }

    def this(request : HttpServletRequest) = {
        this()
        this.getFormData(new RequestParams(request).toHashMap())
        //Use Default for role - future Imp will allow adjusting config with request - then move this default code to when user is new in view (same for storefront)
        this.userConfigurationInterface = UserConfigurationInterfaceFactory.getInstance(this.getRole())
    }

    def this(userHashMap : HashMap[Object, Object]) = {
        this()
        this.getFormData(userHashMap)
        //Use Blob data from database
        this.userConfigurationInterface = UserConfigurationInterfaceFactory.getInstance(this.getRole())
    }

    def getFormData(userHashMap : HashMap[Object, Object]) : Unit = {
        this.userName = new UserName(userHashMap).get()
        val stringUtil : StringUtil = StringUtil.getInstance()
        var passwordString : String = stringUtil.getNonNull(userHashMap.get(UserData.PASSWORD).asInstanceOf[String])
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (stringValidationUtil.isEmpty(this.userName) && stringValidationUtil.isEmpty(passwordString)) {
            this.userName = stringUtil.getNonNull(userHashMap.get(WeblisketSessionData.REMOVABLEUSERNAME).asInstanceOf[String])
            passwordString = stringUtil.getNonNull(userHashMap.get(WeblisketSessionData.REMOVABLEPASSWORD).asInstanceOf[String])
        }
        var encryption : String = stringUtil.getNonNull(userHashMap.get(EntryData.getInstance().ENCRYPTION).asInstanceOf[String])
        var secret : String = stringUtil.getNonNull(userHashMap.get(UserData.SECRET).asInstanceOf[String])
        this.password = new Password(passwordString)
        this.prefixName = stringUtil.getNonNull(userHashMap.get(UserData.PREFIXNAME).asInstanceOf[String])
        this.firstName = stringUtil.getNonNull(userHashMap.get(UserData.FIRSTNAME).asInstanceOf[String])
        this.lastName = stringUtil.getNonNull(userHashMap.get(UserData.LASTNAME).asInstanceOf[String])
        this.middleName = stringUtil.getNonNull(userHashMap.get(UserData.MIDDLENAME).asInstanceOf[String])
        this.suffixName = stringUtil.getNonNull(userHashMap.get(UserData.SUFFIXNAME).asInstanceOf[String])
        this.company = stringUtil.getNonNull(userHashMap.get(UserData.COMPANY).asInstanceOf[String])
        this.positionAtCompany = stringUtil.getNonNull(userHashMap.get(UserData.POSITIONATCOMPANY).asInstanceOf[String])
        this.mainEmail = stringUtil.getNonNull(userHashMap.get(UserData.MAINEMAIL).asInstanceOf[String])
        this.secondaryEmail = stringUtil.getNonNull(userHashMap.get(UserData.SECONDARYEMAIL).asInstanceOf[String])
        this.homePhone = stringUtil.getNonNull(userHashMap.get(UserData.HOMEPHONE).asInstanceOf[String])
        this.cellPhone = stringUtil.getNonNull(userHashMap.get(UserData.CELLPHONE).asInstanceOf[String])
        this.workPhone = stringUtil.getNonNull(userHashMap.get(UserData.WORKPHONE).asInstanceOf[String])
        this.otherContact = stringUtil.getNonNull(userHashMap.get(UserData.OTHERCONTACT).asInstanceOf[String])
        this.electronicDevice = stringUtil.getNonNull(userHashMap.get(UserData.ELECTRONICDEVICE).asInstanceOf[String])
        this.fax = stringUtil.getNonNull(userHashMap.get(UserData.FAX).asInstanceOf[String])
        this.role = UserRoleB.getRole(userHashMap.get(UserRoleData.NAME.toString()).asInstanceOf[String])
        this.permissions = stringUtil.getNonNull(userHashMap.get(UserData.PERMISSIONS).asInstanceOf[String])
        //TWB Temporary for store manager permissions
        if (!stringValidationUtil.isEmpty(this.permissions) && (this.permissions.compareTo(StoreFrontData.getInstance().NAME) == 0)) {
            this.permissions = stringUtil.getNonNull(userHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String])
        } else if (this.permissions == null) {
            this.permissions = "No Permissions"
        }
        this.enable_User = stringUtil.getNonNull(userHashMap.get(EntryData.getInstance().ENABLE).asInstanceOf[String])
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (!UserName.getInstance().isValid(this.userName).booleanValue()) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (!this.password.isValid().booleanValue()) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            if (!stringValidationUtil.isValidRequired(this.firstName, 1, UserData.MAXLEN)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (!stringValidationUtil.isValidRequired(this.lastName, 1, UserData.MAXLEN)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (!stringValidationUtil.isValidRequired(this.mainEmail, 1, UserData.MAXLEN) || (this.mainEmail.indexOf("@") == -1)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().VALIDATIONERROR)) {
                    val commonStrings : CommonStrings = CommonStrings.getInstance()
                    this.logUtil.put("Failed to validate form", this, commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            val stringBuffer : StringMaker = new StringMaker()
            stringBuffer.append(UserName.getValidationInfo(this.userName))
            stringBuffer.append(this.password.getValidationInfo())
            if (!stringValidationUtil.isValidRequired(this.firstName, 1, UserData.MAXLEN)) {
                stringBuffer.append("Please enter a valid First Name.<br />")
            }
            if (!stringValidationUtil.isValidRequired(this.lastName, 1, UserData.MAXLEN)) {
                stringBuffer.append("Please enter a valid Last Name.<br />")
            }
            if (!stringValidationUtil.isValidRequired(this.mainEmail, 1, UserData.MAXLEN) || (this.mainEmail.indexOf("@") == -1)) {
                stringBuffer.append("Please enter a valid email address.<br />")
            }
            return stringBuffer.toString()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to generate validation error info", this, "validationInfo()", e)
                }
                return "Error Validating Form"
            }
        }
        throw new IllegalStateException()
    }

    def setUserName(value : String) : Unit = {
        this.userName = value
    }

    def setPrefixName(value : String) : Unit = {
        this.prefixName = value
    }

    def setFirstName(value : String) : Unit = {
        this.firstName = value
    }

    def setLastName(value : String) : Unit = {
        this.lastName = value
    }

    def setMiddleName(value : String) : Unit = {
        this.middleName = value
    }

    def setSuffixName(value : String) : Unit = {
        this.suffixName = value
    }

    def setCompany(value : String) : Unit = {
        this.company = value
    }

    def setPositionAtCompany(value : String) : Unit = {
        this.positionAtCompany = value
    }

    def setMainEmail(value : String) : Unit = {
        this.mainEmail = value
    }

    def setSecondaryEmail(value : String) : Unit = {
        this.secondaryEmail = value
    }

    def setHomePhone(value : String) : Unit = {
        this.homePhone = value
    }

    def setCellPhone(value : String) : Unit = {
        this.cellPhone = value
    }

    def setWorkPhone(value : String) : Unit = {
        this.workPhone = value
    }

    def setOtherContact(value : String) : Unit = {
        this.otherContact = value
    }

    def setElectronicContact(value : String) : Unit = {
        this.electronicDevice = value
    }

    def setFax(value : String) : Unit = {
        this.fax = value
    }

    def setRole(role : UserRole) : Unit = {
        this.role = role
    }

    def setPermissions(value : String) : Unit = {
        this.permissions = value
    }

    def setEncryption(value : String) : Unit = {
        this.encryption = value
    }

    def setSecret(value : String) : Unit = {
        this.secret = value
    }

    def setPassword(value : String) : Unit = {
        this.password.set(value)
    }

    def enable() : Unit = {
        this.setEnable("Yes")
    }

    def disable() : Unit = {
        this.setEnable("No")
    }

    def setEnable(enable : String) : Unit = {
        this.enable_User = enable
    }

    def getUserName() : String = {
        return this.userName
    }

    def getPrefixName() : String = {
        return this.prefixName
    }

    def getFirstName() : String = {
        return this.firstName
    }

    def getLastName() : String = {
        return this.lastName
    }

    def getMiddleName() : String = {
        return this.middleName
    }

    def getSuffixName() : String = {
        return this.suffixName
    }

    def getCompany() : String = {
        return this.company
    }

    def getPositionAtCompany() : String = {
        return this.positionAtCompany
    }

    def getMainEmail() : String = {
        return this.mainEmail
    }

    def getSecondaryEmail() : String = {
        return this.secondaryEmail
    }

    def getHomePhone() : String = {
        return this.homePhone
    }

    def getCellPhone() : String = {
        return this.cellPhone
    }

    def getWorkPhone() : String = {
        return this.workPhone
    }

    def getOtherContact() : String = {
        return this.otherContact
    }

    def getElectronicContact() : String = {
        return this.electronicDevice
    }

    def getFax() : String = {
        return this.fax
    }

    def getRole() : UserRole = {
        return this.role
    }

    def getPermissions() : String = {
        return this.permissions
    }

    def getEncryption() : String = {
        return this.encryption
    }

    def getSecret() : String = {
        return this.secret
    }

    def getPassword() : String = {
        return this.password.get()
    }

    def toVector() : BasicArrayList = {
        var values : BasicArrayList = new BasicArrayListD()
        values.add(this.userName)
        values.add(this.prefixName)
        values.add(this.firstName)
        values.add(this.lastName)
        values.add(this.middleName)
        values.add(this.suffixName)
        values.add(this.company)
        values.add(this.positionAtCompany)
        values.add(this.mainEmail)
        values.add(this.secondaryEmail)
        values.add(this.homePhone)
        values.add(this.cellPhone)
        values.add(this.workPhone)
        values.add(this.otherContact)
        values.add(this.electronicDevice)
        values.add(this.fax)
        values.add(this.getRole().toString())
        var userConfigurationDomDocumentMapping : UserConfigurationDomDocumentMapping = new UserConfigurationDomDocumentMapping(this.getUserConfigurationInterface())
        values.add(userConfigurationDomDocumentMapping.toDomDocumentString())
        values.add(this.permissions)
        values.addAllList(this.password.toVector(this.secret))
        values.add(this.enable_User)
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.add(time)
        values.add(time)
        return values
    }

    def toHashMap() : HashMap[Object, Object] = {
        var values : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        values.put(UserData.USERNAME, userName)
        values.put(UserData.PREFIXNAME, prefixName)
        values.put(UserData.FIRSTNAME, firstName)
        values.put(UserData.LASTNAME, lastName)
        values.put(UserData.MIDDLENAME, middleName)
        values.put(UserData.SUFFIXNAME, suffixName)
        values.put(UserData.COMPANY, company)
        values.put(UserData.POSITIONATCOMPANY, positionAtCompany)
        values.put(UserData.MAINEMAIL, mainEmail)
        values.put(UserData.SECONDARYEMAIL, secondaryEmail)
        values.put(UserData.HOMEPHONE, homePhone)
        values.put(UserData.CELLPHONE, cellPhone)
        values.put(UserData.WORKPHONE, workPhone)
        values.put(UserData.OTHERCONTACT, otherContact)
        values.put(UserData.ELECTRONICDEVICE, electronicDevice)
        values.put(UserData.FAX, fax)
        if (this.getRole() != null) {
            values.put(UserRoleData.NAME.toString(), this.getRole().toString())
        }
        var userConfigurationDomDocumentMapping : UserConfigurationDomDocumentMapping = new UserConfigurationDomDocumentMapping(this.getUserConfigurationInterface())
        values.put(UserData.CONFIGURATION, userConfigurationDomDocumentMapping.toDomDocumentString())
        values.put(UserData.PERMISSIONS, this.permissions)
        values.putAll(this.password.toHashMap(this.secret))
        values.put(EntryData.getInstance().ENABLE, this.enable_User)
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.put(EntryData.getInstance().LASTMODIFIED, time)
        return values
    }

    def toPasswordHashMap() : HashMap[Object, Object] = {
        return this.password.toHashMap(this.secret)
    }

    def validateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
        weblisketSession.setAuthenticated()
        weblisketSession.setRole(this.getRole())
        weblisketSession.setUserName(this.getUserName())
    }

    def updateSession(weblisketSession : WeblisketSessionInterface) : Unit = {
    }

    def isSessionValid() : _root_.java.lang.Boolean = {
        return _root_.java.lang.Boolean.TRUE
    }

    /*    public void validateSession(    WeblisketSession weblisketSession, RequestParams requestParams)    {       weblisketSession.setAuthenticated();       weblisketSession.setRole(this.getRole());       weblisketSession.setUserName(this.getUserName());    }         public void updateSession(    WeblisketSession weblisketSession, RequestParams requestParams)    {    }         public boolean hasPermission(RequestParams requestParams)    {       return true;    }     */
    def getKey() : Object = {
        return this.userName.asInstanceOf[Object]
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def getUserConfigurationInterface() : UserConfigurationInterface = {
        return this.userConfigurationInterface
    }

    def setUserConfigurationInterface(userConfigurationInterface : UserConfigurationInterface) : Unit = {
        this.userConfigurationInterface = userConfigurationInterface
    }

}


