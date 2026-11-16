/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.communication.http.request.session

import _root_.java.util.HashMap
import _root_.javax.servlet.http.HttpServletRequest
import _root_.javax.servlet.http.HttpSession
import _root_.javax.servlet.jsp.PageContext
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontData
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontFactory
import _root_.org.allbinary.business.context.modules.storefront.StoreFrontInterface
import _root_.org.allbinary.business.user.UserData
import _root_.org.allbinary.business.user.commerce.inventory.basket.Basket
import _root_.org.allbinary.business.user.commerce.inventory.order.Order
import _root_.org.allbinary.business.user.commerce.inventory.order.OrderInterface
import _root_.org.allbinary.business.user.commerce.money.payment.gateway.PaymentGatewayData
import _root_.org.allbinary.business.user.role.UserRole
import _root_.org.allbinary.business.user.role.UserRoleB
import _root_.org.allbinary.business.user.role.UserRoleData
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringValidationUtil

class WeblisketSession(param_hashMap : HashMap[Object, Object], param_httpServletRequest : HttpServletRequest) extends WeblisketSessionInterface {

    private var session : HttpSession = null

    //Constructor
    {
        val hashMap : HashMap[Object, Object] = param_hashMap
        val httpServletRequest : HttpServletRequest = param_httpServletRequest
        var propertiesHashMap : HashMap[Object, Object] = hashMap
        var request : HttpServletRequest = httpServletRequest
        this.session = request.getSession(true)
        //TWB replace when storeName is no longer an attribute for store views and session only
        if (this.getStoreName() == null) {
            this.setStoreName(propertiesHashMap.get(StoreFrontData.getInstance().NAME).asInstanceOf[String])
        }
    }

    /*    public WeblisketSession(PageContext pageContext)    {       this.pageContext = pageContext;            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();       this.session = request.getSession(true);    }     */
    def this(hashMap : HashMap[Object, Object], pageContext : PageContext) = {
        this(hashMap, pageContext.getRequest().asInstanceOf[HttpServletRequest])
    }

    /*       if(this.session != null)       {          this.paymentMethod = (String) this.session.getAttribute(PaymentGatewayData.NAME.toString());       }        */
    def getId() : String = {
        return this.session.getId()
    }

    def setPassword(password : String) : Unit = {
        this.session.setAttribute(UserData.PASSWORD, password)
    }

    def setUserName(userName : String) : Unit = {
        this.session.setAttribute(UserData.USERNAME, userName)
    }

    def setPaymentMethod(value : String) : Unit = {
        this.session.setAttribute(PaymentGatewayData.NAME.toString(), value)
    }

    def setAuthenticated() : Unit = {
        this.session.setAttribute(WeblisketSessionData.AUTHENTICATED, BooleanFactory.getInstance().TRUE_STRING)
    }

    def setRole(aRole : UserRole) : Unit = {
        this.session.setAttribute(UserRoleData.NAME.toString(), aRole)
    }

    def setAttempts(value : Integer) : Unit = {
        this.session.setAttribute(WeblisketSessionData.ATTEMPTS, value)
    }

    def setTimeout(value : String) : Unit = {
        this.session.setAttribute(WeblisketSessionData.TIMEOUT, value)
    }

    def setStoreName(value : String) : Unit = {
        this.session.setAttribute(StoreFrontData.getInstance().NAME, value)
    }

    def getWebAppPath() : String = {
        return this.session.getAttribute(_root_.org.allbinary.globals.GLOBALS2.WEBAPPPATH).asInstanceOf[String]
    }

    def getUserName() : String = {
        return this.session.getAttribute(UserData.USERNAME).asInstanceOf[String]
    }

    def getPassword() : String = {
        return this.session.getAttribute(UserData.PASSWORD).asInstanceOf[String]
    }

    def getPaymentMethod() : String = {
        return this.session.getAttribute(PaymentGatewayData.NAME.toString()).asInstanceOf[String]
    }

