/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.communication.sql.AbSqlData
import _root_.org.allbinary.logic.control.validate.Validation
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class BasicItemValidation(param_itemInterface : ItemInterface) extends Validation {

    val logUtil : LogUtil = LogUtil.getInstance()

    private val MAXWEIGHT : Int = 14

    private val MAXPRICE : Int = 14

    private var itemInterface : ItemInterface = null

    //Constructor
    {
        val itemInterface : ItemInterface = param_itemInterface
        this.itemInterface = itemInterface
    }

    override def isValid() : _root_.java.lang.Boolean = {
        try {
            if (((this.itemInterface.getId() == null) || (this.itemInterface.getId().length() < 1)) || (this.itemInterface.getId().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            if ((this.itemInterface.getId() != null) && !stringValidationUtil.isNumber(this.itemInterface.getId())) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getNumber() == null) || (this.itemInterface.getNumber().length() < 1)) || (this.itemInterface.getNumber().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if ((this.itemInterface.getNumber() != null) && !stringValidationUtil.isNumber(this.itemInterface.getNumber())) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getInBaskets() == null) || (this.itemInterface.getInBaskets().length() < 1)) || (this.itemInterface.getInBaskets().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if ((this.itemInterface.getInBaskets() != null) && !stringValidationUtil.isNumber(this.itemInterface.getInBaskets())) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getWeight() == null) || (this.itemInterface.getWeight().length() < 1)) || (this.itemInterface.getWeight().length() > this.MAXWEIGHT)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if ((this.itemInterface.getWeight() != null) && !stringValidationUtil.isNumber(this.itemInterface.getWeight())) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getEnabled() == null) || (this.itemInterface.getEnabled().length() < 1)) || (this.itemInterface.getEnabled().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getNewOrUsed() == null) || (this.itemInterface.getNewOrUsed().length() < 1)) || (this.itemInterface.getNewOrUsed().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getSummary() == null) || (this.itemInterface.getSummary().length() < 1)) || (this.itemInterface.getSummary().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            /*          if(this.itemInterface.distributor==null || this.itemInterface.distributor.length()<1 || this.itemInterface.distributor.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }                     if(this.itemInterface.idUsedByDistributor==null || this.itemInterface.idUsedByDistributor.length()<1 || this.itemInterface.idUsedByDistributor.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }                     if(this.itemInterface.producedBy==null || this.itemInterface.producedBy.length()<1 || this.itemInterface.producedBy.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }                     if(this.itemInterface.productionDate==null || this.itemInterface.productionDate.length()<1 || this.itemInterface.productionDate.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }                     if(this.itemInterface.startProductionDate==null || this.itemInterface.startProductionDate.length()<1 || this.itemInterface.startProductionDate.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }           */
            if (((this.itemInterface.getDescription() == null) || (this.itemInterface.getDescription().length() < 1)) || (this.itemInterface.getDescription().length() > AbSqlData.MAXBLOB)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getKeywords() == null) || (this.itemInterface.getKeywords().length() < 1)) || (this.itemInterface.getKeywords().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getCategory() == null) || (this.itemInterface.getCategory().length() < 1)) || (this.itemInterface.getCategory().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getType() == null) || (this.itemInterface.getType().length() < 1)) || (this.itemInterface.getType().length() > AbSqlData.MAXSTRING)) {
                return _root_.java.lang.Boolean.FALSE
            }
            /*          if(this.itemInterface.smallImage==null || this.itemInterface.smallImage.length()<1 || this.itemInterface.smallImage.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }                     if(this.itemInterface.mediumImage==null || this.itemInterface.mediumImage.length()<1 || this.itemInterface.mediumImage.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }                     if(this.itemInterface.largeImage==null || this.itemInterface.largeImage.length()<1 || this.itemInterface.largeImage.length()>AbSqlData.MAXSTRING)          {             return Boolean.FALSE;          }           */
            if ((this.itemInterface.getPrice() == null) || !this.itemInterface.getPrice().isValid()) {
                return _root_.java.lang.Boolean.FALSE
            }
            /*          if(this.itemInterface.comment==null || this.itemInterface.comment.length()<1 || this.itemInterface.comment.length()>AbSqlData.MAXBLOB )          {             return Boolean.FALSE;          }  */
            if (((this.itemInterface.getCustoms() == null) || (this.itemInterface.getCustoms().length() < 1)) || (this.itemInterface.getCustoms().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getDownloads() == null) || (this.itemInterface.getDownloads().length() < 1)) || (this.itemInterface.getDownloads().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getGroups() == null) || (this.itemInterface.getGroups().length() < 1)) || (this.itemInterface.getGroups().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getOptions() == null) || (this.itemInterface.getOptions().length() < 1)) || (this.itemInterface.getOptions().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getPermissions() == null) || (this.itemInterface.getPermissions().length() < 1)) || (this.itemInterface.getPermissions().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            if (((this.itemInterface.getSpecials() == null) || (this.itemInterface.getSpecials().length() < 1)) || (this.itemInterface.getSpecials().length() > AbSqlData.MAXNUM)) {
                return _root_.java.lang.Boolean.FALSE
            }
            return _root_.java.lang.Boolean.TRUE
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

    override def validationInfo() : String = {
        try {
            var stringBuffer : StringMaker = new StringMaker()
            if (((this.itemInterface.getId() == null) || (this.itemInterface.getId().length() < 1)) || (this.itemInterface.getId().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Id is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            var stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
            if ((this.itemInterface.getId() != null) && !stringValidationUtil.isNumber(this.itemInterface.getId())) {
                stringBuffer.append("Id is invalid. Must be > 0.<br />")
            }
            if (((this.itemInterface.getNumber() == null) || (this.itemInterface.getNumber().length() < 1)) || (this.itemInterface.getNumber().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Number of items is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if ((this.itemInterface.getNumber() != null) && !stringValidationUtil.isNumber(this.itemInterface.getNumber())) {
                stringBuffer.append("Number of items value is not a valid number.<br />")
            }
            if (((this.itemInterface.getInBaskets() == null) || (this.itemInterface.getInBaskets().length() < 1)) || (this.itemInterface.getInBaskets().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Number in baskets is invalid. Must be < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if ((this.itemInterface.getInBaskets() != null) && !stringValidationUtil.isNumber(this.itemInterface.getInBaskets())) {
                stringBuffer.append("In Baskets value is not a valid number.<br />")
            }
            if (((this.itemInterface.getWeight() == null) || (this.itemInterface.getWeight().length() < 1)) || (this.itemInterface.getWeight().length() > this.MAXWEIGHT)) {
                stringBuffer.append(("Weight value is invalid. Must be < " + this.MAXWEIGHT) + " and > 0 digits.<br />")
            }
            if ((this.itemInterface.getWeight() != null) && !stringValidationUtil.isNumber(this.itemInterface.getWeight())) {
                stringBuffer.append("Weight value is not a valid number.<br />")
            }
            if (((this.itemInterface.getEnabled() == null) || (this.itemInterface.getEnabled().length() < 1)) || (this.itemInterface.getEnabled().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append(("For Sale value is invalid. Must be < " + AbSqlData.MAXSTRING) + " and > 0 characters long.<br />")
            }
            if (((this.itemInterface.getNewOrUsed() == null) || (this.itemInterface.getNewOrUsed().length() < 1)) || (this.itemInterface.getNewOrUsed().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append(("New Or Used value is invalid. Must be < " + AbSqlData.MAXSTRING) + " and > 0 characters long.<br />")
            }
            if (((this.itemInterface.getSummary() == null) || (this.itemInterface.getSummary().length() < 1)) || (this.itemInterface.getSummary().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append(("Summary value is invalid. Must be < " + AbSqlData.MAXSTRING) + " and > 0 characters long.<br />")
            }
            /*          if(this.itemInterface.distributor==null || this.itemInterface.distributor.length()<1 || this.itemInterface.distributor.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("Distributor value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }            if(this.itemInterface.idUsedByDistributor==null || this.itemInterface.idUsedByDistributor.length()<1 || this.itemInterface.idUsedByDistributor.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("Id Used By Distributor value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }            if(this.itemInterface.producedBy==null || this.itemInterface.producedBy.length()<1 || this.itemInterface.producedBy.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("Produced By value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }            if(this.itemInterface.productionDate==null || this.itemInterface.productionDate.length()<1 || this.itemInterface.productionDate.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("Production Date value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }            if(this.itemInterface.startProductionDate==null || this.itemInterface.startProductionDate.length()<1 || this.itemInterface.startProductionDate.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("Start Production Date value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }  */
            if (((this.itemInterface.getDescription() == null) || (this.itemInterface.getDescription().length() < 1)) || (this.itemInterface.getDescription().length() > AbSqlData.MAXBLOB)) {
                stringBuffer.append(("Description value is invalid. Must be < " + AbSqlData.MAXBLOB) + " and > 0 characters long.<br />")
            }
            if (((this.itemInterface.getKeywords() == null) || (this.itemInterface.getKeywords().length() < 1)) || (this.itemInterface.getKeywords().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append(("Keywords value is invalid. Must be < " + AbSqlData.MAXSTRING) + " and > 0 characters long.<br />")
            }
            /*          AbFile categoryFile = FileFactory.getInstance().getInstance(this.itemInterface.getCategory());          if(!categoryFile.isDirectory())          {             stringBuffer.append("Category " + this.itemInterface.getCategory() + " does not exist.<br />");          }          */
            if (((this.itemInterface.getCategory() == null) || (this.itemInterface.getCategory().length() < 1)) || (this.itemInterface.getCategory().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append(("Category value is invalid. Must be < " + AbSqlData.MAXSTRING) + " and > 0 characters long.<br />")
            }
            if (((this.itemInterface.getType() == null) || (this.itemInterface.getType().length() < 1)) || (this.itemInterface.getType().length() > AbSqlData.MAXSTRING)) {
                stringBuffer.append(("Type value is invalid. Must be < " + AbSqlData.MAXSTRING) + " and > 0 characters long.<br />")
            }
            /*          if(this.itemInterface.smallImage==null || this.itemInterface.smallImage.length()<1 || this.itemInterface.smallImage.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("New Or Used value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }                     if(this.itemInterface.mediumImage==null || this.itemInterface.mediumImage.length()<1 || this.itemInterface.mediumImage.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("New Or Used value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }                     if(this.itemInterface.largeImage==null || this.itemInterface.largeImage.length()<1 || this.itemInterface.largeImage.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("New Or Used value is invalid. Must be < " + AbSqlData.MAXSTRING + " and > 0 characters long.<br>");          }           */
            if ((this.itemInterface.getPrice() == null) || !this.itemInterface.getPrice().isValid()) {
                stringBuffer.append(("Price value is invalid. Must be < " + this.MAXPRICE) + " and > 0 in length.<br />")
            }
            /*          if(this.itemInterface.comment==null || this.itemInterface.comment.length()<1 || this.itemInterface.comment.length()>AbSqlData.MAXSTRING)          {             stringBuffer.append("ID To Big.<br>");          }           */
            if (((this.itemInterface.getCustoms() == null) || (this.itemInterface.getCustoms().length() < 1)) || (this.itemInterface.getCustoms().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Custom items value is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if (((this.itemInterface.getDownloads() == null) || (this.itemInterface.getDownloads().length() < 1)) || (this.itemInterface.getDownloads().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Downloadable item value is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if (((this.itemInterface.getGroups() == null) || (this.itemInterface.getGroups().length() < 1)) || (this.itemInterface.getGroups().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Group item value is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if (((this.itemInterface.getOptions() == null) || (this.itemInterface.getOptions().length() < 1)) || (this.itemInterface.getOptions().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Option item value is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if (((this.itemInterface.getPermissions() == null) || (this.itemInterface.getPermissions().length() < 1)) || (this.itemInterface.getPermissions().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Permission item value is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
            }
            if (((this.itemInterface.getSpecials() == null) || (this.itemInterface.getSpecials().length() < 1)) || (this.itemInterface.getSpecials().length() > AbSqlData.MAXNUM)) {
                stringBuffer.append(("Special item value is invalid. Must be number < " + AbSqlData.MAXNUM) + " and > 0 digits.<br />")
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

    override def toValidationInfoDoc() : Document = {
        return null
    }

    override def toValidationInfoNode(document : Document) : Node = {
        return null
    }

}


