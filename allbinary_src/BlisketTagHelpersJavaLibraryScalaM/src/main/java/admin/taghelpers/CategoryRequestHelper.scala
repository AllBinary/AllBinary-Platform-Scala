/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package admin.taghelpers

import _root_.java.util.HashMap
import _root_.java.util.Map
import _root_.java.util.Set
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.category.CategoryComponent
import _root_.org.allbinary.business.category.CategoryData
import _root_.org.allbinary.business.category.CategoryInterface
import _root_.org.allbinary.business.category.store.StoreCategoryFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.data.tree.category.CategoryLoaderFactory
import _root_.org.allbinary.data.tree.category.CategoryLoaderInterface
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomSearchHelper
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoBasic
import _root_.org.allbinary.logic.visual.transform.info.TransformInfoInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CategoryRequestHelper(param_hashMap : HashMap[Object, Object], param_pageContext : PageContext) extends ModifyTable {
    import _root_.admin.taghelpers.CategoryRequestHelper.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    /*     <this.request>        <command></command>        <PARENT>           <CATEGORY_NAME></CATEGORY_NAME>        </PARENT>        <CATEGORY_NAME></CATEGORY_NAME>        //any number of categories for insert or deletion     <this.request>     */
    private var pageContext : PageContext = null

    private var hashMap : HashMap[Object, Object] = null

    private var request : HttpServletRequest = null

    //private StoreFrontInterface storeFrontInterface;
    private var categoryLoaderInterface : CategoryLoaderInterface = null

    private var categoryInterface : CategoryInterface = null

    private var childCategoryInterface : CategoryInterface = null

    private var transformInfoInterface : TransformInfoInterface = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val pageContext : PageContext = param_pageContext
        try {
            this.request = pageContext.getRequest().asInstanceOf[HttpServletRequest]
            this.pageContext = pageContext
            this.hashMap = hashMap
            this.getXmlData()
        } catch {
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "CategoryRequestHelper()", e)
                }
            }
        }
    }

    def getXmlData() : Unit = {
        try {
            var map : Map[Object, Object] = this.request.getParameterMap().asInstanceOf[Map[Object, Object]]
            val categoryData : CategoryData = CategoryData.getInstance()
            val keys : Set[Object] = map.keySet().asInstanceOf[Set[Object]]
            val keyArray : Array[Object] = keys.toArray()
            val size : Int = keyArray.length
            if (size > 0) {
                var xmlRequest : String = keyArray(0).asInstanceOf[String]
                var index : Int = 1

                {
                    scala.util.boundary { (break_N75634 : scala.util.boundary.Label[Unit]) ?=>
                        while ((index < size) && !xmlRequest.startsWith(CategoryRequestHelper.categoryRequest)) {
                            xmlRequest = keyArray(index).asInstanceOf[String]
                            if (xmlRequest.startsWith(CategoryRequestHelper.categoryRequest)) {
                                scala.util.boundary.break()(using break_N75634)
                            }
                        }
                    }
                }
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.logUtil.putF(xmlRequest, this, "getXmlData()")
                }
                var document : Document = DomDocumentHelper.create(xmlRequest)
                var requestNode : Node = DomSearchHelper.getNode(categoryData.REQUEST, document.getChildNodes())
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.logUtil.putF(XmlDocumentHelper.toString(document), this, "getXmlData()")
                }
                this.setCategoryLoader(requestNode)
                var parentCategoryNode : Node = DomSearchHelper.getNode(categoryData.PARENT, requestNode.getChildNodes())
                var categoryNode : Node = DomSearchHelper.getNode(categoryData.NAME, parentCategoryNode.getChildNodes())
                //Create search Category from request
                this.categoryInterface = new StoreCategoryFactory(this.transformInfoInterface).getRootInstanceFromNode(categoryNode).asInstanceOf[CategoryInterface]
                //category factory embeded in the categoryLoader
                this.categoryInterface = this.categoryLoaderInterface.get(this.categoryInterface)
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                    this.categoryInterface.log()
                    this.logUtil.putF("Loaded Parent Category", this, "getXmlData()")
                }
                var childCategoryNode : Node = DomSearchHelper.getNodeNoThrow(categoryData.NAME, requestNode.getChildNodes())
                if (childCategoryNode != null) {
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                        this.logUtil.putF("Loading Child Category", this, "getXmlData()")
                    }
                    this.childCategoryInterface = new StoreCategoryFactory(this.transformInfoInterface).getInstance(childCategoryNode).asInstanceOf[CategoryInterface]
                    //this.categoryLoaderInterface.get(childCategoryNode);
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPER)) {
                        this.childCategoryInterface.log()
                        this.logUtil.putF("Loaded Child Category", this, "getXmlData()")
                    }
                } else {
                    this.childCategoryInterface = this.categoryInterface
                }
            }
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().TAGHELPERERROR)) {
                    this.logUtil.put(commonStrings.EXCEPTION, this, "getXmlData()", e)
                }
            }
        }
    }

    private def setCategoryLoader(requestNode : Node) : Unit = {
        var storeNameNode : Node = DomSearchHelper.getNode(StoreFrontData.getInstance().NAME, requestNode.getChildNodes())
        if (storeNameNode != null) {
            var storeName : String = DomNodeHelper.getTextNodeValue(storeNameNode)
            if (storeName != null) {
                var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(storeName)
                this.transformInfoInterface = (new TransformInfoBasic(storeFrontInterface, this.hashMap, this.pageContext)).asInstanceOf[TransformInfoInterface]
                if (this.transformInfoInterface == null) {
                    throw new Exception("TransformInfo null")
                }
                var storeCategoryFactory : StoreCategoryFactory = new StoreCategoryFactory(this.transformInfoInterface)
                this.categoryLoaderInterface = CategoryLoaderFactory.getInstance(storeCategoryFactory)
            } else {
                throw new Exception("Store Name Error: " + storeName)
            }
        }
    }

    /*    public void getFormData()    {       Map map = this.request.getParameterMap();            BasicArrayList addVector = new BasicArrayListD();       BasicArrayList removeVector = new BasicArrayListD();            Set keys = map.keySet();            while(keyIter.hasNext())       {          String key = (String) keyIter.next();          String[] values = (String[]) map.get(key);               HashMap hashMap = StdUtil.getInstance().createHashMap();          hashMap.put(stringUtil.EMPTY_STRING;,new String(values[0]));          if(key.startsWith(          addVector.add(new Category(hashMap));          //this.logUtil.putF("key: " + key + " Value: " + values[0],this,"getFormData()");       }            this.addCategories = new Categories(addHashMap);       this.removeCategories = new Categories(removeHashMap);    }     */
    override def insert() : String = {
        try {
            //BasicArrayList values = new BasicArrayListD();
            var success : String = "Successfully Added the following to the Category table"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF("inserting", this, "insert()")
            }
            this.categoryLoaderInterface.insert(this.categoryInterface, this.childCategoryInterface)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "insert()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add item to Category"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "insert()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def delete() : String = {
        try {
            var success : String = (("Successfully Removed " + CategoryData.getInstance().NAME) + "=") + this.childCategoryInterface.getPath()
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF("Deleting", this, "delete()")
            }
            this.categoryLoaderInterface.delete(this.categoryInterface, this.childCategoryInterface)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "delete()")
            }
            return success
        } catch {
            case e : Exception => {
                try {
                    var error : String = "Failed to remove category: " + this.childCategoryInterface.getPath()
                    if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                        this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e)
                    }
                    return error
                } catch {
                    case e2 : Exception => {
                        var error : String = "Failed to remove category and show the path of the failed category"
                        if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                            this.logUtil.put(this.commonStrings.EXCEPTION, this, "delete()", e2)
                        }
                        return error
                    }
                }
            }
        }
        throw new IllegalStateException()
    }

    def viewCategory() : String = {
        try {
            var document : Document = new CategoryComponent(this.childCategoryInterface).toXmlDoc()
            var xmlString : String = XmlDocumentHelper.toString(document)
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(xmlString, this, "viewCategory()")
            }
            return xmlString
        } catch {
            case e : Exception => {
                var error : String = "Failed to get Category"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "viewCategory()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    def viewCategories() : String = {
        try {
            var success : String = StringUtil.getInstance().EMPTY_STRING
            //Categories categories;
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "viewCategories()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to view Categories table"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "viewCategories()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

    override def update() : String = {
        try {
            //CategoryEntityFactory.getInstance().update(values);
            var success : String = "New Item Successfully added"
            if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGS)) {
                this.logUtil.putF(success, this, "update()")
            }
            return success
        } catch {
            case e : Exception => {
                var error : String = "Failed to add Item"
                if (_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypes.LOGGING.contains(_root_.org.allbinary.logic.communication.log.config.`type`.LogConfigTypeFactory.getInstance().SQLTAGSERROR)) {
                    this.logUtil.put(this.commonStrings.EXCEPTION, this, "update()", e)
                }
                return error
            }
        }
        throw new IllegalStateException()
    }

}

object CategoryRequestHelper {
    private val categoryRequest : String = new StringMaker().append("<").append(CategoryData.getInstance().REQUEST).append(">").toString()

}