    def getAuthentication() : String = {
        return this.session.getAttribute(WeblisketSessionData.AUTHENTICATED).asInstanceOf[String]
    }

    def getAttempts() : Integer = {
        return this.session.getAttribute(WeblisketSessionData.ATTEMPTS).asInstanceOf[Integer]
    }

    def getTimeout() : String = {
        return this.session.getAttribute(WeblisketSessionData.TIMEOUT).asInstanceOf[String]
    }

    def getStoreName() : String = {
        return this.session.getAttribute(StoreFrontData.getInstance().NAME).asInstanceOf[String]
    }

    def getRole() : UserRole = {
        //This could be a serialized object
        var userRole : UserRole = this.session.getAttribute(UserRoleData.NAME.toString()).asInstanceOf[UserRole]
        if (userRole != null) {
            return UserRoleB.getRole(userRole.getBasicUserRole().getRole())
        } else {
            return null
        }
        throw new IllegalStateException()
    }

    def getOrder() : OrderInterface = {
        var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getStoreName())
        var basketName : String = storeFrontInterface.getBasketName()
        if (!StringValidationUtil.getInstance().isEmpty(basketName)) {
            var orderInterface : OrderInterface = this.session.getAttribute(basketName).asInstanceOf[OrderInterface]
            if (orderInterface == null) {
                orderInterface = (new Order(new Basket())).asInstanceOf[OrderInterface]
            }
            //Need to serialize new object since the previous object may not be the same
            this.session.setAttribute(basketName, orderInterface)
            return orderInterface
        } else {
            throw new Exception("Basket Name Not Found")
        }
        throw new IllegalStateException()
    }

    /*    public BasketInterface getBasket() throws Exception    {       final CommonStrings commonStrings = CommonStrings.getInstance();       try       {          OrderInterface orderInterface = this.getOrder();                    BasketInterface basketInterface = orderInterface.getBasket();                    if(basketInterface == null)          {             basketInterface = (BasketInterface) new Basket();              //BasketFactory.getInstance(               // this.storeFrontInterface,                //this.propertiesHashMap,                //this.pageContext);              //orderInterface.setBasket((BasketInterface) basketInterface);             //this.updateOrder();             //Need to serialize new object since the previous object may not be the same             this.session.setAttribute(basketName, orderInterface);          }          return basketInterface;       }       catch(Exception e)       {          if(org.allbinary.logic.communication.log.config.type.LogConfigTypes.LOGGING.contains(org.allbinary.logic.communication.log.config.type.LogConfigTypeFactory.getInstance().SQLTAGSERROR))          {             this.logUtil.put(commonStrings.EXCEPTION, this, "getBasket()", e);          }          throw e;       }    }    */
    def setAuthenticated(value : Boolean) : Unit = {
        this.session.setAttribute(WeblisketSessionData.AUTHENTICATED, BooleanFactory.getInstance().FALSE_STRING)
    }

    def clear() : Unit = {
        this.session.removeAttribute(WeblisketSessionData.AUTHENTICATED)
        this.session.removeAttribute(WeblisketSessionData.TIMEOUT)
        this.session.removeAttribute(UserRoleData.NAME.toString())
        this.session.removeAttribute(UserData.USERNAME)
    }

    /*    public void invalidate()    {       this.clear();       this.session.invalidate();    }    */
    def getCreationTime() : Long = {
        return this.session.getCreationTime()
    }

    def getLastAccessedTime() : Long = {
        return this.session.getLastAccessedTime()
    }

    def removeBasket() : Unit = {
        var storeFrontInterface : StoreFrontInterface = StoreFrontFactory.getInstance(this.getStoreName())
        var basketName : String = storeFrontInterface.getBasketName()
        if (!StringValidationUtil.getInstance().isEmpty(basketName)) {
            this.session.removeAttribute(basketName)
        }
    }

}


