/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.data.tables.user

import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.init.db.UserDbInitInfo
import _root_.org.allbinary.business.user.CreateUserFactory
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.UserInterface
import _root_.org.allbinary.business.user.modules.User
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.business.user.role.UserRoleFactory
import _root_.org.allbinary.globals.GLOBALS2
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlBean
import _root_.org.allbinary.logic.control.crypt.SuperCrypt
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.string.CommonSeps

class UserEntity() extends AbSqlBean(new UserDbInitInfo()) with UserEntityInterface {

    val logUtil_UserEntity : LogUtil = LogUtil.getInstance()

    private val tableName : String = "user"

    private val COMMAND_SUCCESS_FOR_USER : String = "Command Success for user: "

    private val PASSWORD_LABEL : String = " Password: "

    private val EQUALS : String = "=="

    private val COMMAND_SUCCESS_BUT_LOGIN_FAILED : String = "Command Success but login failed for user: "

    private val INVALID_PASSWORD_LABEL : String = " Password: \n\""

    private val NOT_EQUAL : String = "\"!=\""

    private val END_QUOTES : String = CommonSeps.getInstance().QUOTE

    //Constructor
    {
        this.setTableName(this.tableName)
    }

    override def insert(values : BasicArrayList) : Unit = {
        try {
            super.insert(values)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_UserEntity.putF(this.commonStrings.SUCCESS, this, INSERT)
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_UserEntity.put(this.commonStrings.FAILURE, this, INSERT, e)
                }
            }
        }
    }

    def getAdministrators() : BasicArrayList = {
        return this.getUsersWithRole(UserRoleFactory.getInstance().ADMINISTRATOR)
    }

    def getStoreManagers(storeFrontInterface : StoreFrontInterface) : BasicArrayList = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var usersVector : BasicArrayList = new BasicArrayListD()
        keysAndValues.put(UserRoleData.NAME.toString(), UserRoleFactory.getInstance().STOREMANAGER.toString())
        keysAndValues.put(UserData.PERMISSIONS, storeFrontInterface.getName())
        var usersHashMapVector : BasicArrayList = super.getRows(keysAndValues)
        var size : Int = usersHashMapVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var userHashMap : HashMap[Object, Object] = usersHashMapVector.get(i).asInstanceOf[HashMap[Object, Object]]
                if (userHashMap != null) {
                    usersVector.add(new User(userHashMap))
                }
                i += 1
            }
        }
        return usersVector
    }

    def getCustomers() : BasicArrayList = {
        return this.getUsersWithRole(UserRoleFactory.getInstance().CUSTOMER)
    }

    def getUsersWithRole(userRole : UserRole) : BasicArrayList = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var usersVector : BasicArrayList = new BasicArrayListD()
        keysAndValues.put(UserRoleData.NAME.toString(), userRole.toString())
        var usersHashMapVector : BasicArrayList = super.getRows(keysAndValues)
        val size : Int = usersHashMapVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var userHashMap : HashMap[Object, Object] = usersHashMapVector.get(index).asInstanceOf[HashMap[Object, Object]]
                if (userHashMap != null) {
                    usersVector.add(new User(userHashMap))
                }
                index += 1
            }
        }
        return usersVector
    }

    def getUsers(storeFrontInterface : StoreFrontInterface) : BasicArrayList = {
        var keysAndValues : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        var usersVector : BasicArrayList = new BasicArrayListD()
        keysAndValues.put(StoreFrontData.getInstance().NAME, storeFrontInterface.getName())
        var usersHashMapVector : BasicArrayList = super.getRows(keysAndValues)
        val size : Int = usersHashMapVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var userHashMap : HashMap[Object, Object] = usersHashMapVector.get(index).asInstanceOf[HashMap[Object, Object]]
                if (userHashMap != null) {
                    usersVector.add(new User(userHashMap))
                }
                index += 1
            }
        }
        return usersVector
    }

    def getUser(userName : String) : UserInterface = {
        var row : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        row.put(UserData.USERNAME, userName)
        var userHashMap : HashMap[Object, Object] = super.getRow(row).asInstanceOf[HashMap[Object, Object]]
        if (userHashMap != null) {
            return CreateUserFactory.getInstance(userHashMap)
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    override def deleteWhere(key : String, value : String) : Unit = {
        try {
            super.deleteWhere(key, value)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                this.logUtil_UserEntity.putF(this.commonStrings.SUCCESS, this, "deleteWhere")
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_UserEntity.put(this.commonStrings.FAILURE, this, "deleteWhere", e)
                }
            }
        }
    }

    /*    public String getUserRole(String userName, String password)    {       try       {          if(this.login(userName,password).compareTo(org.allbinary.globals.GLOBALS2.LOGINSUCCESS)==0)          {             String role = new String(super.getField(UserData.USERNAME,userName,RoleData.ROLE));                          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))             {                this.logUtil.putF("Command Successful", this, "getUserRole");             }             return role;          }          else          {             if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))             {                this.logUtil.putF("Command Failed Incorrect Login", this, "getUserRole");             }             return "Incorrect Login";          }                 }       catch(Exception e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLLOGGING))          {             this.logUtil.put(this.commonStrings.FAILURE,this,"getUserRole",e);          }          return "Error";       }    }    */
    def login(userName : String, password : String) : String = {
        try {
            var isUserNameAndPasswordCorrect : Int = 0
            var result : String = super.getField(UserData.USERNAME, userName, UserData.PASSWORD)
            var encryption : String = super.getField(UserData.USERNAME, userName, EntryData.getInstance().ENCRYPTION)
            if ((encryption != null) && (encryption.compareTo(this.stringUtil.EMPTY_STRING) != 0)) {
                isUserNameAndPasswordCorrect = result.compareTo(new SuperCrypt(new Integer(encryption).intValue()).encrypt(password))
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_UserEntity.putF(("Command Success but login failed for user: " + userName) + " because user did not exist", this, "login")
                }
                return GLOBALS2.LOGINFAILED
            }
            if (isUserNameAndPasswordCorrect == 0) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append(this.COMMAND_SUCCESS_FOR_USER)
                    stringBuffer.append(userName)
                    stringBuffer.append(this.PASSWORD_LABEL)
                    stringBuffer.append(password)
                    stringBuffer.append(this.EQUALS)
                    stringBuffer.append(result)
                    this.logUtil_UserEntity.putF(stringBuffer.toString(), this, "login")
                }
                return GLOBALS2.LOGINSUCCESS
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    var stringBuffer : StringMaker = new StringMaker()
                    stringBuffer.append(this.COMMAND_SUCCESS_BUT_LOGIN_FAILED)
                    stringBuffer.append(userName)
                    stringBuffer.append(this.INVALID_PASSWORD_LABEL)
                    stringBuffer.append(new SuperCrypt(new Integer(encryption).intValue()).encrypt(password))
                    stringBuffer.append(this.NOT_EQUAL)
                    stringBuffer.append(result)
                    stringBuffer.append(this.END_QUOTES)
                    this.logUtil_UserEntity.putF(stringBuffer.toString(), this, "login")
                }
                return GLOBALS2.LOGINFAILED
            }
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLLOGGING)) {
                    this.logUtil_UserEntity.put(this.commonStrings.FAILURE, this, "login", e)
                }
                return "Error"
            }
        }
        throw new IllegalStateException()
    }

    def update(userName : String, updatedValues : HashMap[Object, Object]) : Unit = {
        super.updateWhere(UserData.USERNAME, userName, updatedValues)
    }

    /*    public String getUserForm(String userName)    {       return super.getInputWhere(UserData.USERNAME,userName);    } */
    def dropTables() : String = {
        return super.dropTable()
    }

    /*    public String getTable(String userName)    {                   return super.getTableWhere(UserData.USERNAME,userName);    }        public String getTable()    {                   return super.getTable();d    } */
    final def createTableStatement() : String = {
        val entryData : EntryData = EntryData.getInstance()
        val stringBuffer : StringMaker = new StringMaker()
        stringBuffer.append(this.sqlStrings.CREATE_TABLE).append(tableName).append(this.sqlStrings.START).append(UserData.USERNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(UserData.PREFIXNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.FIRSTNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.LASTNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.MIDDLENAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.SUFFIXNAME).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.COMPANY).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.POSITIONATCOMPANY).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.MAINEMAIL).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(UserData.SECONDARYEMAIL).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.HOMEPHONE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.CELLPHONE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.WORKPHONE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.OTHERCONTACT).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.ELECTRONICDEVICE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.FAX).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserRoleData.NAME.toString()).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(UserData.CONFIGURATION).append(this.sqlTypeStrings.BLOB_NOT_NULL).append(UserData.PERMISSIONS).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(entryData.ENCRYPTION).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(UserData.SECRET).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(UserData.PASSWORD).append(this.sqlTypeStrings.MAX_CHAR_COLUMN_NOT_NULL).append(entryData.ENABLE).append(this.sqlTypeStrings.MAX_CHAR_COLUMN).append(entryData.TIMECREATED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(entryData.LASTMODIFIED).append(this.sqlTypeStrings.MAX_BIG_INT_UNSIGNED_NOT_NULL).append(this.sqlStrings.PRIMARY_KEY).append(UserData.USERNAME).append(this.sqlStrings.END)
        return stringBuffer.toString()
    }

    def createTable() : String = {
        return super.createTable(this.createTableStatement())
    }

    //Needed for polyglot do not remove
    override def dropTable() : String = {
        return super.dropTable()
    }

}


