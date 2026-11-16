/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.tags

import _root_.java.lang.reflect.Method
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.JspTagException
import _root_.admin.taghelpers.TagHelperFactoryInterface
import _root_.org.allbinary.logic.communication.http.request.AbResponseHandler
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.SqlStrings
import _root_.org.allbinary.logic.java.bool.BooleanUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.logic.system.security.licensing.LicensingException
import _root_.tags.PropertiesTag

class TableTag() extends PropertiesTag {

    //extends Table
    val logUtil_TableTag : LogUtil = LogUtil.getInstance()

    private var enabled : String = null

    private var tagHelperFactoryInterface : TagHelperFactoryInterface = null

    private var tagRequestHelperFactoryInterface : TagHelperFactoryInterface = null

    private var requestObject : Object = null

    private var current : Integer = null

    private var total : Integer = null

    //Constructor
    {
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
            this.logUtil_TableTag.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def setIsSelected(enabled : String) : Unit = {
        this.enabled = enabled
    }

    /*     public void setEnabled(String enabled)     {     this.enabled=enabled;     }      */
    def isEnabled() : Boolean = {
        if (!StringValidationUtil.getInstance().isEmpty(this.enabled)) {
            if (BooleanUtil.getInstance().getFromString(this.enabled) || (this.enabled.compareTo("on") == 0)) {
                return true
            }
        }
        return false
    }

    def setTagHelperFactory(tagHelperFactoryInterface : TagHelperFactoryInterface) : Unit = {
        this.tagHelperFactoryInterface = tagHelperFactoryInterface
    }

    def getTagHelperFactoryInterface() : TagHelperFactoryInterface = {
        return this.tagHelperFactoryInterface
    }

    def setTagRequestHelperFactory(tagHelperFactoryInterface : TagHelperFactoryInterface) : Unit = {
        this.tagRequestHelperFactoryInterface = tagHelperFactoryInterface
    }

    def getTagRequestHelperFactoryInterface() : TagHelperFactoryInterface = {
        return this.tagRequestHelperFactoryInterface
    }

    def setCurrent(current : Integer) : Unit = {
        this.current = current
    }

    def getCurrent() : Integer = {
        return this.current
    }

    def setTotal(total : Integer) : Unit = {
        this.total = total
    }

    def getTotal() : Integer = {
        return this.total
    }

    def drop() : String = {
        try {
            val anyType : Object = this.getTagHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("drop", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to drop table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, this.commonStrings.DROP, e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def create() : String = {
        try {
            val anyType : Object = this.getTagHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("create", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to create table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, "create()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def restore() : String = {
        try {
            val anyType : Object = this.getTagHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("restore", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to restore backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, "restore()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def backup() : String = {
        try {
            val anyType : Object = this.getTagHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
            var addressHelperClass : Class[?] = anyType.getClass().asInstanceOf[Class[?]]
            var method : Method = addressHelperClass.getMethod("backup", null)
            var result : String = method.invoke(anyType, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to make backup"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, "backup()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def insert() : String = {
        try {
            var helperClass : Class[?] = this.requestObject.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("insert", null)
            var result : String = method.invoke(this.requestObject, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to insert"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, "insert()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def delete() : String = {
        try {
            var helperClass : Class[?] = this.requestObject.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod(commonStrings.delete, null)
            var result : String = method.invoke(this.requestObject, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to delete"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    /*     public String view() throws LicensingException     {     try     {     Class helperClass = object.getClass();     Method method = helperClass.getMethod("view",null);      String result = (String) method.invoke(object,null);     return result;     }     catch(LicensingException e)     {     throw e;     }     catch(Exception e)     {     String error = "Failed to view";      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLTAGSERROR))     {     this.logUtil.put(this.commonStrings.EXCEPTION,this,"view()",e);     }     return error;     }     }      public String edit() throws LicensingException     {     try     {     Class helperClass = this.requestObject.getClass();     Method method = helperClass.getMethod("edit",null);      String result = (String) method.invoke(object,null);     return result;     }     catch(LicensingException e)     {     throw e;     }     catch(Exception e)     {     String error = "Failed to edit";      if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLTAGSERROR))     {     this.logUtil.put(this.commonStrings.EXCEPTION,this,"editPricing()",e);     }     return error;     }     }      */
    def update() : String = {
        try {
            var helperClass : Class[?] = this.requestObject.getClass().asInstanceOf[Class[?]]
            var method : Method = helperClass.getMethod("update", null)
            var result : String = method.invoke(this.requestObject, null).asInstanceOf[String]
            return result
        } catch {
            case e : Exception => {
                var error : String = "Failed to update"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil_TableTag.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def doStartTag() : Int = {
        try {
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                var request : HttpServletRequest = this.pageContext.getRequest().asInstanceOf[HttpServletRequest]
                var stringBuffer : StringMaker = new StringMaker()
                stringBuffer.append("TableTag Helper: ")
                stringBuffer.append(this.getTagHelperFactoryInterface().getClass().getName())
                stringBuffer.append(" Request URI: ")
                stringBuffer.append(request.getRequestURI())
                this.logUtil_TableTag.putF(stringBuffer.toString(), this, this.tagStrings.DO_START_TAG)
            }
            if (this.getTagRequestHelperFactoryInterface() != null) {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                    this.logUtil_TableTag.putF("TableTag RequestHelper: " + this.getTagRequestHelperFactoryInterface().getClass().getName(), this, this.tagStrings.DO_START_TAG)
                }
            } else {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                    this.logUtil_TableTag.putF("TableTag RequestHelper: null", this, this.tagStrings.DO_START_TAG)
                }
            }
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAG)) {
                this.logUtil_TableTag.putF("TableTag this.getCommand(): " + this.getCommand(), this, tagStrings.DO_START_TAG)
            }
            if (this.isEnabled()) {
                if (this.getCommand() != null) {
                    //the request object work only once for getInputStream()
                    if (((((this.getCommand().compareTo(this.commonStrings.INSERT) == 0) || (this.getCommand().compareTo(SqlStrings.getInstance().INSERT_INTO) == 0)) || (this.getCommand().compareTo(commonStrings.DELETE) == 0)) || (this.getCommand().compareTo(commonStrings.UPDATE) == 0)) || (this.getCommand().compareTo(SqlStrings.getInstance().UPDATE) == 0)) {
                        this.requestObject = this.getTagRequestHelperFactoryInterface().getInstance(this.getPropertiesHashMap(), pageContext)
                    }
                    if ((this.getCommand().compareTo(this.commonStrings.INSERT) == 0) || (this.getCommand().compareTo(SqlStrings.getInstance().INSERT_INTO) == 0)) {
                        this.insert()
                    } else if (this.getCommand().compareTo(commonStrings.DELETE) == 0) {
                        this.delete()
                    } else if ((this.getCommand().compareTo(commonStrings.UPDATE) == 0) || (this.getCommand().compareTo(SqlStrings.getInstance().UPDATE) == 0)) {
                        this.update()
                    }
                    if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.BACKUP) == 0) {
                        var output : String = this.backup()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    } else if (this.getCommand().compareTo(_root_.org.allbinary.globals.GLOBALS2.RESTORE) == 0) {
                        this.getPropertiesHashMap().put("current", this.getCurrent())
                        this.getPropertiesHashMap().put("total", this.getTotal())
                        var output : String = this.restore()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    } else if (this.getCommand().compareTo(commonStrings.DROP) == 0) {
                        var output : String = this.drop()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    } else if (this.getCommand().compareTo(commonStrings.CREATE) == 0) {
                        var output : String = this.create()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                        return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
                    } else if (this.getCommand().compareTo(commonStrings.INSERT) == 0) {
                        var output : String = this.insert()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                    } else if (this.getCommand().compareTo(commonStrings.DELETE) == 0) {
                        var output : String = this.delete()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                    } else if (this.getCommand().compareTo(commonStrings.UPDATE) == 0) {
                        var output : String = this.update()
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().JSPTAGEXTRAOUTPUT)) {
                            this.pageContext.getOut().print(output + "<br />")
                        }
                    }
                }
            }
            return _root_.javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE
        } catch {
            case e : LicensingException => {
                AbResponseHandler.sendJspTagLicensingRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
            case e : Exception => {
                AbResponseHandler.sendJspTagRedirect(this.pageContext, e)
                return _root_.javax.servlet.jsp.tagext.Tag.SKIP_BODY
            }
        }
        throw new IllegalStateException()
    }

}


