/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AdminRoleFactory private() {
    import _root_.org.allbinary.business.user.role.AdminRoleFactory.{*}

    private val adminRoles : BasicArrayList = new BasicArrayListD()

    private val storeAdminRoles : BasicArrayList = new BasicArrayListD()

    private val storeManagementRoles : BasicArrayList = new BasicArrayListD()

    private val productManagementRoles : BasicArrayList = new BasicArrayListD()

    private val reviewManagementRoles : BasicArrayList = new BasicArrayListD()

    private val customerManagementRoles : BasicArrayList = new BasicArrayListD()

    private val workflowManagementRoles : BasicArrayList = new BasicArrayListD()

    private val orderManagementRoles : BasicArrayList = new BasicArrayListD()

    private val adjusterManagementRoles : BasicArrayList = new BasicArrayListD()

    private val shippingManagementRoles : BasicArrayList = new BasicArrayListD()

    private val webManagementRoles : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        val basicUserRoleFactory : BasicUserRoleFactory = BasicUserRoleFactory.getInstance()
        this.adminRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.storeAdminRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.storeAdminRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.storeManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.storeManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.storeManagementRoles.add(basicUserRoleFactory.CUSTOMERMANAGER)
        this.storeManagementRoles.add(basicUserRoleFactory.ADJUSTER)
        this.storeManagementRoles.add(basicUserRoleFactory.PRODUCTMANAGER)
        this.storeManagementRoles.add(basicUserRoleFactory.REVIEWER)
        this.storeManagementRoles.add(basicUserRoleFactory.SHIPPING)
        //storeManagementRoles.add(basicUserRoleFactory.ORDERMANAGER);
        this.productManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.productManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.productManagementRoles.add(basicUserRoleFactory.PRODUCTMANAGER)
        this.reviewManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.reviewManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.reviewManagementRoles.add(basicUserRoleFactory.REVIEWER)
        this.customerManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.customerManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.customerManagementRoles.add(basicUserRoleFactory.CUSTOMERMANAGER)
        this.workflowManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.workflowManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.workflowManagementRoles.add(basicUserRoleFactory.WORKFLOWEDITOR)
        this.orderManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.orderManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        //orderManagementRoles.add(basicUserRoleFactory.ORDERMANAGER);
        this.adjusterManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.adjusterManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.adjusterManagementRoles.add(basicUserRoleFactory.ADJUSTER)
        this.shippingManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.shippingManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.shippingManagementRoles.add(basicUserRoleFactory.SHIPPING)
        this.webManagementRoles.add(basicUserRoleFactory.ADMINISTRATOR)
        this.webManagementRoles.add(basicUserRoleFactory.STOREMANAGER)
        this.webManagementRoles.add(basicUserRoleFactory.WEBMANAGER)
        this.webManagementRoles.add(basicUserRoleFactory.WORKFLOWEDITOR)
        //webManagementRoles.add(basicUserRoleFactory.WIZARDEDITOR);
        this.webManagementRoles.add(basicUserRoleFactory.VIEWEDITOR)
    }

    /**      * @return the productManagementRoles      */
    def getProductManagementRoles() : BasicArrayList = {
        return this.productManagementRoles
    }

    /**      * @return the adminRoles      */
    def getAdminRoles() : BasicArrayList = {
        return this.adminRoles
    }

    /**      * @return the storeAdminRoles      */
    def getStoreAdminRoles() : BasicArrayList = {
        return this.storeAdminRoles
    }

    /**      * @return the storeManagementRoles      */
    def getStoreManagementRoles() : BasicArrayList = {
        return this.storeManagementRoles
    }

    /**      * @return the reviewManagementRoles      */
    def getReviewManagementRoles() : BasicArrayList = {
        return this.reviewManagementRoles
    }

    /**      * @return the customerManagementRoles      */
    def getCustomerManagementRoles() : BasicArrayList = {
        return this.customerManagementRoles
    }

    /**      * @return the workflowManagementRoles      */
    def getWorkflowManagementRoles() : BasicArrayList = {
        return this.workflowManagementRoles
    }

    /**      * @return the webManagementRoles      */
    def getWebManagementRoles() : BasicArrayList = {
        return this.webManagementRoles
    }

    /**      * @return the shippingManagementRoles      */
    def getShippingManagementRoles() : BasicArrayList = {
        return this.shippingManagementRoles
    }

    /**      * @return the adjusterManagementRoles      */
    def getAdjusterManagementRoles() : BasicArrayList = {
        return this.adjusterManagementRoles
    }

    /**      * @return the orderManagementRoles      */
    def getOrderManagementRoles() : BasicArrayList = {
        return this.orderManagementRoles
    }

}

object AdminRoleFactory {
    private val instance : AdminRoleFactory = new AdminRoleFactory()

    def getInstance() : AdminRoleFactory = {
        return AdminRoleFactory.instance
    }

}


