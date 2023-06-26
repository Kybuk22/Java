/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

public class MailTester {

  public static void main(String[] args) {
    MailCreatorChain chain = new MailCreatorChain();

    chain.addMailParts(
        new HeaderMailCreator("header"),
        new BodyMailCreator("mail message"),
        new FooterMailCreator("footer"),
        new AttachmentsMailCreator(" attch 1"),
        new AttachmentsMailCreator(" attch 2"),
        new AttachmentsMailCreator(" attch 2")
    );


    Mail mail = chain.doCreateMailPart(new Mail());

    System.out.println(mail);

  }
}
