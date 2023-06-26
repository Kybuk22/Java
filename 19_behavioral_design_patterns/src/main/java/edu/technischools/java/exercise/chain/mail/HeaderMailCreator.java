/*
 * This item contains information that is the confidential, proprietary
 * and trade secret information of IGT or its affiliates and may be exempt from disclosure under applicable law.
 *
 * © 2023 IGT Global Solutions Corporation.
 *
 * @author <michal.taborowski@igt.com>
 */
package edu.technischools.java.exercise.chain.mail;

public class HeaderMailCreator implements MailPartCreator {

  private String header;

  public HeaderMailCreator(String header) {
    this.header = header;
  }

  @Override
  public Mail createMailPart(Mail mail, MailCreatorChain chain) {
    mail.setHeader(this.header);

    return chain.doCreateMailPart(mail);
  }
}
