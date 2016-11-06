/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;


public interface Attributes {

    public static final int Shown_In_ProfitAndLost = 1;
    public static final int Shown_In_Balnce_Sheet = 2;
    /**
     * Principle of Accounts
     */
    public static final int INDEX_OF_ASSETS = 1;
    public static final int INDEX_OF_LIABILITIES = 2;
    public static final int INDEX_OF_INCOME = 3;
    public static final int INDEX_OF_EXPENSES = 4;
    public static final int INDEX_OF_CAPITAL = 5;
    /**
     * States of Cheque
     */
    public static final int CHEQUE_NOT_BANKED = 0;
    public static final int CHEQUE_BANKED = 1;
    public static final int CHEQUE_RETURNED = 2;
    public static final int CHEQUE_SETTLED = 3;
    /**
     * Types of Cheques.
     */
    public static final int CASH_CHEQUE = 0;
    public static final int CROSS_CHEQUE_GENARAL = 1;
    public static final int CROSS_CHEQUE_SPECIAL = 2;
    public static final int BEARER_CHEQUE = 3;
    public static final int ORDER_CHEQUE = 4;
    public static final int ANTI_DATED_CHEQUE = 5;
    public static final int POST_DATED_CHEQUE = 6;
    public static final int SELF_CHEQUE = 7;
    public static final int PAY_YOUR_SELF_CHEQUE = 8;
    public static final int LOCAL_CHEQUE = 9;
    public static final int BANKERS_CHEQUE = 10;
    public static final int TRAVERLERS_CHEQUE = 11;
    public static final int GIFT_CHEQUE = 11;
    /**
     * Information Posted to tblAccPosting.
     */
    public static final int NOT_POSTED_YET = 0;
    public static final int POSTED_TO_ACCOUNT_POSTING = 1;
    
    
    /**
     * Types of items.
     */
    
    /**
     * this item came from inventory.
     */
    public static final int ITEM_TYPE_STOCK = 0;
    /**
     * This item defined by user, when the time invoice was making.
     */
    public static final int ITEM_TYPE_OPEN_ITEM = 1;
    /**
     * These kind of items are labour chargers.
     */
    public static final int ITEM_TYPE_CHARGERS = 2;
    
    /**
     * This value is the default value for reconciliation process.
     */    
    public static final int RECONCILE_DEFAULT_STATUS = -1;
    
    /**
     * This value will defined Transaction made to its reconciled status.
     * Transaction is reconciled.
     */
    public static int RECONCILE_TRANSATION_RECONCILED = 1;
    
    
}
