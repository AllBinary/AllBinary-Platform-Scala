/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.quoterequest

import _root_.java.util.Calendar
import _root_.java.util.HashMap
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.servlet.http.HttpServletRequest
import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.business.quoterequest.QuoteRequestData
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.data.generator.QuoteRequestIdGenerator
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.string.CommonStrings

class QuoteRequest private () {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var id : String = null

    private var userName : String = null

    private var projectInfo : String = null

    private var userComments : String = null

    private var budget : String = null

    private var timeFrame : String = null

    private var comments : String = null

    def this(userName : String, request : HttpServletRequest) = {
        this()
        var quoteRequestData : QuoteRequestData = QuoteRequestData.getInstance()
        this.id = new QuoteRequestIdGenerator().getNext()
        //this.setUserName((String) request.getParameter(UserData.USERNAME));
        this.setUserName(userName)
        this.setProjectInfo(request.getParameter(quoteRequestData.PROJECT_INFO).asInstanceOf[String])
        this.setUserComments(request.getParameter(quoteRequestData.CUSTOMER_COMMENTS).asInstanceOf[String])
        this.setBudget(request.getParameter(quoteRequestData.BUDGET).asInstanceOf[String])
        this.setTimeFrame(request.getParameter(quoteRequestData.TIMEFRAME).asInstanceOf[String])
        this.setComments(request.getParameter(quoteRequestData.COMMENTS).asInstanceOf[String])
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
            this.logUtil.putF("Created with: " + this.toHashMap(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def this(hashMap : HashMap[Object, Object]) = {
        this()
        var quoteRequestData : QuoteRequestData = QuoteRequestData.getInstance()
        this.id = hashMap.get(quoteRequestData.ID).asInstanceOf[String]
        this.setUserName(hashMap.get(UserData.USERNAME).asInstanceOf[String])
        this.setProjectInfo(hashMap.get(quoteRequestData.PROJECT_INFO).asInstanceOf[String])
        this.setUserComments(hashMap.get(quoteRequestData.CUSTOMER_COMMENTS).asInstanceOf[String])
        this.setBudget(hashMap.get(quoteRequestData.BUDGET).asInstanceOf[String])
        this.setTimeFrame(hashMap.get(quoteRequestData.TIMEFRAME).asInstanceOf[String])
        this.setComments(hashMap.get(quoteRequestData.COMMENTS).asInstanceOf[String])
        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
            this.logUtil.putF("Created with: " + this.toHashMap(), this, this.commonStrings.CONSTRUCTOR)
        }
    }

    def isValid() : _root_.java.lang.Boolean = {
        try {
            var valid : _root_.java.lang.Boolean = _root_.java.lang.Boolean.TRUE
            if (((this.userName == null) || (this.userName.length() < 4)) || (this.userName.length() > 250)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (((this.projectInfo == null) || (this.projectInfo.length() < 0)) || (this.projectInfo.length() > AbSqlData.MAXBLOB)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (((this.userComments == null) || (this.userComments.length() < 0)) || (this.userComments.length() > AbSqlData.MAXBLOB)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (((this.budget == null) || (this.budget.length() < 0)) || (this.budget.length() > AbSqlData.MAXBLOB)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (((this.timeFrame == null) || (this.timeFrame.length() < 0)) || (this.timeFrame.length() > AbSqlData.MAXBLOB)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            if (((this.comments == null) || (this.comments.length() < 0)) || (this.comments.length() > AbSqlData.MAXBLOB)) {
                valid = _root_.java.lang.Boolean.FALSE
            }
            return valid
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put("Failed to validate form", this, this.commonStrings.IS_VALID, e)
                }
                return _root_.java.lang.Boolean.FALSE
            }
        }
        throw new IllegalStateException()
    }

    def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (((this.userName == null) || (this.userName.length() < 4)) || (this.userName.length() > 250)) {
                stringBuffer.append("Please enter a User Name with more than 4 characters.<br>")
            }
            if (((this.projectInfo == null) || (this.projectInfo.length() < 0)) || (this.projectInfo.length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append(("Please enter Project Info with less than " + AbSqlData.MAXBLOB) + " characters.<br>")
            }
            if (((this.userComments == null) || (this.userComments.length() < 0)) || (this.userComments.length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append(("Please enter User Comments with less than " + AbSqlData.MAXBLOB) + " characters.<br>")
            }
            if (((this.budget == null) || (this.budget.length() < 0)) || (this.budget.length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append(("Please enter Budget with less than " + AbSqlData.MAXBLOB) + " characters.<br>")
            }
            if (((this.timeFrame == null) || (this.timeFrame.length() < 0)) || (this.timeFrame.length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append(("Please enter time frame with less than " + AbSqlData.MAXBLOB) + " characters.<br>")
            }
            if (((this.comments == null) || (this.comments.length() < 0)) || (this.comments.length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append(("Please enter comments with less than " + AbSqlData.MAXBLOB) + " characters.<br>")
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

    def toVector() : BasicArrayList = {
        var values : BasicArrayList = new BasicArrayListD()
        //unique id is added in entity      
        values.add(this.id)
        values.add(this.userName)
        values.add(this.projectInfo)
        values.add(this.userComments)
        values.add(this.budget)
        values.add(this.timeFrame)
        values.add(this.comments)
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.add(time)
        values.add(time)
        return values
    }

    def toHashMap() : HashMap[Object, Object] = {
        var quoteRequestData : QuoteRequestData = QuoteRequestData.getInstance()
        var values : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        values.put(UserData.USERNAME, userName)
        values.put(quoteRequestData.PROJECT_INFO, this.projectInfo)
        values.put(quoteRequestData.CUSTOMER_COMMENTS, this.userComments)
        values.put(quoteRequestData.BUDGET, this.budget)
        values.put(quoteRequestData.TIMEFRAME, this.timeFrame)
        values.put(quoteRequestData.COMMENTS, this.comments)
        var calendar : Calendar = Calendar.getInstance()
        var time : String = new String(new _root_.java.lang.Long(calendar.getTimeInMillis()).toString())
        values.put(EntryData.getInstance().LASTMODIFIED, time)
        return values
    }

    def setUserName(value : String) : Unit = {
        this.userName = value
    }

    def setProjectInfo(value : String) : Unit = {
        this.projectInfo = value
    }

    def setUserComments(value : String) : Unit = {
        this.userComments = value
    }

    def setBudget(value : String) : Unit = {
        this.budget = value
    }

    def setTimeFrame(value : String) : Unit = {
        this.timeFrame = value
    }

    def setComments(value : String) : Unit = {
        this.comments = value
        val stringUtil : StringUtil = StringUtil.getInstance()
        if (this.comments == null) {
            this.comments = stringUtil.EMPTY_STRING
        }
    }

    def getUserName() : String = {
        return this.userName
    }

    def getProjectInfo() : String = {
        return this.projectInfo
    }

    def getUserComments() : String = {
        return this.userComments
    }

    def getBudget() : String = {
        return this.budget
    }

    def getTimeFrame() : String = {
        return this.timeFrame
    }

    def getComments() : String = {
        return this.comments
    }

}


