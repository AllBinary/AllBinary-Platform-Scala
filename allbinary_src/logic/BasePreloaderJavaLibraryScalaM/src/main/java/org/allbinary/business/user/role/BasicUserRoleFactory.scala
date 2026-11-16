/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.role


class BasicUserRoleFactory {
    import _root_.org.allbinary.business.user.role.BasicUserRoleFactory.{*}

    //3600000 = 60 min
    private val INACTIVITYTIMEOUT : Long = 360000000

    private val CUSTOMERTIMEOUT : Long = 360000000

    //Long.MAX_VALUE
    private val CUSTOMERMAXSESSIONTIME : Long = 360000000

    private val MAXSESSIONTIME : Long = 360000000

    val INSTALLER : BasicUserRole = new BasicUserRole("Installer", 16, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    //new AdministratorUserFactory()
    val ADMINISTRATOR : BasicUserRole = new BasicUserRole("Administrator", 0, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    //Users
    val CUSTOMER : BasicUserRole = new BasicUserRole("CustomerUser", "Customer User", 1, this.CUSTOMERTIMEOUT, this.CUSTOMERMAXSESSIONTIME)

    val SUBSCRIBERCUSTOMER : BasicUserRole = new BasicUserRole("SubscriberUser", "Subscriber User", 2, this.CUSTOMERTIMEOUT, this.CUSTOMERMAXSESSIONTIME)

    val WHOLESALECUSTOMER : BasicUserRole = new BasicUserRole("WholesaleUser", "Wholesale User", 3, this.CUSTOMERTIMEOUT, this.CUSTOMERMAXSESSIONTIME)

    //Store Admin
    val STOREMANAGER : BasicUserRole = new BasicUserRole("StoreManager", "Store Manager", 4, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    //Managers
    val PRODUCTMANAGER : BasicUserRole = new BasicUserRole("ProductManager", "Product Manager", 5, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val CUSTOMERMANAGER : BasicUserRole = new BasicUserRole("UserManager", "User Manager", 6, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val PAYMENTMANAGER : BasicUserRole = new BasicUserRole("PaymentManager", "Payment Manager", 7, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val ORDERMANAGER : BasicUserRole = new BasicUserRole("OrderManager", "Order Manager", 8, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val WEBMANAGER : BasicUserRole = new BasicUserRole("WebManager", "Web Manager", 9, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    //Order Manager Assistants
    val REVIEWER : BasicUserRole = new BasicUserRole("Reviewer", 10, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val SHIPPING : BasicUserRole = new BasicUserRole("Shipping", 11, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val ADJUSTER : BasicUserRole = new BasicUserRole("Adjuster", 12, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    //Web Manager Assistants
    val WORKFLOWEDITOR : BasicUserRole = new BasicUserRole("WorkFlowEditor", "WorkFlow Editor", 13, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    val WIZARD : BasicUserRole = new BasicUserRole("WizardUser", "Wizard User", 14, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

    //new BasicUserRole ("Wizard Editor User", MAXSESSIONTIME, INACTIVITYTIMEOUT);
    val VIEWEDITOR : BasicUserRole = new BasicUserRole("ViewEditor", "View Editor", 15, this.MAXSESSIONTIME, this.INACTIVITYTIMEOUT)

}

object BasicUserRoleFactory {
    private val instance : BasicUserRoleFactory = new BasicUserRoleFactory()

    def getInstance() : BasicUserRoleFactory = {
        return BasicUserRoleFactory.instance
    }

}


