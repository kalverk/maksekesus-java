## Integration client for maksekeskus.ee

### Description of the flow
* Customer is in the cart and would like to pay
* Shop requests configured payment information, see PaymentMethodsService
* Customer selects preferred payment version and shop creates a transaction, see PaymentTransactionService
* Shop redirects user to selected payment gateway
* Customer 
    * makes the payment
        * shop gets notified to return_url, see TransactionUrls
        * shop gets notified asynchronously to notification_url, see TransactionUrls
    * cancels the payment
        * shop gets notified to cancel_url, see TransactionUrls
        
        
**NB!** Current implementation works only with bank links