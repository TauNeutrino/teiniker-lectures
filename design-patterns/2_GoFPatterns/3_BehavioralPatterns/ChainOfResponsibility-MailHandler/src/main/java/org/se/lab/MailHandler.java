package org.se.lab;

/*
 * This Handler class defines an API for handling requests and
 * implements the successor link.
 */
public class MailHandler
{
    /*
     * Property: successor
     */
    private MailHandler successor;
    public MailHandler getSuccessor()
    {
        return successor;
    }
    public void setSuccessor(MailHandler successor)
    {
        this.successor = successor;
    }
    
    
    /*
     * Handler Operation (default implementation)
     */
    public void handleRequest(Mail mail)
    {
        if(getSuccessor() != null)
        {
            getSuccessor().handleRequest(mail);
        }
    }
}
